package welp.poc;
import java.lang.Math;
import java.lang.StringBuilder;

public class Calculator {
    public enum Operator {
        ADDITION,
        SUBTRACTION,
        MULTIPLICATION
    }
    BigNum numA;
    BigNum numB;
    BigNum numAns;
    Operator currentOperation;

    public void calculate(BigNum num1, Operator op, BigNum num2) {
        numA = num1;
        numB = num2;
        currentOperation = op;

        BigNum result;

        switch (op) {
            case ADDITION:
                if(num1.numSign == num2.numSign) {
                    result = add(num1, num2);
                } else {
                    result = subtract(num1, num2);
                }
                break;
            case SUBTRACTION:
                if(num1.numSign == num2.numSign) {
                    result = subtract(num1, num2);
                    if(num2.compareAbsValue(num1)>=0){
                        result.switchSign();
                    }
                } else {
                    result = add(num1, num2);
                }
                break;
            case MULTIPLICATION:
                result = multiply(num1, num2);
                if(num1.numSign != num2.numSign) {
                    result.switchSign();
                }
                break;
            default:
                throw new java.lang.UnsupportedOperationException("not implemented yet.");
        }

        numAns = result;
    }

    public String formattedResult(){
        String result = String.format("%s %s %s = %s",
                numA.formatNum(),
                getOperator(),
                numB.formatNum(),
                numAns.getValue()
                );
        return result;
    }

    public BigNum add(BigNum num1, BigNum num2) {
        //throw new java.lang.UnsupportedOperationException("not implemented yet.");
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(num1.numString.length(), num2.numString.length());
        int carry = 0;
        for (int i = 0; i < maxLen + 1; i++) {
            int a1 = 0;
            int a2 = 0;
            if (i < num1.numString.length()) {
                a1 = Character.getNumericValue(num1.numString.charAt(num1.numString.length()-1-i));
            }
            if (i < num2.numString.length()) {
                a2 = Character.getNumericValue(num2.numString.charAt(num2.numString.length()-1-i));
            }
            int sum = (a1 + a2 + carry) % 10;
            carry = (int) ((a1 + a2 + carry) / 10);
            sb.insert(0, String.valueOf(sum));
        }
        return new BigNum(num1.numSign, sb.toString());
    }

    public BigNum subtract(BigNum num1, BigNum num2){
        //throw new java.lang.UnsupportedOperationException("not implemented yet.");
        BigNum largerNum = num1;
        BigNum smallerNum = num2;
        if(num1.compareAbsValue(num2)<0){
            largerNum = num2;
            smallerNum = num1;
        }
        StringBuilder sb = new StringBuilder();
        int maxLen = Math.max(num1.numString.length(), num2.numString.length());
        int carry = 0;
        int diff;
        for (int i = 0; i < maxLen; i++) {
            int a1 = 0;
            int a2 = 0;
            if (i < largerNum.numString.length()) {
                a1 = Character.getNumericValue(largerNum.numString.charAt(largerNum.numString.length()-1-i));
            }
            if (i < smallerNum.numString.length()) {
                a2 = Character.getNumericValue(smallerNum.numString.charAt(smallerNum.numString.length()-1-i));
            }
            if(a1-a2-carry >= 0){
                diff = a1-a2-carry;
                carry = 0;
            } else {
                diff = a1+10-a2-carry;
                carry = 1;
            }
            sb.insert(0, String.valueOf(diff));
        }
        return new BigNum(largerNum.numSign, sb.toString());
    }

    public BigNum multiply(BigNum num1, BigNum num2) {
        //throw new java.lang.UnsupportedOperationException("not implemented yet.");
        BigNum result = new BigNum("","0");
        for (int i = 0; i < num2.numString.length(); i++) {
            StringBuilder sb = new StringBuilder();
            int carry = 0;
            int a2 = Character.getNumericValue(num2.numString.charAt(num2.numString.length() - 1 - i));
            for (int j = 0; j < num1.numString.length() + 1; j++) {
                int a1 = 0;
                if (j < num1.numString.length()) {
                    a1 = Character.getNumericValue(num1.numString.charAt(num1.numString.length() - 1 - j));
                }
                int digit = (a1 * a2 + carry) % 10;
                carry = (int) ((a1 * a2 + carry) / 10);
                sb.insert(0, String.valueOf(digit));
            }
            for(int k = 0; k<i; k++) {
                sb.append("0");
            }
            result = add(result, new BigNum("", sb.toString()));
        }
        return result;
    }

    private String getOperator() {
        String result = "";
        switch(currentOperation) {
            case ADDITION -> {
                result = "+";
                break;
            }
            case SUBTRACTION -> {
                result = "-";
                break;
            }
            case MULTIPLICATION -> {
                result = "x";
                break;
            }
        }

        return result;
    }
}

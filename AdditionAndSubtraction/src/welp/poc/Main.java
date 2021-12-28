package welp.poc;

import java.lang.Math;
import java.lang.StringBuilder;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Big Number Calculator");

        BigNum num1 = new BigNum("-567");
        BigNum num2 = new BigNum("567");
        BigNum num3 = new BigNum("0");

        StringBuilder sb = new StringBuilder();

        int maxLen = Math.max(num1.numString.length(), num2.numString.length());
        if(num1.numSign == num2.numSign) {
            add(sb, maxLen, num1.numString, num2.numString);
            num3.setValue("+", sb.toString());
            if (num1.numSign == "-") {
                num3.switchSign();
            }
        } else {
            if(num1.compareAbsValue(num2) >= 0){
                subtract(sb, maxLen, num1.numString, num2.numString);
                num3.setValue(num1.numSign, sb.toString());
            } else {
                subtract(sb, maxLen, num2.numString, num1.numString);
                num3.setValue(num2.numSign, sb.toString());
            }
        }

        String sign1 = num1.numSign;
        String sign2 = num2.numSign;
        if(sign1 == "+"){
            sign1 = "";
        }
        System.out.format("%s%s %s %s = %s\n", sign1, num1.numString, sign2, num2.numString, num3.getValue());
    }

//    public static BigNum getLargerNum(BigNum num1, BigNum num2){
//        BigNum result = num1;
//        if(num2.numString.length() > num1.numString.length()) {
//            result = num2;
//        }
//        else if(num1.numString.length() == num2.numString.length()){
//            for(int i=0; i<num1.numString.length(); i++){
//                if(Character.getNumericValue(num2.numString.charAt(i))>Character.getNumericValue(num1.numString.charAt(i))){
//                    result = num2;
//                    break;
//                } else if(Character.getNumericValue(num1.numString.charAt(i))>Character.getNumericValue(num2.numString.charAt(i))){
//                    break;
//                }
//            }
//        }
//        return result;
//    }

    public static void add(StringBuilder sb, int maxLen, String num1, String num2){
        int carry = 0;
        for (int i = 0; i < maxLen+1; i++) {
            int a1 = 0;
            int a2 = 0;
            if (i < num1.length()) {
                String sa1 = num1.substring(num1.length() - i - 1, num1.length() - i);
                //System.out.format("sa1 = %s\n", sa1);
                a1 = Integer.parseInt(sa1);
            }
            if (i < num2.length()) {
                String sa2 = num2.substring(num2.length() - i - 1, num2.length() - i);
                //System.out.format("sa2 = %s\n", sa2);
                a2 = Integer.parseInt(sa2);
            }
            int sum = (a1 + a2 + carry) % 10;
            carry = (int) ((a1 + a2 + carry) / 10);
            sb.insert(0, String.valueOf(sum));
        }
    }

    public static void subtract(StringBuilder sb, int maxLen, String largerNum, String smallerNum){
        int carry = 0;
        int diff;
        for (int i = 0; i < maxLen; i++) {
            int a1 = 0;
            int a2 = 0;
            if (i < largerNum.length()) {
                a1 = Character.getNumericValue(largerNum.charAt(largerNum.length()-1-i));
            }
            if (i < smallerNum.length()) {
                a2 = Character.getNumericValue(smallerNum.charAt(smallerNum.length()-1-i));
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
    }

}


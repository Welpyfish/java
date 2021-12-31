package welp.poc;

import java.lang.Math;
import java.util.Random;
import java.lang.StringBuilder;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Big Number Calculator");

        BigNum bn1 = new BigNum("-1234");
        BigNum bn2 = new BigNum("-5678");

        Calculator calc = new Calculator();
        for(int i=0; i<6; i++) {
            calc.calculate(new BigNum(generateBigNumber(20)), generateOperator(), new BigNum(generateBigNumber(20)));
            System.out.println(calc.formattedResult());
        }
    }

    private static String generateBigNumber(int maxLen) {
        StringBuilder sb = new StringBuilder();
        int len = (int)Math.floor(Math.random() * maxLen + 1);
        for(int i = 0; i < len; i++) {
            int min = '0';
            int max = '9';
            char a = (char)Math.floor(Math.random() * (max - min + 1)+min);
            sb.append(a);
        }
        if (sb.charAt(0) == '0') {
            int min = '1';
            int max = '9';
            char a = (char)Math.floor(Math.random() * (max - min + 1)+min);
            sb.setCharAt(0, a);
        }
        int sign = (int)Math.floor(Math.random() * 10 + 1);
        sb.insert(0, sign > 5 ? "-" : "");
        return sb.toString();
    }

    private static Calculator.Operator generateOperator() {
        Calculator.Operator result;
        int randomNum = (int)Math.floor(Math.random() * 3);
        if(randomNum == 0){
            result = Calculator.Operator.ADDITION;
        } else if(randomNum == 1){
            result = Calculator.Operator.SUBTRACTION;
        } else{
            result = Calculator.Operator.MULTIPLICATION;
        }
        return result;
    }
}


package welp.poc;

import java.lang.Math;
import java.util.Random;
import java.lang.StringBuilder;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Big Number Calculator");
        java.util.Date dtStart=new java.util.Date();
        Test3(100000, 100);
        java.util.Date dtStop=new java.util.Date();
        long diff = dtStop.getTime() - dtStart.getTime();
        System.out.print("This calculation took " + String.valueOf(diff) + " ms");
    }

    private static void Test1(long count, int maxlen) {
        Calculator calc = new Calculator();
        for(long i=0; i<count; i++) {
            calc.calculate(new BigNum(generateBigNumber(maxlen)), Calculator.Operator.ADDITION, new BigNum(generateBigNumber(maxlen)));
            //System.out.println(String.valueOf(i+1) + "." + calc.formattedResult());
        }
    }

    private static void Test2(long count, int maxlen) {
        Calculator calc = new Calculator();
        for(long i=0; i<count; i++) {
            calc.calculate(new BigNum(generateBigNumber(maxlen)), Calculator.Operator.SUBTRACTION, new BigNum(generateBigNumber(maxlen)));
            //System.out.println(String.valueOf(i+1) + "." + calc.formattedResult());
        }
    }

    private static void Test3(long count, int maxlen) {
        Calculator calc = new Calculator();
        for(long i=0; i<count; i++) {
            calc.calculate(new BigNum(generateBigNumber(maxlen)), Calculator.Operator.MULTIPLICATION, new BigNum(generateBigNumber(maxlen)));
            //System.out.println(String.valueOf(i+1) + "." + calc.formattedResult());
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


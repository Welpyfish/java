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

        for(int i=0; i<100; i++) {
            Calculator calc = new Calculator();
            calc.calculate(new BigNum(generateBigNumber(50)), generateOperator(), new BigNum(generateBigNumber(20)));
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
        return (int)Math.floor(Math.random() * 100 ) > 50 ? Calculator.Operator.SUBTRACTION : Calculator.Operator.ADDITION;
    }
}


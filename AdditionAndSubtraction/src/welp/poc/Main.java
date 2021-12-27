package welp.poc;

import java.lang.Math;
import java.lang.StringBuilder;

public class Main
{
    public static void main(String[] args) {
        System.out.println("Hello World");

        String sign1 = "+";
        String num1 = "159";
        String sign2 = "+";
        String num2 = "345";
        StringBuilder sb = new StringBuilder();

        int maxLen = Math.max(num1.length(), num2.length());
        int carry = 0;
        if(sign1 == "+" && sign2 == "+") {
            add(sb, maxLen, num1, num2, carry);
        }
        if(sign1 == "-" && sign2 == "-") {
            add(sb, maxLen, num1, num2, carry);
        }

        if(sign1 == "+"){
            sign1 = "";
        }
        System.out.format("%s%s %s %s = %s\n", sign1, num1, sign2, num2, sb.toString());
    }

    public static String getLargerNum(String num1, String num2){
        String result = num1;
        if(num2.length() > num1.length()) {
            result = num2;
        }
        else if(num1.length() == num2.length()){
            for(int i=0; i<num1.length(); i++){
                if(Character.getNumericValue(num2.charAt(i))>Character.getNumericValue(num1.charAt(i))){
                    result = num2;
                    break;
                } else if(Character.getNumericValue(num1.charAt(i))>Character.getNumericValue(num2.charAt(i))){
                    break;
                }
            }
        }
        return result;
    }

    public static void add(StringBuilder sb, int maxLen, String num1, String num2, int carry){
        for (int i = 0; i < maxLen; i++) {
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

}


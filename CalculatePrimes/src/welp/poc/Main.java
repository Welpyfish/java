package welp.poc;

import java.lang.Math;
import java.util.ArrayList;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main
{
    public static void main(String[] args) {
        //There are 5761455 primes less than 100000000
        //This calculation takes ~2400 ms
        sieveOfEratosthenes();
    }

    public static void sieveOfEratosthenes(){
        java.util.Date dtStart=new java.util.Date();
        int maxNumber = 100000000;
        int [] list = new int[maxNumber+1];

        for (int i=2; i<=maxNumber; i++){
            list[i] = i;
        }
        for (int i=2; i<=maxNumber; i++){
            if(list[i] != 0){
                int prime = list[i];
                if(((long)prime*prime) <= maxNumber) {
                    for (int a = prime * prime; a <= maxNumber; a=a+prime) {
                        list[a] = 0;
                    }
                } else {
                    break;
                }
            }
        }
        java.util.Date dtStop=new java.util.Date();
        long diff = dtStop.getTime() - dtStart.getTime();
        int numOfPrimes = 0;
        for (int i=0; i<=maxNumber; i++){
            if(list[i] != 0){
                numOfPrimes++;
                System.out.print(String.valueOf(list[i]) + ", ");
            }
        }
        System.out.println("There are " + String.valueOf(numOfPrimes) + " primes less than " + String.valueOf(maxNumber));
        System.out.print("This calculation took " + String.valueOf(diff) + " ms");
    }

    public static void checkDivisibility() {
        System.out.println("Hello World");
        java.util.Date dtStart=new java.util.Date();

        int maxNumber = 20000;
        ArrayList<Integer> primeNumberList = new ArrayList<Integer>();
        primeNumberList.add(2);

        for(int i = 3; i < maxNumber; i=i+2) {
            boolean isPrime = true;
            int sqrt = (int)Math.sqrt(i);
            for (int j = 0; j < primeNumberList.size(); j++) {
                int prime = primeNumberList.get(j);
                if (prime <= sqrt && (i % prime) == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumberList.add(i);
            }
        }

        java.util.Date dtStop=new java.util.Date();
        long diff = dtStop.getTime() - dtStart.getTime();

        if (!primeNumberList.isEmpty()) {
            System.out.println("Found " + String.valueOf(primeNumberList.size()) + " prime numbers in " + String.valueOf(maxNumber)
                    + "(" + String.valueOf(diff) + " ms)");

            for(int i=0; i < primeNumberList.size(); i++) {
                System.out.print(String.valueOf(primeNumberList.get(i)) + ",");
            }

            System.out.println("Found " + String.valueOf(primeNumberList.size()) + " prime numbers in " + String.valueOf(maxNumber)
                    + "(" + String.valueOf(diff) + " ms)");
        }


    }
}

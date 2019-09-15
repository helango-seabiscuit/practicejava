package com.hemalatha.IK.arrays;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by helangovan on 2/19/17.
 */
public class PrimeCheck {


        private static Set<Integer> primes;
        public static void main(String args[] ) throws Exception {
            primes = new HashSet<>();
            Scanner in = new Scanner(System.in);
            int num = Integer.parseInt(in.nextLine().trim());
            System.out.println(isPrime(num));
        }

        public static boolean isPrime(int num){
            if(primes.contains(num)){
                return true;
            }
            if(checkPrime(num)){
                primes.add(num);
                return true;
            }
            return false;
        }

        public static boolean checkPrime(int num){
            int end = Double.valueOf(Math.sqrt(num)).intValue();
            for(int i=2;i<=end;i++){
                int div = num/i;
                int rem = num-(i*div);
                if(rem==0){
                    return false;
                }
            }
            return true;
        }
    }


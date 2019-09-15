package com.hemalatha.interview.general;

/**
 * Created by helangovan on 1/25/17.
 */
public class ReverseInteger {

    public static void main(String[] args) {

        System.out.println(reverse(1534236469));

    }

    public static int reverse(int x) {
        boolean isNegative = x<0?true:false;
        if(isNegative){
            x= x*-1;
        }
        int mod = 0;
        int res = 0;
        int temp = 0;
        while(x>0 && res < Integer.MAX_VALUE){
            mod = x%10;
            x = x/10;
            temp = (res*10)+mod;
            if((temp-mod)/10 !=res){
                return  0;
            }
            res = temp;

        }

        return isNegative?-res:res;

    }
}

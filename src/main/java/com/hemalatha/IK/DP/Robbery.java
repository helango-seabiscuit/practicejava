package com.hemalatha.IK.DP;

/**
 * Created by helangovan on 4/4/17.
 */
public class Robbery {

    //http://codercareer.blogspot.com/2013/02/no-44-maximal-stolen-values.html
    static int maxStolenValue(int[] arrHouseValues) {
        int[] d = new int[arrHouseValues.length];

        for(int i=0;i<arrHouseValues.length;i++){
            d[i]= arrHouseValues[i];
            for(int j=i-2;j>=0;j--){
                if(d[j]+arrHouseValues[i]>d[i]){
                    d[i] = d[j]+arrHouseValues[i];
                }
            }
        }
        return d[arrHouseValues.length-1];

    }

}

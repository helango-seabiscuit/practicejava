package com.hemalatha.IK.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by helangovan on 2/14/17.
 */
public class ThreeSumProblem {

    static String[] printTriplets(int[] intArr) {
        List<String> res = new ArrayList<>();
        Arrays.sort(intArr);

        for(int i=0;i<intArr.length-2;i++){
            if(i==0 || intArr[i] > intArr[i-1]){
                int k = intArr.length-1;
                int j=i+1;
                while(j<k){
                    if(intArr[i]+intArr[j]+intArr[k]==0){
                        String s = intArr[j]+","+intArr[k]+","+intArr[i];
                        res.add(s);
                        j++;
                        k--;
                        while(j<k && intArr[j]==intArr[j-1])
                            j++;
                        while(j<k && intArr[k]==intArr[k+1])
                            k--;
                    }else if(intArr[i]+intArr[j]+intArr[k]<0){
                        j++;
                    }else{
                        k--;
                    }
                }
            }
        }
        String resStr [] = new String[res.size()];
        for(int i=0;i<res.size();i++){
            resStr[i]=res.get(i);
        }
        return resStr;

    }
}

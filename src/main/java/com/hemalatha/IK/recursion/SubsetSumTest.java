package com.hemalatha.IK.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by helangovan on 2/2/17.
 */
public class SubsetSumTest {

    public static  boolean subsetSumExists(Set<Integer> set,int target){
        if(set.isEmpty()){
            return target==0;
        }else{
            int elem = set.iterator().hasNext()?set.iterator().next():0;
            set.remove(elem);
            return  subsetSumExists(set,target) || subsetSumExists(set,target-elem);
        }
    }

    public static void main(String[] args) {
        Integer arr[] = new Integer[]{3,4,5};
        Set<Integer> set = new HashSet<>();
        set.addAll(Arrays.asList(arr));
        System.out.println(subsetSumExists(set,7));
    }
}

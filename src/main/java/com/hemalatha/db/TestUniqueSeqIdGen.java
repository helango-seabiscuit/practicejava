package com.hemalatha.db;

import java.util.Arrays;
import java.util.Collection;

public class TestUniqueSeqIdGen {

    public static void main(String[] args) {
        int shardId = 4;
        int nextSeq = 7;
        int result = shardId;
        result = result << 1;
        System.out.println("Shifted Shardid: " +result);
        System.out.println("Next Seq :" +nextSeq);
        result = result | nextSeq;
        System.out.println("Final Seq: "+result);

        testArrayCreation();
    }

    private static  void testArrayCreation(){
        Collection<String> names = Arrays.asList("one","two","three");
        String[] arr = names.toArray(new String[0]);
        System.out.println(arr.length);
        System.out.println(Arrays.deepToString(arr));
    }
}

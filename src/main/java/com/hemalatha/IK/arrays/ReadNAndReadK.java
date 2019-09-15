package com.hemalatha.IK.arrays;

/**
 * Created by helangovan on 2/19/17.
 */
public class ReadNAndReadK {

    private static final int K=8;
    public int readN(char[] output,int N){
        int totalRead = 0;
        int readOne = readK(output);
        if(readOne<=N){
            return readOne;
        }
        totalRead +=readOne;
        N = N-readOne;
        int count = N/readOne;
        for(int i=0;i<count;i++){
            int readTwo = readK(output);
            totalRead+=readTwo;
            if(readTwo<N){
                break;
            }
        }
        int remaining = N-(readOne*count);
        if(remaining>0){
            totalRead+=readK(output);
        }
        return totalRead;

    }

    public int readK(char[] output){
        //already implemented
        return K;
    }
}

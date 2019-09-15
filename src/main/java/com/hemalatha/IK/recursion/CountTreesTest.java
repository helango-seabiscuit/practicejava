package com.hemalatha.IK.recursion;

/**
 * Created by helangovan on 3/2/17.
 */
public class CountTreesTest {

    static int countTrees(int iNodeCount) {
        if(iNodeCount<=1){
            return 1;
        }
        int sum=0;
        for(int i=1;i<=iNodeCount;i++){
            int left = countTrees(i-1);
            int right = countTrees(iNodeCount-i);
            sum+=left*right;
        }
        return sum;

    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(countTrees(n));
    }
}

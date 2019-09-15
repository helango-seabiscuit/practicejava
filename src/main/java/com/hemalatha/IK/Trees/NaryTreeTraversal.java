package com.hemalatha.IK.Trees;

/**
 * Created by helangovan on 2/12/17.
 */

/**
 * Given a K-ary tree, find it's height (can also be called 'Depth', or the length of the longest
 path).
 Input: A K-ary tree. You can hard-code your input. Construction is not a part of the test.
 Output: Positive integer, that is Height.
 (1<=K<=INT_MAX)
 */

class NodeN{
    private static final int NUM_CHILDREN=4;
    int val;
    NodeN [] children;
    NodeN(int val){
        this.val = val;
        children = new NodeN[NUM_CHILDREN];
    }
}

public class NaryTreeTraversal {

    public static void main(String[] args) {
        NodeN root = new NodeN(5);
        NodeN n1 = new NodeN(6);
        NodeN n2 = new NodeN(7);
        NodeN n3 = new NodeN(8);
        NodeN n4 = new NodeN(9);
        NodeN n5 = new NodeN(10);
        NodeN n6 = new NodeN(11);
        root.children[0] = n1;
        root.children[1] = n2;
        root.children[2] = n3;
        root.children[3] = n4;
        n1.children[0] = n5;
        n5.children[0] = n6;
        System.out.println(maxPathLength(root));

    }

    public static int maxPathLength(NodeN root){
        if(root==null){
            return 0;
        }
        int [] max = new int[root.children.length];
        for(int i=0;i< root.children.length;i++){
            max[i] = maxPathLength(root.children[i]);
        }
        return  max(max)+1;

    }

    public static int max(int[] max){
        int high = Integer.MIN_VALUE;
        for(Integer i:max){
            if(i>high){
                high = i;
            }
        }
        return  high;
    }
}

package com.hemalatha.IK.Trees;

/**
 * Created by helangovan on 3/12/17.
 */
//https://leetcode.com/contest/leetcode-weekly-contest-23/problems/construct-binary-tree-from-string/
    //CONSTRUCT BINARY TREE FROM STRING
    //
public class ConstructTreeFromString {

    private static int index=0;
    public static void main(String[] args) {
        String s="4(2(3)(1))(6(5))";
        Node r = build(s.toCharArray());
        inOrder(r);
    }

    public static Node build(char[] arr){
        int num=0;
        while(Character.isDigit(arr[index])){
            num = (num*10+arr[index]-48);
            index++;
        }

        Node node = new Node(num);
        if(arr[index]=='('){
            index++;
            node.left = build(arr);
            index++;
        }

        if(arr[index]=='('){
            index++;
            node.right = build(arr);
            index++;
        }
        return node;
    }

    public static void inOrder(Node root){
        if(root==null){
            return;
        }
         inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
}

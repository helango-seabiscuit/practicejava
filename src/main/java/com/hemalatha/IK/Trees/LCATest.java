package com.hemalatha.IK.Trees;


import java.util.Scanner;
import java.util.StringTokenizer;

public class LCATest {

    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val){
            this.val = val;
        }
    }

    static Node createTree(String data){
        if(data==null || data.length()==0){
            return null;
        }
        StringTokenizer st = new StringTokenizer(data," ");
        return deserialize(st);
    }

    static Node deserialize(StringTokenizer st){
        if(!st.hasMoreTokens()){
            return null;
        }
        String s = st.nextToken();
        if(s.equals("#")){
            return null;
        }
        Node root = new Node(Integer.valueOf(s));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        String str;
        try{
            str = in.nextLine();
        }catch (Exception e){
            str = null;
        }
        int n1 = Integer.parseInt(in.nextLine().trim());
        int n2 = Integer.parseInt(in.nextLine().trim());
        Node root = createTree(str);
        Node res = findLCA(root,n1,n2);
        System.out.println(res.val);
    }

    static Node findLCA(Node root,int n1,int n2){
        if(root==null){
            return null;
        }

        if(root.val==n1 || root.val==n2){
            return root;
        }
        Node left = findLCA(root.left,n1,n2);
        Node right = findLCA(root.right,n1,n2);

        if(left!=null && right!=null){
            return root;
        }

        return left==null?right:left;
    }
}

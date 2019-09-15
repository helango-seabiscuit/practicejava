package com.hemalatha.IK.Trees;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MergeTwoTrees {

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
        int size1 = Integer.parseInt(in.nextLine().trim());
        String str1;
        try{
            str1 = in.nextLine();
        }catch (Exception e){
            str1 = null;
        }
        Node root1 = createTree(str1);
        int size2 = Integer.parseInt(in.nextLine().trim());
        String str2;
        try{
            str2 = in.nextLine();
        }catch (Exception e){
            str2 = null;
        }
        Node root2 = createTree(str2);
        Node res = mergeTrees(root1,root2);
        printInorder(res);
        System.out.println();
        printLevelByLevel(res);
    }

    static  void postOrderRecursion(Node root){
        if(root==null){
            return;
        }
        postOrderRecursion(root.left);
        postOrderRecursion(root.right);
        System.out.print(root.val+" ");
    }
    static  void printInorder(Node root){
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.val+" ");
        printInorder(root.right);

    }

    static void printLevelByLevel(Node root){
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        q.offer(new Node(Integer.MIN_VALUE));
        while (!q.isEmpty()){
            Node temp = q.poll();
            if(temp.val!=Integer.MIN_VALUE) {
                if (temp.left != null) {
                    q.offer(temp.left);
                }
                if (temp.right != null) {
                    q.offer(temp.right);
                }
                System.out.print(temp.val+" ");
            }else{
                if(!q.isEmpty()) {
                    q.offer(new Node(Integer.MIN_VALUE));
                }
                System.out.println();
            }
        }
    }

    static Node mergeTrees(Node n1, Node n2) {
        List<Node> list1 = new ArrayList<>();
        List<Node> list2 = new ArrayList<>();
        getSortedNodes(n1,list1);
        getSortedNodes(n2,list2);
        List<Node> mergeList = mergeSortedNodeList(list1,list2);
        return createTree(mergeList,0,mergeList.size()-1);

    }

    static void getSortedNodes(Node n1,List<Node> l1){
        if(n1==null){
            return;
        }
        getSortedNodes(n1.left,l1);
        l1.add(n1);
        getSortedNodes(n1.right,l1);
    }

    static List<Node> mergeSortedNodeList(List<Node> n1,List<Node> n2){
        int len1 = n1.size();
        int len2 = n2.size();
        int ptr1 = 0;
        int ptr2 = 0;
        List<Node> result = new ArrayList<>();
        while(ptr1<len1 && ptr2<len2){
            if(n1.get(ptr1).val < n2.get(ptr2).val){
                result.add(n1.get(ptr1));
                ptr1++;
            }else if(n1.get(ptr1).val > n2.get(ptr2).val){
                result.add(n2.get(ptr2));
                ptr2++;
            }else{
                result.add(n1.get(ptr1));
                result.add(n2.get(ptr2));
                ptr1++;
                ptr2++;
            }
        }

        if(ptr1<len1){
            while(ptr1<len1){
                result.add(n1.get(ptr1));
                ptr1++;
            }
        }
        if(ptr2<len2){
            while(ptr2<len2){
                result.add(n2.get(ptr2));
                ptr2++;
            }
        }
        return result;
    }

    static Node createTree(List<Node> list, int start, int end){
        if(start>end){
            return null;
        }
        int mid = (start+end)/2;
        Node n = list.get(mid);
        n.left = createTree(list,start,mid-1);
        n.right = createTree(list,mid+1,end);
        return n;

    }
}

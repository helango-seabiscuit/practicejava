package com.hemalatha.IK.Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by helangovan on 2/18/17.
 */
public class UnivalSubTrees {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size = Integer.parseInt(in.nextLine().trim());
        String str;
        try{
            str = in.nextLine();
        }catch (Exception e){
            str = null;
        }
        LCATest.Node root = LCATest.createTree(str);
        int res = findSingleValueTrees(root);
        System.out.println(res);
    }




    static Map<Integer,Integer> count = new HashMap<>();
    static int findSingleValueTrees(LCATest.Node n) {
        int rootVal =findUnival(n);
        Integer rootCnt = count.get(rootVal);
        if(rootCnt!=null){
            count.put(rootVal,rootCnt+1);
        }else{
            count.put(rootVal,1);
        }
       Set<Integer> keys = count.keySet();
        int maxkey=-1;
        int maxValue=-1;
        for (Integer k:keys){
            int chk = count.get(k);
            if(maxValue<chk){
                maxkey = k;
                maxValue = chk;
            }
        }
        return maxValue;

    }
    static int findUnival(LCATest.Node r){
        if(r==null){
            return -1;
        }
        int l = findUnival(r.left);
        int rt = findUnival(r.right);
        if(l!=-1){
            if(count.get(l)!=null){
                int c = count.get(l);
                count.put(l,c+1);
            }else{
                count.put(l,1);
            }
        }
        if(rt!=-1){
            if(count.get(rt)!=null){
                int ct = count.get(rt);
                count.put(rt,ct+1);
            }else{
                count.put(rt,1);
            }
        }
        return r.val;
    }

    static int counter;
    static int findSingleValueTrees(Node n) {
        findUnival(n);
        return counter;

    }

    static boolean findUnival(Node root){
        if(root==null){
            return true;
        }

        boolean l = findUnival(root.left);
        boolean r = findUnival(root.right);
        if(l&& r){
            Node lsub  = root.left;
            Node rsub = root.right;
            if(lsub==null && rsub==null){
                counter++;
                return true;
            }else if(lsub!=null && rsub!=null && lsub.val == root.val && rsub.val==root.val){
                counter++;
                return true;
            }else if(lsub!=null && rsub==null && lsub.val==root.val){
                counter++;
                return true;
            }else if(rsub!=null && lsub==null && rsub.val == root.val){
                counter++;
                return true;
            }
        }
        return false;
    }


}

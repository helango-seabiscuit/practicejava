package com.hemalatha.company.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

//https://leetcode.com/discuss/interview-question/1367130/doordash-phone-interview
public class Doordash {

    public static class Node {
        String key;
        int value;
        boolean isActive;
        List<Node> children;

        public Node(String key, int value, boolean isActive) {
            this.key = key;
            this.value = value;
            this.isActive = isActive;
            this.children = new ArrayList<>();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return value == node.value && key.equals(node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
    }

    public static int getModifiedItems(Node oldMenu, Node newMenu) {
        if(oldMenu == null && newMenu == null){
            return 0;
        }
        if(oldMenu == null || newMenu == null ){
            return oldMenu == null? newMenu.children.size()+1: oldMenu.children.size()+1;
        }
        if(!oldMenu.equals(newMenu)){
           return 1;
        }
        int count = 0;
        Map<String,Node> childrenOld = getChildren(oldMenu);
        Map<String,Node> childrenNew = getChildren(newMenu);
        for(String key:childrenOld.keySet()){
            count += getModifiedItems(childrenOld.get(key),childrenNew.getOrDefault(key,null));
        }

        for(String k:childrenNew.keySet()){
            if(!childrenOld.containsKey(k)){
                count+= getModifiedItems(null,childrenNew.get(k));
            }
        }
        return count;
    }

    private static Map<String,Node> getChildren(Node parent){
        Map<String,Node> map = new HashMap<>();
        for(Node n:parent.children){
            map.put(n.key,n);
        }
        return map;
    }

    public static void main(String[] args) {
/*
         Existing tree
            a(1, T)
          /         \
        b(2, T)   c(3, T)
      /       \
  d(4, T) e(5, T)

                New tree
                a(1, T)
             /          \
       b(2, T)         c(3, T)
      /                   \
 d(4, T)                   e(5, T)

 */

        Node a = new Node("a", 1, true);
        Node b = new Node("b", 2, true);
        Node c = new Node("c", 3, true);
        Node d = new Node("d", 4, true);
        Node e = new Node("e", 5, true);

        a.children.add(b);
      //  a.children.add(c);

        b.children.add(d);
        b.children.add(e);

        //c.children.add(g);

        Node a1 = new Node("a", 1, true);
        Node b1 = new Node("b", 2, true);
        Node c1 = new Node("c", 3, true);
        Node d1 = new Node("d", 4, true);
        Node e1 = new Node("e", 5, true);
        Node f1 = new Node("f", 6, true);
        Node g1 = new Node("g", 7, false);

        a1.children.add(b1);
        a1.children.add(c1);

        b1.children.add(d1);
        //b1.children.add(e1);
        //b1.children.add(f1);

        c1.children.add(e1);

        int count = getModifiedItems(a, a1);
        System.out.println("Changed Items are: " + count);
    }
}

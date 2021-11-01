package com.hemalatha.company.interview;

import java.util.ArrayList;
import java.util.List;

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
    }

    public static int getModifiedItems(Node oldMenu, Node newMenu) {
        int count=0;
        return count;
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
        Node g = new Node("g", 7, true);

        a.children.add(b);
        a.children.add(c);

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

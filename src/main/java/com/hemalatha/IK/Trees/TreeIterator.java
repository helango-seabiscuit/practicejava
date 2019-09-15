package com.hemalatha.IK.Trees;


import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator {

    Stack<Node> stack;
    Node root;
    Boolean isInorder;
    Boolean isPreOrder;

    TreeIterator(Node root){
        stack = new Stack<>();
        this.root = root;
        isInorder = true;
        isPreOrder = false;

    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Node next() {
     if(isInorder){
         return inOrderNext();
     }
     if(isPreOrder){
         return preOrderNext();
     }
     return null;

    }

    public Node inOrderNext(){
       if(stack.isEmpty()){
           pushLeftNode(root);
       }
       Node res = stack.pop();
        if(res.right!=null){
            pushLeftNode(res.right);
        }
        return res;
    }

    public void pushLeftNode(Node node){
        if(node!=null){
            stack.push(node);
            pushLeftNode(node.left);
        }
    }

    private Node preOrderNext() {
        if (stack.empty()) {	// at beginning of iterator
            stack.push(root);
        }
       Node res = stack.pop();
        // need to visit the left subtree first, then the right
        // since a stack is a LIFO, push the right subtree first, then
        // the left.  Only push non-null trees
        if (res.right!=null) {
           stack.push(res.right);
        }
        if (res.left!=null) {
           stack.push(res.left);
        }
        // may not have pushed anything.  If so, we are at the end
        if (stack.isEmpty()) { // no more nodes to visit
            root = null;
        }
        return res;
    }

}

package com.icarusfrog.katas.interviewCake;

import java.util.*;
import java.lang.*;

public class LinkedListKthElement {
    public static void main(String[] args){
        Node a = new Node("Angel Food");
        Node b = new Node("Bundt");
        Node c = new Node("Cheese");
        Node d = new Node("Devil's Food");
        Node e = new Node("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        //System.out.println(getKthToLastNode(a, 0));
        System.out.println(getKthToLastNode(a, 2));

    }

    public static Node getKthToLastNode(Node root, int k){
        ArrayDeque<Node> stack = new ArrayDeque<>();

        for(int i = 0; i < k; i++){
            stack.push(new Node("null value"));
        }

        Node cursor = root;
        while(cursor != null){
            stack.push(cursor);
            stack.removeLast();
            cursor = cursor.next;
        }

        return stack.removeLast();
    }

    public static class Node {
        public String value;
        public Node next;

        public Node(String value, Node next){
            this.value = value;
            this.next = next;
        }

        public Node(String value) {
            this(value, null);
        }

        public String toString(){
            return this.value;
        }
    }
}

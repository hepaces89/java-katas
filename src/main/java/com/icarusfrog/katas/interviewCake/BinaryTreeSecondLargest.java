package com.icarusfrog.katas.interviewCake;

import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

/**
 * Sourced from: https://www.interviewcake.com/question/python/second-largest-item-in-bst
 * Write a function to find the 2nd largest element in a binary search tree. ↴
 */
public class BinaryTreeSecondLargest {
    public static void main(String[] args){
        Node root = buildBinarySearchTree(Arrays.asList(5,2,4,6,2,7));
        System.out.println(inOrderTraversal(root));
        System.out.println(preOrderTraversal(root));
        System.out.println(postOrderTraversal(root));
        System.out.println(root);

        System.out.println(getSecondLargestFromTree(root));


    }

    public static Integer getSecondLargestFromTree(Node root) {
        Integer secondLargest = null;
        Integer largest = null;
        Node cursor = root;
        if(cursor != null){
            while(cursor.children.get(1) != null){
                cursor = cursor.children.get(1);
            }
            largest = cursor.value;
            if(cursor.children.get(0) == null){
                secondLargest = cursor.parent.value;
            } else {
                secondLargest = cursor.children.get(0).value;
            }
        }
        return secondLargest;
    }

    public static List<Integer> inOrderTraversal(Node root){
        List<Integer> vals = new ArrayList<>();

        if(root != null){
            if(root.children.stream().filter((Node child) -> {return (child != null);}).collect(Collectors.toList()).size() == 0){
                //if leave node (all null children)
                vals.add(root.value);
            } else {
                List<Integer> lesserVals = inOrderTraversal(root.children.get(0));
                List<Integer> greaterVals = inOrderTraversal(root.children.get(1));
                lesserVals.addAll(vals);
                lesserVals.add(root.value);
                lesserVals.addAll(greaterVals);
                vals = lesserVals;
            }
        }

        return vals;
    }

    public static List<Integer> preOrderTraversal(Node root){
        List<Integer> vals = new ArrayList<>();

        if(root != null){
            if(root.children.stream().filter((Node child) -> {return (child != null);}).collect(Collectors.toList()).size() == 0){
                //if leave node (all null children)
                vals.add(root.value);
            } else {
                List<Integer> lesserVals = inOrderTraversal(root.children.get(0));
                List<Integer> greaterVals = inOrderTraversal(root.children.get(1));
                vals.add(root.value);
                vals.addAll(lesserVals);
                vals.addAll(greaterVals);
            }
        }

        return vals;
    }

    public static List<Integer> postOrderTraversal(Node root){
        List<Integer> vals = new ArrayList<>();

        if(root != null){
            if(root.children.stream().filter((Node child) -> {return (child != null);}).collect(Collectors.toList()).size() == 0){
                //if leave node (all null children)
                vals.add(root.value);
            } else {
                List<Integer> lesserVals = inOrderTraversal(root.children.get(0));
                List<Integer> greaterVals = inOrderTraversal(root.children.get(1));
                vals.addAll(lesserVals);
                vals.addAll(greaterVals);
                vals.add(root.value);
            }
        }

        return vals;
    }

    public static Node buildBinarySearchTree(List<Integer> inputs){
        Node root = null;

        if(inputs != null && inputs.size() > 0){
            for(Integer i : inputs){
                root = appendValueToBSTTree(root, i);
            }
        }

        return  root;
    }

    /**
     * This method doesn't drop duplicates from the tree.
     * @param root
     * @param value
     * @return
     */
    public static Node appendValueToBSTTree(Node root, Integer value){
        if(root == null){
            root = new Node(null, value);
        } else {
            Integer rootVal = root.value;
            if(value < rootVal){
                Node smallerChild = root.children.get(0);
                if(smallerChild == null){
                    root.children.set(0, new Node(root, value));
                } else {
                    appendValueToBSTTree(smallerChild, value);
                }
            }
            if(value >= rootVal){
                Node largerChild = root.children.get(1);
                if(largerChild == null) {
                    root.children.set(1, new Node(root, value));
                } else {
                    appendValueToBSTTree(largerChild, value);
                }
            }
        }

        return root;
    }

    public static class Node {
        public Node parent;
        public int value;
        public List<Node> children;
        public Node(Node parent, int value, List<Node> children){
            super();
            this.parent = parent;
            this.value = value;
            this.children = children;
        }

        public Node(Node parent, int value){
            this(parent, value, Arrays.asList(null, null));
        }

        private Integer generationsToNull(){
            Integer num = 0;
            Node cursor = this;
            while(cursor.parent != null){
                num = num + 1;
                cursor = cursor.parent;
            }
            return num;
        }

        public String toString(){
            StringBuilder tabs = new StringBuilder();
            for(int i = 0; i < this.generationsToNull(); i++){
                tabs.append("\t");
            }
            return "{value: " + this.value + ", children: " + "\n" + tabs.toString() + children + "\n}";
        }
    }
}

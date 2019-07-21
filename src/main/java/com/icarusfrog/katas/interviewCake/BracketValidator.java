package com.icarusfrog.katas.interviewCake;

import java.util.*;
import java.lang.*;

/***
 * You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets,
 * and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator.
 *
 * Let's say:
 *
 * '(', '{', '[' are called "openers."
 * ')', '}', ']' are called "closers."
 * Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.
 *
 * Examples:
 *
 * "{ [ ] ( ) }" should return True
 * "{ [ ( ] ) }" should return False
 * "{ [ }" should return False
 */

public class BracketValidator {
    public static void main (String[] input) {
        //Testing that the individual components work
//        System.out.println(isOpener('}'));
//        System.out.println(isOpener('('));
//
//        System.out.println(willClose('(', ')'));
//        System.out.println(willClose('[', ')'));

        System.out.println(areBracketsValid("{ [ ] ( ) }"));
        System.out.println(areBracketsValid("{ [ ( ] ) }"));
        System.out.println(areBracketsValid("{ [ }"));
        System.out.println(areBracketsValid(""));

    }

    public static boolean areBracketsValid(String input){
        input = input.trim();
        ArrayDeque<BracketToken> bracketStack = new ArrayDeque<BracketToken>();

        boolean bracketsValid = false;

        for(int i = 0; i < input.length(); i++){
            char cur = input.charAt(i);
            if(isOpener(cur)){
                bracketStack.push(new BracketToken(cur, i));
            }
            if(isCloser(cur)){
                BracketToken lastOpen = bracketStack.peek();
                if(willClose(lastOpen.character, cur)){
                    bracketStack.pop();
                } else {
                    System.out.println("\t>Error: invalid match " + cur + " at " + i + " against " + lastOpen.character + " @ " + lastOpen.position);
                    bracketStack.push(new BracketToken(cur, i));
                }
            }
        }

        if(bracketStack.isEmpty()){
            bracketsValid = true;
        }

        return  bracketsValid;

    }

    public static class BracketToken {
        public char character;
        public int position = 0;
        public BracketToken(char character, int position){
            this.character = character;
            this.position = position;
        }
    }

    public static boolean willClose(char lastOpen, char candidateClose){
        boolean validCloser = false;
        if(lastOpen == '{' && candidateClose=='}'){
            validCloser = true;
        }

        if(lastOpen == '(' && candidateClose==')'){
            validCloser = true;
        }

        if(lastOpen == '[' && candidateClose==']'){
            validCloser = true;
        }
        return validCloser;
    }

    public static List<Character> openers = Arrays.asList('{', '(', '[');
    public static List<Character> closers = Arrays.asList(')', '}', ']');
    public static boolean isOpener(char val){
        return openers.contains(val);
    }
    public static boolean isCloser(char val) {
        return closers.contains(val);
    }

}

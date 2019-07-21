package com.icarusfrog.katas.dailyCoding;

/**
 * Given a mapping of digits to letters (as in a phone number), and a digit string, return all possible letters the number could represent.
 * You can assume each valid number in the mapping is a single digit.
 *
 * For example if {“2”: [“a”, “b”, “c”], 3: [“d”, “e”, “f”], …} then “23” should return [“ad”, “ae”, “af”, “bd”, “be”, “bf”, “cd”, “ce”, “cf"].
 */

import org.springframework.util.Assert;

import java.util.*;
import java.lang.*;

public class NumberToLetterMapping {
    public static void main(String[] args){
        Map<String, List<String>> translationMap = new HashMap<>();
        translationMap.put("2", Arrays.asList("a", "b", "c"));
        translationMap.put("3", Arrays.asList("d", "e", "f"));

        List<String> possibleStringsFor2 = returnPossibleLetters(translationMap, "2");
        Assert.isTrue(possibleStringsFor2.containsAll(Arrays.asList("a", "b", "c")));
    }

    public static List<String> returnPossibleLetters(Map<String, List<String>> translationMap, String numberList){
        List<String> possibleStrings = new ArrayList<>();

        Stack<String> partials = new Stack<>();
        partials.push("");

        if(numberList == null || translationMap == null){
            throw new RuntimeException("Can not pass in null value");
        }

        do {
            String cur = partials.pop();
            Integer curIndex = cur.length();
            if(curIndex < numberList.length()){}
        } while(!partials.empty());

        return possibleStrings;
    }
}



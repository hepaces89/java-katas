package com.icarusfrog.katas.interviewCake;

/**
 * Write a method for doing an in-place shuffle of an array.
 *
 * The shuffle must be "uniform," meaning each item in the original array must have the same probability of ending up in each spot in the final array.
 *
 * Assume that you have a method getRandom(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.
 *
 * Sourced from: https://www.interviewcake.com/question/java/shuffle
 * Soln: https://www.geeksforgeeks.org/shuffle-a-given-array-using-fisher-yates-shuffle-algorithm/
 *
 */

import java.util.*;

public class InPlaceShuffle {
    public static Random random = new Random();
    public static void main(String[] args) {
//        for(int i = 0; i < 30; i++){
//            System.out.println(getRandom(5,6));
//        }

        int[] input = {1,2,3,4,5};
        shuffle(input);
        System.out.println(Arrays.toString(input));
    }

    public static void shuffle(int[] array){
        for(int targetPosition = array.length -1; targetPosition >0; targetPosition--){
            int sourcePosition = getRandom(0, targetPosition);
            int tempTarget = array[targetPosition];
            array[targetPosition] = array[sourcePosition];
            array[sourcePosition] = tempTarget;
        }
    }

    public static int getRandom(int floor, int ceiling){
        return floor + random.nextInt(ceiling - floor + 1);
    }
}

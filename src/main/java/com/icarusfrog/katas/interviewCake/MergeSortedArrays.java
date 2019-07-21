package com.icarusfrog.katas.interviewCake;

import java.util.*;

/**
 * Each order is represented by an "order id" (an integer).
 *
 * We have our lists of orders sorted numerically already, in lists. Write a function to merge our lists of orders into one sorted list.
 *
 * For example:
 *
 * <code>
 *     int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
 *     int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
 *
 *     System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
 *     // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
 * </code>
 *
 * Sourced from: https://www.interviewcake.com/question/java/merge-sorted-arrays
 */
public class MergeSortedArrays {
    public static void main(String[] args){
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
        System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
    }

    public static int[] mergeArrays(int[] array1, int[] array2){
        int[] result = new int[array1.length + array2.length];
        Integer index1 = null;
        Integer index2 = null;
        int resultIndex = 0;

        if(array1 != null && array1.length > 0){
            index1 = 0;
        }
        if(array2 != null && array2.length > 0){
            index2 = 0;
        }

        while(index1 != null || index2 != null){
            if(index1 == null){
                result[resultIndex++] = array2[index2];
                index2 = bumpIndex(index2, array2);
                break;
            }
            if(index2 == null){
                result[resultIndex++] = array1[index1];
                index1 = bumpIndex(index1, array1);
                break;
            }
            if(index1 != null && index2 != null){
                int a1Val = array1[index1];
                int a2Val = array2[index2];
                if(a1Val <= a2Val){
                    result[resultIndex++] = array1[index1];
                    index1 = bumpIndex(index1, array1);
                } else {
                    result[resultIndex++] = array2[index2];
                    index2 = bumpIndex(index2, array2);
                }
            }
        }

        return result;
    }

    public static Integer bumpIndex(Integer index, int[] array){
        if(index != null){
            index++;
            if(index >= array.length){
                index = null;
            }
            return index;
        } else {
            return null;
        }
    }
}

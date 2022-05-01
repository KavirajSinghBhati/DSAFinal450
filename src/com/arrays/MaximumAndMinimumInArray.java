package com.arrays;

/*
*
* Problem Statement: Given an integer array, find out the
* minimum and maximum element present using
* minimum comparisons.
*
*/

public class MaximumAndMinimumInArray {
    static class Pair {
        int min;
        int max;
    }

    static Pair approachOne(int[] nums, int n) {
        Pair minMax = new Pair();

        if (n == 1) {
            minMax.max = minMax.min = nums[0];
            return minMax;
        }
        if (nums[0] > nums[1]) {
            minMax.max = nums[0];
            minMax.min = nums[1];
        } else {
            minMax.max = nums[1];
            minMax.min = nums[0];
        }

        for (int i = 2; i < n; i++) {
            if (nums[i] > minMax.max)
                minMax.max = nums[i];
            if (nums[i] < minMax.min)
                minMax.min = nums[i];
        }
        return minMax;
    }

    static Pair approachTwo (int[] nums, int n) {
        Pair minMax = new Pair();
        int i;
        if (n % 2 == 0) {
            if (nums[0] > nums[1]) {
                minMax.max = nums[0];
                minMax.min = nums[1];
            } else {
                minMax.max = nums[1];
                minMax.min = nums[0];
            }
            i = 2;
        } else {
            minMax.min = minMax.max = nums[0];
            i = 1;
        }
        while (i < n - 1) {
            // pick elements in pair and
            // compare the pair with max and min so far
            if (nums[i] > nums[i + 1]) {
                if (nums[i] > minMax.max)
                    minMax.max = nums[i];
                if (nums[i + 1] < minMax.min)
                    minMax.min = nums[i + 1];
            } else {
                if (nums[i + 1] > minMax.max)
                    minMax.max = nums[i + 1];
                if (nums[i] < minMax.min)
                    minMax.min = nums[i];
            }
            i += 2;

            /* Increment the index by 2 as two
             elements are processed in loop */
        }
        return minMax;
    }

    public static void main(String[] args) {
        int[] arr = { 4, 7, 5, 1, 3 };
        //Pair minMax = approachOne(arr, arr.length);
        Pair minMax = approachTwo(arr, arr.length);
        System.out.println("Maximum: " + minMax.max + " and Minimum: " + minMax.min);
    }
}

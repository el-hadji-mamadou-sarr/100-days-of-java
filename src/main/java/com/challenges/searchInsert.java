package com.challenges;

import java.util.Arrays;

public class searchInsert {
    public static int searchInsert(int[] nums, int target) {
        int mid = nums.length / 2;
        int index = mid;
        int[] temp = nums.clone();
        while (temp[mid] != target && temp.length > 1) {
            if (temp[mid] > target) {
                temp = Arrays.copyOfRange(temp, 0, mid);
                index -= (temp.length / 2);

            } else {
                temp = Arrays.copyOfRange(temp, mid, temp.length);
                index += (temp.length / 2);
            }
            mid = temp.length / 2;
        }
        if (temp[mid] < target)
            return index;
        if (temp[mid] > target)
            return index > 0 ? index - 1 : 0;
        return index;
    }
}

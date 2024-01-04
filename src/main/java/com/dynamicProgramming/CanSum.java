package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static Map<Integer, Boolean> memo = new HashMap<>();

    public static Boolean canSum(int targetSum, int[] numbers) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum == 0)
            return true;
        if (targetSum < 0)
            return false;

        for (int i : numbers) {
            int nextSum = targetSum - i;
            if (canSum(nextSum, numbers) == true) {
                memo.put(nextSum, true);
                return true;
            }
        }
        memo.put(targetSum, false);
        return false;
    }
}

package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BestSum {
    public static Map<Integer, ArrayList<Integer>> memo = new HashMap<>();

    public static ArrayList<Integer> bestSum(int targetSum, int[] numbers) {
        if (memo.containsKey(targetSum)) {
            return memo.get(targetSum);
        }
        if (targetSum == 0)
            return new ArrayList<>();
        if (targetSum < 0)
            return null;
        ArrayList<Integer> shortestCombination = null;
        for (int num : numbers) {
            int remainer = targetSum - num;
            ArrayList<Integer> remainerArray = bestSum(remainer, numbers);
            if (remainerArray != null) {
                remainerArray.add(num);
                // carreful because remainerArray change for each recursion so i don't want to
                // store bad values in memo
                ArrayList<Integer> combination = new ArrayList<>(remainerArray);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }
        if (shortestCombination != null) {
            memo.put(targetSum, shortestCombination);
        }
        return shortestCombination;
    }
}

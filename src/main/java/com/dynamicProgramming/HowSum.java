package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HowSum {
    public static Map<Integer, ArrayList<Integer>> memo = new HashMap<>();

    public static ArrayList<Integer> howSum(int targetSum, int[] numbers) {
        if (memo.containsKey(targetSum))
            return memo.get(targetSum);
        if (targetSum < 0)
            return null;
        if (targetSum == 0)
            return new ArrayList<>();
        for (int num : numbers) {
            int remainer = targetSum - num;
            ArrayList<Integer> resultRemainer = howSum(remainer, numbers);
            if (resultRemainer != null) {
                resultRemainer.add(num);
                memo.put(remainer, resultRemainer);
                return resultRemainer;
            }
        }
        memo.put(targetSum, null);
        return null;
    }
}

package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonnacci {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonnacci(int val) {
        if (val <= 2)
            return 1;
        if (memo.containsKey(val))
            return memo.get(val);
        memo.put(val, fibonnacci(val - 1) + fibonnacci(val - 2));
        return memo.get(val);
    }
}

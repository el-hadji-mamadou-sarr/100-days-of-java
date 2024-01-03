package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Fibonnacci {

    private static Map<Integer, Integer> memo = new HashMap<>();

    public static int fibonnacci(int val) {
        if (val == 1 || val == 2)
            return 1;
        if (memo.containsKey(val))
            return memo.get(val);
        memo.put(val, fibonnaci(val-1) +fibonnaci(val-2));
        return memo.get(val);
    }
}

package com.dynamicProgramming;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Fibonnacci {

    private static Map<Integer, BigInteger> memo = new HashMap<>();

    public static BigInteger fibonnacci(int val) {
        if (val <= 2)
            return BigInteger.ONE;
        if (memo.containsKey(val))
            return memo.get(val);
        BigInteger res = fibonnacci(val - 1).add(fibonnacci(val - 2));
        memo.put(val, res);
        return res;
    }
}

package com.dynamicProgramming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GridTraveller {

    public static Map<String, BigInteger> memo = new ConcurrentHashMap<>();

    // calculate the number of ways to travel a 2D array from top left to top right.
    public static BigInteger gridTraveller(int n, int m) {

        if (n == 1 && m == 1)
            return BigInteger.ONE;
        if (n == 0 || m == 0)
            return BigInteger.ZERO;

        String arr1 = n + "," + m;
        String arr2 = m + "," + n;
        if (memo.containsKey(arr1) || memo.containsKey(arr2))
            return memo.get(arr1);

        BigInteger res = gridTraveller(n - 1, m).add(gridTraveller(n, m - 1));
        memo.put(arr1, res);
        memo.put(arr2, res);
        return res;

    }
}

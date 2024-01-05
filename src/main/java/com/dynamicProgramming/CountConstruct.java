package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountConstruct {

    public static Map<String, Integer> memo = new HashMap<>();

    public static int countConstruct(String target, String[] parts) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target == "")
            return 1;
        int count = 0;
        for (String part : parts) {
            if (target.startsWith(part)) {
                String suffix = target.substring(part.length());
                count += countConstruct(suffix, parts);
            }
        }
        memo.put(target, count);
        return count;
    }
}

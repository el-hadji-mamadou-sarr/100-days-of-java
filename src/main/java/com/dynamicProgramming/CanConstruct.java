package com.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
    public static Map<String, Boolean> memo = new HashMap<>();

    public static boolean canConstruct(String target, String[] parts) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target == "")
            return true;
        for (String part : parts) {
            if (target.startsWith(part)) {
                String suffix = target.substring(part.length());
                boolean res = canConstruct(suffix, parts);
                memo.put(suffix, res);
                return res;
            }
        }
        memo.put(target, false);
        return false;
    }
}

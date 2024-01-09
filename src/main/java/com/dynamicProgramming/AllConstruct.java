package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {
    public static Map<String, ArrayList<ArrayList<String>>> memo = new HashMap<>();

    public static ArrayList<ArrayList<String>> allConstruct(String target, String[] parts) {
        if (memo.containsKey(target))
            return memo.get(target);
        if (target == "")
            return new ArrayList<>();

        ArrayList<ArrayList<String>> constructions = new ArrayList<>();
        for (String elt : parts) {
            if (target.startsWith(elt)) {
                String suffix = target.substring(elt.length());
                ArrayList<ArrayList<String>> suffixWays = allConstruct(suffix, parts);
                if (suffixWays.isEmpty()) {
                    suffixWays.add(new ArrayList<>());
                }

                for (ArrayList<String> way : suffixWays) {
                    way.add(elt);
                    constructions.add(way);
                }
            }
        }
        memo.put(target, constructions);
        return constructions;
    }

}
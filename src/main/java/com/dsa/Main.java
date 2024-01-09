package com.dsa;

import com.dynamicProgramming.BestSum;
import com.dynamicProgramming.CanConstruct;
import com.dynamicProgramming.CountConstruct;
import com.dynamicProgramming.HowSum;
import com.dynamicProgramming.AllConstruct;

public class Main {

    public static void main(String[] args) {
        String[] parts = { "ab", "cd", "abcd" };
        String target = "abcd";
        System.out.println(AllConstruct.allConstruct(target, parts));
    }
}
package com.challenges;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int rest = 1;
        int i = digits.length - 1;
        while (i >= 0 && rest ==1 ) {
            if (digits[i] == 9){
                digits[i] = 0;
            }
            else {
                digits[i] += 1;
                rest = 0;
                
            }
            i--;
        }

        if (rest == 1) {
            int[] arr = new int[digits.length + 1];

            arr[0] = 1;
            for (int j = 1; j < arr.length; j++)
                arr[j] = digits[j - 1];
            return arr;
        }
        return digits;
    }
}

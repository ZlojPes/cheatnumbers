package com.ospavliuk.chnum;

import java.util.*;

public class UniqueDigits {
    private int[] input;

    UniqueDigits(char[] input) {
        this.input = new int[input.length];
        for (int i = 0; i < input.length; i++)
            this.input[i] = (int) input[i] - 48;
    }

    public boolean isValidNumber() {
        if (input.length != 4) return false;
        for (int i = 0; i < input.length - 1; i++)
            for (int j = i + 1; j < input.length; j++)
                if (input[i] == input[j] || input[i] > 9 || input[j] > 9)
                    return false;
        return true;
    }

    public List<Integer> normalize() {
        List<Integer> output = new ArrayList<>();
        for (int j : input) {
            if (j < 10 && j > -1) {
                boolean isDuplicate = false;
                if (output.isEmpty())
                    output.add(j);
                else {
                    for (Integer output1 : output)
                        if (output1 == j) {
                            isDuplicate = true;
                            break;
                        }
                    if (!isDuplicate && output.size() < 4)
                        output.add(j);
                }
            }
        }
        return output;
    }

    int[] getIntArray() {
        return input;
    }
}

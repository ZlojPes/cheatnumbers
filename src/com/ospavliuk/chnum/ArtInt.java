package com.ospavliuk.chnum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArtInt {
    private final ArrayList<int[]> log;

    ArtInt(ArrayList<int[]> log) {
        this.log = log;
    }

    public ArrayList<int[]> getCombinations() {
        ArrayList<int[]> output = new ArrayList<>();
        if (this.log.size() > 0) {
            for(int a = 0; a < 10; ++a) {
                for(int b = 0; b < 10; ++b) {
                    if (b != a) {
                        for(int c = 0; c < 10; ++c) {
                            if (c != b && c != a) {
                                for(int d = 0; d < 10; ++d) {
                                    if (d != c && d != b && d != a && compareToLog(new int[]{a, b, c, d})) {
                                        output.add(new int[]{a, b, c, d});
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return output;
    }

    boolean compareToLog(int[] checkIt) {
        int[] shortLog = new int[4];
        Iterator var3 = log.iterator();

        int[] fromLog;
        int[] result;
        do {
            if (!var3.hasNext()) {
                return true;
            }

            fromLog = (int[])var3.next();
            System.arraycopy(fromLog, 0, shortLog, 0, 4);
            result = Score.getScore(checkIt, fromLog);
        } while(result[0] == fromLog[4] && result[1] == fromLog[5] && !Arrays.equals(checkIt, shortLog));

        return false;
    }
}

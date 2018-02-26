package com.ospavliuk.chnum;

import java.util.ArrayList;

public class ArtIntTemp {
    private static final int[][] LEGAL_COMBINATIONS = new int[5040][];
    private final java.util.ArrayList<int[]> log;

    static {
        int counter = 0;
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if (b != a) {
                    for (int c = 0; c < 10; c++) {
                        if (c != b && c != a) {
                            for (int d = 0; d < 10; d++) {
                                if (d != c && d != b && d != a) {
                                    LEGAL_COMBINATIONS[counter++] = new int[]{a, b, c, d};
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public ArtIntTemp(ArrayList<int[]> log) {
        this.log = log;
    }

    public int[] nextMove() {
        int[] attempt = null;
        for (int[] current : LEGAL_COMBINATIONS) {
            if (compareToPrevious(current)) {
                attempt = current;
                break;
            }
        }
        return attempt;
    }

    private boolean compareToPrevious(int[] attempt) {
        for (int[] move : log) {
            int[] score = Score.getScore(attempt, move);
            if (score[0] != move[4] || score[1] != move[5]) {
                return false;
            }
        }
        return true;
    }

    public void writeToLog(int[] a) {
        log.add(a);
    }

    public java.util.ArrayList<int[]> getLog() {
        return log;
    }
}

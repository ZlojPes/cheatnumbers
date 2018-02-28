package com.ospavliuk.chnum;

import javax.swing.*;
import java.util.ArrayList;

public class Game {
    private Gui gui;
    private ArrayList<int[]> generalLog;
    boolean isDARunning;
    private int[] labelValues;

    Game(Gui gui) {
        this.gui = gui;
        gui.resetGui();
        generalLog = new ArrayList<>();
    }

    int testAll(int[] move) {
        if (!generalLog.isEmpty()) {
            labelValues = new int[13];
            Thread[] threads = new Thread[13];
            for (int i = 0; i < 13; i++) {
                int finalI = i;
                Thread t = new Thread(() -> {
                    JButton b = gui.scoreButtonArray[finalI];
                    String[] s = b.getText().split(":");
                    int[] score = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
                    ArrayList<int[]> tempLog = new ArrayList<>(generalLog);
                    tempLog.add(new int[]{move[0], move[1], move[2], move[3], score[0], score[1]});
                    ArrayList<int[]> output = new ArtInt(tempLog).getCombinations();
                    labelValues[finalI] = output.size();
                    if (!isDARunning) {
                        gui.labelArray[finalI].setText("" + output.size());
                        gui.scoreButtonArray[finalI].setEnabled(!output.isEmpty());
                    }
                });
                threads[i] = t;
                t.start();
            }
            for (Thread thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            gui.l44.setEnabled((new ArtInt(generalLog)).compareToPrevious(move));
            if (gui.autoScoreBox.isSelected() || isDARunning) {
                return getAutoScore(move);
            }
        }
        return -1;
    }

    private int getAutoScore(int[] move) {
        int max = 0;
        int buttonIndex = 0;
        for (int i = 0; i < labelValues.length; i++) {
            int current = labelValues[i];
            if (current > max) {
                max = current;
                buttonIndex = i;
            }
        }
        if (!isDARunning) {
            completeOperation(gui.scoreButtonArray[buttonIndex], move);
        }
        return max;
    }

    void getManualScore(JButton b) {
        UniqueDigits un = new UniqueDigits(gui.numberInput.getText().toCharArray());
        int[] intArray = un.getIntArray();
        completeOperation(b, intArray);
    }

    private void completeOperation(JButton b, int[] move) {
        String[] s = b.getText().split(":");
        int[] score = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
        int[] full = new int[6];
        System.arraycopy(move, 0, full, 0, 4);
        System.arraycopy(score, 0, full, 4, 2);
        generalLog.add(full);
        gui.setScoreButtonsEnabled(false);
        gui.numberInput.setText("");
        gui.setKeyboardEnabled();
        gui.print(full);
        if (generalLog.size() > 1) {
            new Thread(() -> {
                ArrayList<int[]> list = new ArtInt(generalLog).getCombinations();
                if (gui.deepABox.isSelected()) {
                    gui.printVars(deepAnalysis(list));
                    return;
                }
                gui.printVars(list);
            }).start();
        }
    }

    private ArrayList<int[]> deepAnalysis(ArrayList<int[]> inputList) {
        isDARunning = true;
        int[] totalMax = new int[5];
        int[] totalMin = new int[5];
        ArrayList<int[]> output = new ArrayList<>();
        for (int i = 0; i < inputList.size(); i++) {
            int[] aList = inputList.get(i);
            int currentMax = testAll(aList);
            int[] toOutput = new int[]{aList[0], aList[1], aList[2], aList[3], currentMax};
            output.add(toOutput);
            if (currentMax > totalMax[4]) {
                totalMax = toOutput;
            }
            if (currentMax < totalMin[4] || totalMin[4] == 0) {
                totalMin = toOutput;
            }
            gui.jProgressBar1.setValue((int) (100 / (float) inputList.size() * (i + 1)));
        }
        gui.maxField.setText("(" + totalMax[0] + totalMax[1] + totalMax[2] + totalMax[3] + ")" + totalMax[4]);
        gui.minField.setText("(" + totalMin[0] + totalMin[1] + totalMin[2] + totalMin[3] + ")" + totalMin[4]);
        isDARunning = false;
        return output;
    }
}

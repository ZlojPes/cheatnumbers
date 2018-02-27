package com.ospavliuk.chnum;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Game {
    private Gui gui;
    private ArrayList<int[]> generalLog;
    boolean isDARunning;

    Game(Gui gui) {
        this.gui = gui;
        gui.resetGui();
        generalLog = new ArrayList<>();
    }

    int testAll(int[] intArray) {
        if (!generalLog.isEmpty()) {
            Thread[] threads = new Thread[13];

            for (int i = 0; i < 13; i++) {
                int finalI = i;
                Thread t = new Thread(() -> {
                    JButton b = gui.scoreButtonArray[finalI];
                    String[] s = b.getText().split(":");
                    int[] score = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
                    int[] full = new int[6];
                    System.arraycopy(intArray, 0, full, 0, 4);
                    System.arraycopy(score, 0, full, 4, 2);
                    ArrayList<int[]> tempLog = new ArrayList<>(generalLog);
                    tempLog.add(full);
                    ArrayList<int[]> output = (new ArtInt(tempLog)).getCombinations();
                    gui.labelArray[finalI].setText("" + output.size());
                    gui.scoreButtonArray[finalI].setEnabled(!output.isEmpty());
                });
                threads[i] = t;
                t.start();
            }

            int var10 = 0;

            while (true) {
                if (var10 >= 13) {
                    gui.l44.setEnabled((new ArtInt(generalLog)).compareToPrevious(intArray));
                    if (gui.autoScoreBox.isSelected() || isDARunning) {
                        return getAutoScore(intArray);
                    }
                    break;
                }

                Thread t = threads[var10];

                try {
                    t.join();
                } catch (InterruptedException var8) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, var8);
                }

                ++var10;
            }
        }

        return -1;
    }

    private int getAutoScore(int[] intArray) {
        JButton b = gui.scoreButtonArray[0];
        JLabel l = gui.labelArray[0];
        int max = Integer.parseInt(gui.labelArray[0].getText());

        for (int i = 1; i < 13; ++i) {
            if (Integer.parseInt(gui.labelArray[i].getText()) > Integer.parseInt(l.getText())) {
                b = gui.scoreButtonArray[i];
                l = gui.labelArray[i];
                max = Integer.parseInt(l.getText());
            }
        }

        if (!isDARunning) {
            completeOperation(b, intArray);
        }

        return max;
    }

    void getManualScore(JButton b) {
        UniqueDigits un = new UniqueDigits(gui.numberInput.getText().toCharArray());
        int[] intArray = un.getIntArray();
        completeOperation(b, intArray);
    }

    private void completeOperation(JButton b, int[] intArray) {
        String[] s = b.getText().split(":");
        int[] score = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
        int[] full = new int[6];
        System.arraycopy(intArray, 0, full, 0, 4);
        System.arraycopy(score, 0, full, 4, 2);
        generalLog.add(full);
        gui.setScoreButtonsEnabled(false);
        gui.numberInput.setText("");
        gui.setKeyboardEnabled();
        gui.print(full);
//        ArrayList<int[]> list = new ArtInt(generalLog).getCombinations();

        if (generalLog.size() > 1) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    ArrayList<int[]> list = new ArtInt(generalLog).getCombinations();
                    if (gui.deepABox.isSelected()) {
                        gui.printVars(deepAnalysis(list));
                        return;
                    }
                    gui.printVars(list);
                }
            }).start();
        }
    }

    private ArrayList<int[]> deepAnalysis(ArrayList<int[]> inputList) {
        isDARunning = true;
        int[] totalMax = new int[5];
        int[] totalMin = new int[5];
        ArrayList<int[]> output = new ArrayList<>();
        long start = System.currentTimeMillis();

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

            float f = 100.0F / (float) inputList.size() * (float) (i + 1);
            gui.jProgressBar1.setValue((int) f);
//            gui.jProgressBar1.update(gui.jProgressBar1.getGraphics());
        }
        System.out.println(System.currentTimeMillis() - start);
        gui.maxField.setText("(" + totalMax[0] + totalMax[1] + totalMax[2] + totalMax[3] + ")" + totalMax[4]);
        gui.minField.setText("(" + totalMin[0] + totalMin[1] + totalMin[2] + totalMin[3] + ")" + totalMin[4]);
        isDARunning = false;
        return output;
    }
}

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
        this.generalLog = new ArrayList<>();
    }

    int testAll(int[] intArray) {
        if (!this.generalLog.isEmpty()) {
            Thread[] threads = new Thread[13];

            for(int i = 0; i < 13; i++) {
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

            int var4 = threads.length;
            int var10 = 0;

            while(true) {
                if (var10 >= var4) {
                    this.gui.l44.setEnabled((new ArtInt(this.generalLog)).compareToLog(intArray));
                    if (this.gui.autoScoreBox.isSelected() || this.isDARunning) {
                        return this.getAutoScore(intArray);
                    }
                    break;
                }

                Thread t = threads[var10];

                try {
                    t.join();
                } catch (InterruptedException var8) {
                    Logger.getLogger(Game.class.getName()).log(Level.SEVERE, (String)null, var8);
                }

                ++var10;
            }
        }

        return -1;
    }

    private int getAutoScore(int[] intArray) {
        JButton b = this.gui.scoreButtonArray[0];
        JLabel l = this.gui.labelArray[0];
        int max = Integer.parseInt(this.gui.labelArray[0].getText());

        for(int i = 1; i < 13; ++i) {
            if (Integer.parseInt(this.gui.labelArray[i].getText()) > Integer.parseInt(l.getText())) {
                b = this.gui.scoreButtonArray[i];
                l = this.gui.labelArray[i];
                max = Integer.parseInt(l.getText());
            }
        }

        if (!this.isDARunning) {
            this.completeOperation(b, intArray);
        }

        return max;
    }

    void getManualScore(JButton b) {
        UniqueDigits un = new UniqueDigits(this.gui.numberInput.getText().toCharArray());
        int[] intArray = un.getIntArray();
        this.completeOperation(b, intArray);
    }

    void completeOperation(JButton b, int[] intArray) {
        String[] s = b.getText().split(":");
        int[] score = new int[]{Integer.parseInt(s[0]), Integer.parseInt(s[1])};
        int[] full = new int[6];
        System.arraycopy(intArray, 0, full, 0, 4);
        System.arraycopy(score, 0, full, 4, 2);
        this.generalLog.add(full);
        this.gui.setScoreButtonsEnabled(false);
        this.gui.numberInput.setText("");
        this.gui.setKeyboardEnabled(true);
        this.gui.print(full);
        ArrayList<int[]> list = (new ArtInt(this.generalLog)).getCombinations();
        if (this.gui.deepABox.isSelected() && this.generalLog.size() > 1) {
            list = this.deepAnalysis(list);
        }

        if (this.generalLog.size() > 1) {
            this.gui.printVars(list);
        }

    }

    private ArrayList<int[]> deepAnalysis(ArrayList<int[]> list) {
        this.isDARunning = true;
        int[] totalMax = new int[]{0, 0, 0, 0, 0};
        int[] totalMin = new int[]{0, 0, 0, 0, 0};
        ArrayList<int[]> output = new ArrayList<>();

        for(int i = 0; i < list.size(); ++i) {
            int[] a = (int[])list.get(i);
            int currentMax = this.testAll(a);
            int[] toOutput = new int[]{a[0], a[1], a[2], a[3], currentMax};
            output.add(toOutput);
            if (currentMax > totalMax[4]) {
                totalMax = toOutput;
            }

            if (currentMax < totalMin[4] || totalMin[4] == 0) {
                totalMin = toOutput;
            }

            float f = 100.0F / (float)list.size() * (float)(i + 1);
            this.gui.jProgressBar1.setValue((int)f);
            this.gui.jProgressBar1.update(this.gui.jProgressBar1.getGraphics());
        }

        this.gui.maxField.setText("(" + totalMax[0] + totalMax[1] + totalMax[2] + totalMax[3] + ")" + totalMax[4]);
        this.gui.minField.setText("(" + totalMin[0] + totalMin[1] + totalMin[2] + totalMin[3] + ")" + totalMin[4]);
        return output;
    }
}

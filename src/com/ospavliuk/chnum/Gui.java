package com.ospavliuk.chnum;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Point;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;

public class Gui extends JFrame {
    protected JCheckBox autoScoreBox;
    private final JButton b00 = new JButton();
    private final JButton b10 = new JButton();
    private final JButton b11 = new JButton();
    private final JButton b20 = new JButton();
    private final JButton b21 = new JButton();
    private final JButton b22 = new JButton();
    private final JButton b30 = new JButton();
    private final JButton b31 = new JButton();
    private final JButton b32 = new JButton();
    private final JButton b33 = new JButton();
    private final JButton b40 = new JButton();
    private final JButton b41 = new JButton();
    private final JButton b42 = new JButton();
    private JButton bestButton;
    protected JCheckBox deepABox;
    private JButton enterButton;
    private JTextPane historyPane;
    private JButton jButton0;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JButton jButtonBack;
    JProgressBar jProgressBar1;
    private final JLabel l00 = new JLabel();
    private final JLabel l10 = new JLabel();
    private final JLabel l11 = new JLabel();
    private final JLabel l20 = new JLabel();
    private final JLabel l21 = new JLabel();
    private final JLabel l22 = new JLabel();
    private final JLabel l30 = new JLabel();
    private final JLabel l31 = new JLabel();
    private final JLabel l32 = new JLabel();
    private final JLabel l33 = new JLabel();
    private final JLabel l40 = new JLabel();
    private final JLabel l41 = new JLabel();
    private final JLabel l42 = new JLabel();
    final JLabel l44 = new JLabel();
    TextField maxField;
    private Label maxLabel;
    TextField minField;
    private Label minLabel;
    JTextField numberInput;
    private JTextPane variantsPane;
    private final JButton[] keyboard;
    private Game game;
    final JButton[] scoreButtonArray;
    final JLabel[] labelArray;

    private Gui() {
        initComponents();
        keyboard = new JButton[]{jButton0, jButton1, jButton2, jButton3, jButton4, jButton5,
                jButton6, jButton7, jButton8, jButton9, jButtonBack, enterButton};
        labelArray = new JLabel[]{l00, l10, l11, l20, l21, l22, l30, l31, l32, l33, l40, l41, l42};
        scoreButtonArray = new JButton[]{b00, b10, b11, b20, b21, b22, b30, b31, b32, b33, b40, b41, b42};
        enterButton.setEnabled(false);
        jButtonBack.setEnabled(false);
        game = new Game(this);
        l44.setEnabled(false);
    }

    private void initComponents() {
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton6 = new JButton();
        jButton5 = new JButton();
        jButton4 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jButton0 = new JButton();
        enterButton = new JButton();
        jButtonBack = new JButton();
        JScrollPane jScrollPane1 = new JScrollPane();
        variantsPane = new JTextPane();
        numberInput = new JTextField();
        JButton startButton = new JButton();
        JScrollPane jScrollPane2 = new JScrollPane();
        historyPane = new JTextPane();
        autoScoreBox = new JCheckBox();
        bestButton = new JButton();
        deepABox = new JCheckBox();
        jProgressBar1 = new JProgressBar();
        maxField = new TextField();
        maxLabel = new Label();
        minLabel = new Label();
        minField = new TextField();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cheated Numbers");
        setLocation(new Point(150, 100));
        setResizable(false);
        l00.setText("None");
        l10.setText("None");
        l11.setText("None");
        l20.setText("None");
        l21.setText("None");
        l22.setText("None");
        l30.setText("None");
        l31.setText("None");
        l32.setText("None");
        l33.setText("None");
        l40.setText("None");
        l41.setText("None");
        l42.setText("None");
        l44.setText("winner");
        l44.setForeground(new Color(255, 0, 0));
//        l44.setName("win");
        b00.setText("0:0");
        b00.addActionListener(this::scoreButtonsActionPerformed);
        b10.setText("1:0");
        b10.addActionListener(this::scoreButtonsActionPerformed);
        b11.setText("1:1");
        b11.addActionListener(this::scoreButtonsActionPerformed);
        b20.setText("2:0");
        b20.addActionListener(this::scoreButtonsActionPerformed);
        b21.setText("2:1");
        b21.addActionListener(this::scoreButtonsActionPerformed);
        b22.setText("2:2");
        b22.addActionListener(this::scoreButtonsActionPerformed);
        b30.setText("3:0");
        b30.addActionListener(this::scoreButtonsActionPerformed);
        b31.setText("3:1");
        b31.addActionListener(this::scoreButtonsActionPerformed);
        b32.setText("3:2");
        b32.addActionListener(this::scoreButtonsActionPerformed);
        b33.setText("3:3");
        b33.addActionListener(this::scoreButtonsActionPerformed);
        b40.setText("4:0");
        b40.addActionListener(this::scoreButtonsActionPerformed);
        b41.setText("4:1");
        b41.addActionListener(this::scoreButtonsActionPerformed);
        b42.setText("4:2");
        b42.addActionListener(this::scoreButtonsActionPerformed);
        Dimension keyboard = new Dimension(62, 37);
        jButton1.setText("1");
        jButton1.setPreferredSize(keyboard);
        jButton1.addActionListener(this::jButtonAllActionPerformed);
        jButton2.setText("2");
        jButton2.setPreferredSize(keyboard);
        jButton2.addActionListener(this::jButtonAllActionPerformed);
        jButton3.setText("3");
        jButton3.setPreferredSize(keyboard);
        jButton3.addActionListener(this::jButtonAllActionPerformed);
        jButton6.setText("6");
        jButton6.setPreferredSize(keyboard);
        jButton6.addActionListener(this::jButtonAllActionPerformed);
        jButton5.setText("5");
        jButton5.setPreferredSize(keyboard);
        jButton5.addActionListener(this::jButtonAllActionPerformed);
        jButton4.setText("4");
        jButton4.setPreferredSize(keyboard);
        jButton4.addActionListener(this::jButtonAllActionPerformed);
        jButton7.setText("7");
        jButton7.setPreferredSize(keyboard);
        jButton7.addActionListener(this::jButtonAllActionPerformed);
        jButton8.setText("8");
        jButton8.setPreferredSize(keyboard);
        jButton8.addActionListener(this::jButtonAllActionPerformed);
        jButton9.setText("9");
        jButton9.setPreferredSize(keyboard);
        jButton9.addActionListener(this::jButtonAllActionPerformed);
        jButton0.setText("0");
        jButton0.setPreferredSize(keyboard);
        jButton0.addActionListener(this::jButtonAllActionPerformed);
        enterButton.setText("ввод");
        enterButton.setPreferredSize(keyboard);
        enterButton.addActionListener(e -> enterButtonActionPerformed());
        jButtonBack.setText("назад");
        jButtonBack.setPreferredSize(keyboard);
        jButtonBack.addActionListener(e -> jButtonBackActionPerformed());
        variantsPane.setEditable(false);
        jScrollPane1.setViewportView(variantsPane);
        numberInput.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
        numberInput.setForeground(new Color(255, 0, 0));
        numberInput.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        numberInput.setDisabledTextColor(new Color(153, 153, 153));
        numberInput.setDoubleBuffered(true);
        numberInput.addCaretListener(evt2 -> numberInputCaretUpdate());
        numberInput.addActionListener(e -> numberInputActionPerformed());
        numberInput.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                numberInputKeyReleased();
            }
        });
        startButton.setText("Restart");
        startButton.addActionListener(evt1 -> startButtonActionPerformed());
        historyPane.setEditable(false);
        jScrollPane2.setViewportView(historyPane);
        autoScoreBox.setText("auto score");
        autoScoreBox.addActionListener(evt -> autoScoreBoxActionPerformed());
        bestButton.setText("Best");
        deepABox.setText("deep analysis");
        deepABox.addActionListener(evt -> deepABoxActionPerformed());
        jProgressBar1.setStringPainted(true);
        maxField.setEditable(false);
        maxField.setText("0");
        maxField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                maxFieldMouseClicked();
            }
        });
        maxLabel.setText("Max");
        minLabel.setText("Min");
        minField.setEditable(false);
        minField.setText("0");
        minField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                minFieldMouseClicked();
            }
        });
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().
                addGap(36, 36, 36).addComponent(b00).addPreferredGap(ComponentPlacement.RELATED).
                addComponent(l00, -2, 33, -2).addPreferredGap(ComponentPlacement.UNRELATED).
                addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().
                addComponent(b11).addPreferredGap(ComponentPlacement.RELATED).addComponent(l11, -1, -1, 32767)).
                addGroup(layout.createSequentialGroup().addComponent(b10).addPreferredGap(ComponentPlacement.RELATED).
                addComponent(l10, -2, 32, -2))).addPreferredGap(ComponentPlacement.UNRELATED).
                addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().
                addComponent(b20).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).
                addComponent(l20, -2, 33, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(b30)).
                addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING, false).
                addGroup(layout.createSequentialGroup().addComponent(b22).addPreferredGap(ComponentPlacement.RELATED).
                addComponent(l22, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(b21).
                addPreferredGap(ComponentPlacement.RELATED).addComponent(l21, -2, 33, -2))).
                addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).
                addComponent(b32).addComponent(b31).addComponent(b33)))).addPreferredGap(ComponentPlacement.RELATED).
                addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().
                addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().
                addComponent(l30, -2, 33, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(b40)).
                addGroup(layout.createSequentialGroup().addComponent(l31, -2, 33, -2).
                addPreferredGap(ComponentPlacement.UNRELATED).addComponent(b41)).addGroup(layout.createSequentialGroup().
                addComponent(l32, -2, 35, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(b42))).
                addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).
                addComponent(l40, -1, 35, 32767).addComponent(l41, -1, -1, 32767).
                addComponent(l42, -1, -1, 32767))).addComponent(l33, -2, 35, -2)).
                addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().
                addComponent(jScrollPane1, -2, 79, -2).addGap(18, 18, 18).
                addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(startButton, -2, 91, -2).
                addComponent(jScrollPane2, -2, 95, -2)).addPreferredGap(ComponentPlacement.RELATED).
                addGroup(layout.createParallelGroup(Alignment.LEADING, false).
                addComponent(deepABox, -1, 111, 32767).addComponent(autoScoreBox, -1, 105, 32767).
                addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING, false).
                addComponent(maxLabel, -1, -1, 32767).addComponent(minLabel, -1, -1, 32767)).
                addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).
                addComponent(maxField, -1, 76, 32767).addComponent(minField, -1, -1, 32767))).
                addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(bestButton, -2, 53, -2)).
                addComponent(jProgressBar1, -2, 0, 32767)).addPreferredGap(ComponentPlacement.RELATED, 12, 32767).
                addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().
                addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jButton1, -2, 62, -2).
                addComponent(jButton7, -2, 62, -2).addComponent(jButton4, -2, 62, -2).
                addComponent(jButtonBack, -2, 62, -2)).addPreferredGap(ComponentPlacement.RELATED).
                addGroup(layout.createParallelGroup(Alignment.LEADING, false).
                addComponent(jButton2, Alignment.TRAILING, -2, 62, -2).
                addComponent(jButton8, Alignment.TRAILING, -2, 62, -2).
                addComponent(jButton5, Alignment.TRAILING, -2, 62, -2).
                addComponent(jButton0, -2, 62, -2)).addPreferredGap(ComponentPlacement.RELATED).
                addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jButton9, -2, 62, -2).
                addComponent(jButton6, -2, 62, -2).addComponent(jButton3, Alignment.TRAILING, -2, 62, -2).
                addComponent(enterButton, Alignment.TRAILING, -2, 62, -2))).addGroup(layout.createSequentialGroup().
                addComponent(numberInput, -2, 73, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(l44).
                addPreferredGap(ComponentPlacement.RELATED))).addGap(0, 7, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().
                addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(b00).addComponent(l00).
                addComponent(b10).addComponent(b20).addComponent(b30).addComponent(b40).addComponent(l10).addComponent(l20).
                addComponent(l30).addComponent(l40)).addPreferredGap(ComponentPlacement.RELATED).
                addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().
                addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(b11).addComponent(l11).addComponent(b21).
                addComponent(b31).addComponent(b41).addComponent(l31).addComponent(l41).addComponent(l21)).
                addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).
                addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(b42).
                addComponent(b32).addComponent(b22).addComponent(l22).addComponent(l32).addComponent(l42)).
                addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(b33).
                addComponent(l33)).addGap(10, 10, 10).addGroup(layout.createParallelGroup(Alignment.LEADING).
                addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(bestButton, -2, 34, -2).
                addComponent(numberInput, -2, 34, -2).addComponent(l44))).addGroup(layout.createParallelGroup(Alignment.LEADING).
                addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).
                addComponent(jButton1, -2, 37, -2).addComponent(jButton2, -2, 37, -2).
                addComponent(jButton3, -2, 37, -2)).addGap(3, 3, 3).
                addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jButton4, -2, 37, -2).
                addComponent(jButton5, -2, 37, -2).addComponent(jButton6, -2, 37, -2))).
                addGroup(layout.createSequentialGroup().addComponent(autoScoreBox).addPreferredGap(ComponentPlacement.RELATED).
                addComponent(deepABox).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(jProgressBar1, -2, -1, -2))).
                addGap(3, 3, 3).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().
                addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(jButton7, -2, 37, -2).
                addGroup(Alignment.TRAILING, layout.createParallelGroup(Alignment.BASELINE).addComponent(jButton8, -2, 37, -2).
                addComponent(jButton9, -2, 37, -2))).addGap(2, 2, 2).
                addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(jButton0, -2, 37, -2).
                addComponent(jButtonBack, -2, 37, -2).addComponent(enterButton, -2, 37, -2))).
                addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).
                addComponent(maxLabel, -2, -1, -2).addComponent(maxField, -2, -1, -2)).
                addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).
                addComponent(minField, -2, -1, -2).addComponent(minLabel, -2, -1, -2))))).
                addGroup(layout.createSequentialGroup().addComponent(jScrollPane2, -2, 214, -2).
                addPreferredGap(ComponentPlacement.RELATED).addComponent(startButton, -2, 38, -2))).
                addGap(0, 20, 32767)).addComponent(jScrollPane1)).addContainerGap()));
        pack();
    }

    private void jButtonAllActionPerformed(ActionEvent evt) {
        numberInput.setText(numberInput.getText() + ((JButton) evt.getSource()).getText());
        setUsedKeysDisabled();
    }

    private void enterButtonActionPerformed() {
        String text = numberInput.getText();
        UniqueDigits un = new UniqueDigits(text.toCharArray());
        if (un.isValidNumber()) {
            game.testAll(un.getIntArray());
        }

    }

    private void jButtonBackActionPerformed() {
        String text = numberInput.getText();
        if (text.length() > 0) {
            numberInput.setText(text.substring(0, text.length() - 1));
            setUsedKeysDisabled();
        } else {
            jButtonBack.setEnabled(false);
        }

    }

    private void numberInputCaretUpdate() {
        enterButton.setEnabled(numberInput.getText().length() == 4);
        l44.setEnabled(false);
    }

    private void numberInputActionPerformed() {
        enterButtonActionPerformed();
    }

    private void numberInputKeyReleased() {
        setUsedKeysDisabled();
    }

    private void startButtonActionPerformed() {
        setScoreButtonsEnabled(true);
        resetLabels();
        game = new Game(this);
        jProgressBar1.setValue(0);
        maxField.setText("0");
        minField.setText("0");
    }

    private void autoScoreBoxActionPerformed() {
        bestButton.setEnabled(!autoScoreBox.isSelected());
    }

    private void scoreButtonsActionPerformed(ActionEvent evt) {
        l44.setEnabled(false);
        variantsPane.setText("");
        game.getManualScore((JButton) evt.getSource());
    }

    private void deepABoxActionPerformed() {
        autoScoreBox.setEnabled(!deepABox.isSelected());
        autoScoreBox.setSelected(false);
        jProgressBar1.setEnabled(deepABox.isSelected());
        maxLabel.setEnabled(deepABox.isSelected());
        minLabel.setEnabled(deepABox.isSelected());
        maxField.setEnabled(deepABox.isSelected());
        minField.setEnabled(deepABox.isSelected());
    }

    private void maxFieldMouseClicked() {
        numberInput.setText(maxField.getText().substring(1, 5));
    }

    private void minFieldMouseClicked() {
        numberInput.setText(minField.getText().substring(1, 5));
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] laf = UIManager.getInstalledLookAndFeels();

            for (LookAndFeelInfo info : laf) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | UnsupportedLookAndFeelException | IllegalAccessException e) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, e);
        }

        EventQueue.invokeLater(() -> (new Gui()).setVisible(true));
    }

    private void setUsedKeysDisabled() {
        char[] text = numberInput.getText().toCharArray();
        int caret = numberInput.getCaretPosition();
        UniqueDigits ud = new UniqueDigits(text);
        List<Integer> output = ud.normalize();

        for (int i = 0; i < 10; ++i) {
            keyboard[i].setEnabled(!output.contains(i));
        }

        String t = "";

        int i;
        for (Iterator var6 = output.iterator(); var6.hasNext(); t = t + i) {
            i = (Integer) var6.next();
        }

        numberInput.setText(t);
        jButtonBack.setEnabled(t.length() > 0);
        numberInput.setCaretPosition(caret < t.length() ? caret : t.length());
        numberInput.setCaretColor(t.length() < 4 ? Color.GREEN : Color.RED);
    }

    void setKeyboardEnabled() {
        for (JButton b : keyboard) {
            b.setEnabled(true);
        }
        numberInput.setEnabled(true);
        jButtonBack.setEnabled(numberInput.getText().length() > 0);
        enterButton.setEnabled(numberInput.getText().length() == 4);
    }

    void resetGui() {
        numberInput.setText("");
        historyPane.setText("");
        variantsPane.setText("");
        setKeyboardEnabled();
    }

    void print(int[] array) {
        historyPane.setText(historyPane.getText() + array[0] + array[1] + array[2] + array[3] + " - " + array[4] + ":" + array[5] + "\n");
    }

    void setScoreButtonsEnabled(boolean en) {
        for (JButton b : scoreButtonArray) {
            b.setEnabled(en);
        }
    }

    void printVars(ArrayList<int[]> list) {
        StringBuilder sb = new StringBuilder();
        for (int[] row : list) {
            String text = "" + row[0] + row[1] + row[2] + row[3];
            sb.append(row.length == 4 ? text + "\n" : text + "-" + row[4] + "\n");
        }
        variantsPane.setText(sb.toString());
        game.isDARunning = false;
        resetLabels();
    }

    private void resetLabels() {
        for (JLabel l : labelArray) {
            l.setText("0");
        }
    }
}

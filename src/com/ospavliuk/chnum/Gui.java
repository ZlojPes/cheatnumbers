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
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class Gui extends JFrame {
    protected JCheckBox autoScoreBox;
    final JButton b00 = new JButton();
    final JButton b10 = new JButton();
    final JButton b11 = new JButton();
    final JButton b20 = new JButton();
    final JButton b21 = new JButton();
    final JButton b22 = new JButton();
    final JButton b30 = new JButton();
    final JButton b31 = new JButton();
    final JButton b32 = new JButton();
    final JButton b33 = new JButton();
    final JButton b40 = new JButton();
    final JButton b41 = new JButton();
    final JButton b42 = new JButton();
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
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    final JLabel l00 = new JLabel();
    final JLabel l10 = new JLabel();
    final JLabel l11 = new JLabel();
    final JLabel l20 = new JLabel();
    final JLabel l21 = new JLabel();
    final JLabel l22 = new JLabel();
    final JLabel l30 = new JLabel();
    final JLabel l31 = new JLabel();
    final JLabel l32 = new JLabel();
    final JLabel l33 = new JLabel();
    final JLabel l40 = new JLabel();
    final JLabel l41 = new JLabel();
    final JLabel l42 = new JLabel();
    final JLabel l44 = new JLabel();
    Label label1;
    TextField maxField;
    private Label maxLabel;
    TextField minField;
    private Label minLabel;
    JTextField numberInput;
    private JButton startButton;
    private JTextPane variantsPane;
    private final JButton[] keyboard;
    private Game game;
    final JButton[] scoreButtonArray;
    final JLabel[] labelArray;
    int vars = 100;

    public Gui() {
        this.initComponents();
        this.keyboard = new JButton[]{this.jButton0, this.jButton1, this.jButton2, this.jButton3, this.jButton4, this.jButton5, this.jButton6, this.jButton7, this.jButton8, this.jButton9, this.jButtonBack, this.enterButton};
        this.labelArray = new JLabel[]{this.l00, this.l10, this.l11, this.l20, this.l21, this.l22, this.l30, this.l31, this.l32, this.l33, this.l40, this.l41, this.l42};
        this.scoreButtonArray = new JButton[]{this.b00, this.b10, this.b11, this.b20, this.b21, this.b22, this.b30, this.b31, this.b32, this.b33, this.b40, this.b41, this.b42};
        this.enterButton.setEnabled(false);
        this.jButtonBack.setEnabled(false);
        this.game = new Game(this);
        this.l44.setEnabled(false);
    }

    private void initComponents() {
        this.jButton1 = new JButton();
        this.jButton2 = new JButton();
        this.jButton3 = new JButton();
        this.jButton6 = new JButton();
        this.jButton5 = new JButton();
        this.jButton4 = new JButton();
        this.jButton7 = new JButton();
        this.jButton8 = new JButton();
        this.jButton9 = new JButton();
        this.enterButton = new JButton();
        this.jButton0 = new JButton();
        this.jButtonBack = new JButton();
        this.jScrollPane1 = new JScrollPane();
        this.variantsPane = new JTextPane();
        this.numberInput = new JTextField();
        this.startButton = new JButton();
        this.jScrollPane2 = new JScrollPane();
        this.historyPane = new JTextPane();
        this.autoScoreBox = new JCheckBox();
        this.bestButton = new JButton();
        this.deepABox = new JCheckBox();
        this.jProgressBar1 = new JProgressBar();
        this.maxField = new TextField();
        this.maxLabel = new Label();
        this.minLabel = new Label();
        this.minField = new TextField();
        this.label1 = new Label();
        this.setDefaultCloseOperation(3);
        this.setTitle("Cheated Numbers");
        this.setLocation(new Point(150, 100));
        this.setResizable(false);
        this.b00.setText("0:0");
        this.b00.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b10.setText("1:0");
        this.b10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b20.setText("2:0");
        this.b20.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b30.setText("3:0");
        this.b30.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b40.setText("4:0");
        this.b40.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.l00.setText("None");
        this.l10.setText("None");
        this.l20.setText("None");
        this.l30.setText("None");
        this.l40.setText("None");
        this.b11.setText("1:1");
        this.b11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b21.setText("2:1");
        this.b21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b31.setText("3:1");
        this.b31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b41.setText("4:1");
        this.b41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.l44.setForeground(new Color(255, 0, 0));
        this.l44.setText("winner");
        this.l44.setToolTipText("");
        this.l44.setName("win");
        this.l42.setText("None");
        this.l41.setText("None");
        this.l11.setText("None");
        this.b22.setText("2:2");
        this.b22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b32.setText("3:2");
        this.b32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.b42.setText("4:2");
        this.b42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.l32.setText("None");
        this.l22.setText("None");
        this.l21.setText("None");
        this.b33.setText("3:3");
        this.b33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.scoreButtonsActionPerformed(evt);
            }
        });
        this.l33.setText("None");
        this.l31.setText("None");
        this.jButton1.setText("1");
        this.jButton1.setPreferredSize(new Dimension(62, 37));
        this.jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton2.setText("2");
        this.jButton2.setPreferredSize(new Dimension(62, 37));
        this.jButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton3.setText("3");
        this.jButton3.setPreferredSize(new Dimension(62, 37));
        this.jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton6.setText("6");
        this.jButton6.setPreferredSize(new Dimension(62, 37));
        this.jButton6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton5.setText("5");
        this.jButton5.setPreferredSize(new Dimension(62, 37));
        this.jButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton4.setText("4");
        this.jButton4.setPreferredSize(new Dimension(62, 37));
        this.jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton7.setText("7");
        this.jButton7.setPreferredSize(new Dimension(62, 37));
        this.jButton7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton8.setText("8");
        this.jButton8.setPreferredSize(new Dimension(62, 37));
        this.jButton8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButton9.setText("9");
        this.jButton9.setPreferredSize(new Dimension(62, 37));
        this.jButton9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.enterButton.setText("ввод");
        this.enterButton.setPreferredSize(new Dimension(62, 37));
        this.enterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.enterButtonActionPerformed(evt);
            }
        });
        this.jButton0.setText("0");
        this.jButton0.setPreferredSize(new Dimension(62, 37));
        this.jButton0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonAllActionPerformed(evt);
            }
        });
        this.jButtonBack.setText("назад");
        this.jButtonBack.setPreferredSize(new Dimension(62, 37));
        this.jButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.jButtonBackActionPerformed(evt);
            }
        });
        this.variantsPane.setEditable(false);
        this.jScrollPane1.setViewportView(this.variantsPane);
        this.numberInput.setFont(new Font("Comic Sans MS", 1, 24));
        this.numberInput.setForeground(new Color(255, 0, 0));
        this.numberInput.setCursor(new Cursor(2));
        this.numberInput.setDisabledTextColor(new Color(153, 153, 153));
        this.numberInput.setDoubleBuffered(true);
        this.numberInput.addCaretListener(new CaretListener() {
            public void caretUpdate(CaretEvent evt) {
                Gui.this.numberInputCaretUpdate(evt);
            }
        });
        this.numberInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.numberInputActionPerformed(evt);
            }
        });
        this.numberInput.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                Gui.this.numberInputKeyReleased(evt);
            }
        });
        this.startButton.setText("Restart");
        this.startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.startButtonActionPerformed(evt);
            }
        });
        this.historyPane.setEditable(false);
        this.jScrollPane2.setViewportView(this.historyPane);
        this.autoScoreBox.setText("auto score");
        this.autoScoreBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.autoScoreBoxActionPerformed(evt);
            }
        });
        this.bestButton.setText("Best");
        this.deepABox.setText("deep analysis");
        this.deepABox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Gui.this.deepABoxActionPerformed(evt);
            }
        });
        this.jProgressBar1.setStringPainted(true);
        this.maxField.setEditable(false);
        this.maxField.setText("0");
        this.maxField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Gui.this.maxFieldMouseClicked(evt);
            }
        });
        this.maxLabel.setText("Max");
        this.minLabel.setText("Min");
        this.minField.setEditable(false);
        this.minField.setText("0");
        this.minField.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                Gui.this.minFieldMouseClicked(evt);
            }
        });
        this.label1.setText("0");
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGap(36, 36, 36).addComponent(this.b00).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.l00, -2, 33, -2).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.b11).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.l11, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.b10).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.l10, -2, 32, -2))).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.b20).addPreferredGap(ComponentPlacement.RELATED, -1, 32767).addComponent(this.l20, -2, 33, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.b30)).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING, false).addGroup(layout.createSequentialGroup().addComponent(this.b22).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.l22, -1, -1, 32767)).addGroup(layout.createSequentialGroup().addComponent(this.b21).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.l21, -2, 33, -2))).addPreferredGap(ComponentPlacement.UNRELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.b32).addComponent(this.b31).addComponent(this.b33)))).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.TRAILING).addGroup(layout.createSequentialGroup().addComponent(this.l30, -2, 33, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.b40)).addGroup(layout.createSequentialGroup().addComponent(this.l31, -2, 33, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.b41)).addGroup(layout.createSequentialGroup().addComponent(this.l32, -2, 35, -2).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.b42))).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.l40, -1, 35, 32767).addComponent(this.l41, -1, -1, 32767).addComponent(this.l42, -1, -1, 32767))).addComponent(this.l33, -2, 35, -2)).addContainerGap(-1, 32767)).addGroup(layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane1, -2, 79, -2).addGap(18, 18, 18).addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.startButton, -2, 91, -2).addComponent(this.jScrollPane2, -2, 95, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.deepABox, -1, 111, 32767).addComponent(this.autoScoreBox, -1, 105, 32767).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.maxLabel, -1, -1, 32767).addComponent(this.minLabel, -1, -1, 32767)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.maxField, -1, 76, 32767).addComponent(this.minField, -1, -1, 32767))).addGroup(layout.createSequentialGroup().addGap(17, 17, 17).addComponent(this.bestButton, -2, 53, -2)).addComponent(this.jProgressBar1, -2, 0, 32767)).addPreferredGap(ComponentPlacement.RELATED, 12, 32767).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton1, -2, 62, -2).addComponent(this.jButton7, -2, 62, -2).addComponent(this.jButton4, -2, 62, -2).addComponent(this.jButtonBack, -2, 62, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING, false).addComponent(this.jButton2, Alignment.TRAILING, -2, 62, -2).addComponent(this.jButton8, Alignment.TRAILING, -2, 62, -2).addComponent(this.jButton5, Alignment.TRAILING, -2, 62, -2).addComponent(this.jButton0, -2, 62, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton9, -2, 62, -2).addComponent(this.jButton6, -2, 62, -2).addComponent(this.jButton3, Alignment.TRAILING, -2, 62, -2).addComponent(this.enterButton, Alignment.TRAILING, -2, 62, -2))).addGroup(layout.createSequentialGroup().addComponent(this.numberInput, -2, 73, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.l44).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.label1, -2, -1, -2))).addGap(0, 7, 32767)));
        layout.setVerticalGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.b00).addComponent(this.l00).addComponent(this.b10).addComponent(this.b20).addComponent(this.b30).addComponent(this.b40).addComponent(this.l10).addComponent(this.l20).addComponent(this.l30).addComponent(this.l40)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.b11).addComponent(this.l11).addComponent(this.b21).addComponent(this.b31).addComponent(this.b41).addComponent(this.l31).addComponent(this.l41).addComponent(this.l21)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.b42).addComponent(this.b32).addComponent(this.b22).addComponent(this.l22).addComponent(this.l32).addComponent(this.l42)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.b33).addComponent(this.l33)).addGap(10, 10, 10).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.label1, -2, -1, -2).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.bestButton, -2, 34, -2).addComponent(this.numberInput, -2, 34, -2).addComponent(this.l44))).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton1, -2, 37, -2).addComponent(this.jButton2, -2, 37, -2).addComponent(this.jButton3, -2, 37, -2)).addGap(3, 3, 3).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton4, -2, 37, -2).addComponent(this.jButton5, -2, 37, -2).addComponent(this.jButton6, -2, 37, -2))).addGroup(layout.createSequentialGroup().addComponent(this.autoScoreBox).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.deepABox).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(this.jProgressBar1, -2, -1, -2))).addGap(3, 3, 3).addGroup(layout.createParallelGroup(Alignment.LEADING).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.jButton7, -2, 37, -2).addGroup(Alignment.TRAILING, layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton8, -2, 37, -2).addComponent(this.jButton9, -2, 37, -2))).addGap(2, 2, 2).addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(this.jButton0, -2, 37, -2).addComponent(this.jButtonBack, -2, 37, -2).addComponent(this.enterButton, -2, 37, -2))).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.maxLabel, -2, -1, -2).addComponent(this.maxField, -2, -1, -2)).addPreferredGap(ComponentPlacement.RELATED).addGroup(layout.createParallelGroup(Alignment.LEADING).addComponent(this.minField, -2, -1, -2).addComponent(this.minLabel, -2, -1, -2))))).addGroup(layout.createSequentialGroup().addComponent(this.jScrollPane2, -2, 214, -2).addPreferredGap(ComponentPlacement.RELATED).addComponent(this.startButton, -2, 38, -2))).addGap(0, 20, 32767)).addComponent(this.jScrollPane1)).addContainerGap()));
        this.pack();
    }

    private void jButtonAllActionPerformed(ActionEvent evt) {
        this.numberInput.setText(this.numberInput.getText() + ((JButton)evt.getSource()).getText());
        this.setUsedKeysDisabled();
    }

    private void enterButtonActionPerformed(ActionEvent evt) {
        String text = this.numberInput.getText();
        UniqueDigits un = new UniqueDigits(text.toCharArray());
        if (un.isValidNumber()) {
            this.game.testAll(un.getIntArray());
        }

    }

    private void jButtonBackActionPerformed(ActionEvent evt) {
        String text = this.numberInput.getText();
        if (text.length() > 0) {
            this.numberInput.setText(text.substring(0, text.length() - 1));
            this.setUsedKeysDisabled();
        } else {
            this.jButtonBack.setEnabled(false);
        }

    }

    private void numberInputCaretUpdate(CaretEvent evt) {
        this.enterButton.setEnabled(this.numberInput.getText().length() == 4);
        this.l44.setEnabled(false);
    }

    private void numberInputActionPerformed(ActionEvent evt) {
        this.enterButtonActionPerformed(evt);
    }

    private void numberInputKeyReleased(KeyEvent evt) {
        this.setUsedKeysDisabled();
    }

    private void startButtonActionPerformed(ActionEvent evt) {
        this.setScoreButtonsEnabled(true);
        this.resetLabels();
        this.game = new Game(this);
        this.jProgressBar1.setValue(0);
        this.maxField.setText("0");
        this.minField.setText("0");
    }

    private void autoScoreBoxActionPerformed(ActionEvent evt) {
        this.bestButton.setEnabled(!this.autoScoreBox.isSelected());
    }

    private void scoreButtonsActionPerformed(ActionEvent evt) {
        this.l44.setEnabled(false);
        this.variantsPane.setText("");
        this.game.getManualScore((JButton)evt.getSource());
    }

    private void deepABoxActionPerformed(ActionEvent evt) {
        this.autoScoreBox.setEnabled(!this.deepABox.isSelected());
        this.autoScoreBox.setSelected(false);
        this.jProgressBar1.setEnabled(this.deepABox.isSelected());
        this.maxLabel.setEnabled(this.deepABox.isSelected());
        this.minLabel.setEnabled(this.deepABox.isSelected());
        this.maxField.setEnabled(this.deepABox.isSelected());
        this.minField.setEnabled(this.deepABox.isSelected());
    }

    private void maxFieldMouseClicked(MouseEvent evt) {
        this.numberInput.setText(this.maxField.getText().substring(1, 5));
    }

    private void minFieldMouseClicked(MouseEvent evt) {
        this.numberInput.setText(this.minField.getText().substring(1, 5));
    }

    public static void main(String[] args) {
        try {
            LookAndFeelInfo[] var1 = UIManager.getInstalledLookAndFeels();
            int var2 = var1.length;

            for(int var3 = 0; var3 < var2; ++var3) {
                LookAndFeelInfo info = var1[var3];
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException var5) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, (String)null, var5);
        } catch (InstantiationException var6) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, (String)null, var6);
        } catch (IllegalAccessException var7) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, (String)null, var7);
        } catch (UnsupportedLookAndFeelException var8) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, (String)null, var8);
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                (new Gui()).setVisible(true);
            }
        });
    }

    void setUsedKeysDisabled() {
        char[] text = this.numberInput.getText().toCharArray();
        int caret = this.numberInput.getCaretPosition();
        UniqueDigits ud = new UniqueDigits(text);
        List<Integer> output = ud.normalize();

        for(int i = 0; i < 10; ++i) {
            this.keyboard[i].setEnabled(!output.contains(i));
        }

        String t = "";

        int i;
        for(Iterator var6 = output.iterator(); var6.hasNext(); t = t + i) {
            i = (Integer)var6.next();
        }

        this.numberInput.setText(t);
        this.jButtonBack.setEnabled(t.length() > 0);
        this.numberInput.setCaretPosition(caret < t.length() ? caret : t.length());
        this.numberInput.setCaretColor(t.length() < 4 ? Color.GREEN : Color.RED);
    }

    void setKeyboardEnabled(boolean en) {
        JButton[] var2 = this.keyboard;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            JButton b = var2[var4];
            b.setEnabled(en);
        }

        this.numberInput.setEnabled(en);
        this.jButtonBack.setEnabled(en && this.numberInput.getText().length() > 0);
        this.enterButton.setEnabled(en && this.numberInput.getText().length() == 4);
    }

    void resetGui() {
        this.numberInput.setText("");
        this.historyPane.setText("");
        this.variantsPane.setText("");
        this.setKeyboardEnabled(true);
    }

    void print(int[] array) {
        this.historyPane.setText(this.historyPane.getText() + "" + array[0] + array[1] + array[2] + array[3] + " - " + array[4] + ":" + array[5] + "\n");
    }

    void setScoreButtonsEnabled(boolean en) {
        JButton[] var2 = this.scoreButtonArray;
        int var3 = var2.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            JButton b = var2[var4];
            b.setEnabled(en);
        }

    }

    void printVars(ArrayList<int[]> list) {
        for(int i = 0; i < list.size(); ++i) {
            int[] array = (int[])list.get(i);
            String text = this.variantsPane.getText() + array[0] + array[1] + array[2] + array[3];
            this.variantsPane.setText(array.length == 4 ? text + "\n" : text + "-" + array[4] + "\n");
            float f = 100.0F / (float)list.size() * (float)(i + 1);
            this.jProgressBar1.setValue((int)f);
            this.jProgressBar1.update(this.jProgressBar1.getGraphics());
        }

        this.game.isDARunning = false;
        this.resetLabels();
    }

    void resetLabels() {
        JLabel[] var1 = this.labelArray;
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            JLabel l = var1[var3];
            l.setText("0");
        }

    }
}

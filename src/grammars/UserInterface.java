/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grammars;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * This class (Form) let us create the user interface
 *
 * @author danielescobar
 */
public class UserInterface extends javax.swing.JFrame {

    public int rightSideAuxiliar;
    Grammar grammar = new Grammar();
    Production temporalProduction = new Production();

    /**
     * Creates new form UserInterface
     */
    public UserInterface() {
        initComponents();
        this.setResizable(false);
        terminalRight.setTransferHandler(null); // This doesnt let the user to type more than one character.
        addTerminalRight.setVisible(false); // We put in false value, until the user write the left side
        addNonTerminalRight.setVisible(false); // We put in false value, until the user write the left side
        terminalRight.setEnabled(false); // We put in false value, until the user write the left side
        nonTerminalRight.setEnabled(false); // We put in false value, until the user write the left side
        newProduction.setVisible(false);//At the first time, the user can write one production without a click in this button
        addLambda.setVisible(false); // Hide lambda value if the user put another symbol in the production
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addLeftLabel = new javax.swing.JLabel();
        leftSideID = new javax.swing.JTextField();
        addRightTerminal = new javax.swing.JLabel();
        terminalRight = new javax.swing.JTextField();
        addRightNonTerminal = new javax.swing.JLabel();
        nonTerminalRight = new javax.swing.JTextField();
        addLeftSide = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        grammarTable = new javax.swing.JTable();
        addTerminalRight = new javax.swing.JButton();
        addNonTerminalRight = new javax.swing.JButton();
        newProduction = new javax.swing.JButton();
        submitGrammar = new javax.swing.JButton();
        addLambdaLbl = new javax.swing.JLabel();
        addLambda = new javax.swing.JButton();
        addLeftLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        addLeftLabel.setFont(new java.awt.Font("Monaco", 3, 14)); // NOI18N
        addLeftLabel.setText("Add ID non terminal Left Side:");

        addRightTerminal.setFont(new java.awt.Font("Monaco", 3, 14)); // NOI18N
        addRightTerminal.setText("Add terminal to Right Side: ");

        terminalRight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                terminalRightKeyTyped(evt);
            }
        });

        addRightNonTerminal.setFont(new java.awt.Font("Monaco", 3, 14)); // NOI18N
        addRightNonTerminal.setText("Add non terminal to Right Side: ");

        addLeftSide.setText("Submit");
        addLeftSide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLeftSideMouseClicked(evt);
            }
        });

        grammarTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Left Side", "To", "Right Side"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        grammarTable.setEnabled(false);
        jScrollPane2.setViewportView(grammarTable);
        if (grammarTable.getColumnModel().getColumnCount() > 0) {
            grammarTable.getColumnModel().getColumn(0).setResizable(false);
            grammarTable.getColumnModel().getColumn(0).setPreferredWidth(50);
            grammarTable.getColumnModel().getColumn(1).setResizable(false);
            grammarTable.getColumnModel().getColumn(1).setPreferredWidth(5);
            grammarTable.getColumnModel().getColumn(2).setResizable(false);
            grammarTable.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        addTerminalRight.setText("Submit");
        addTerminalRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addTerminalRightMouseClicked(evt);
            }
        });

        addNonTerminalRight.setText("Submit");
        addNonTerminalRight.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNonTerminalRightMouseClicked(evt);
            }
        });

        newProduction.setText("Submit Production");
        newProduction.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newProductionMouseClicked(evt);
            }
        });

        submitGrammar.setText("Submit Grammar");
        submitGrammar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                submitGrammarMouseClicked(evt);
            }
        });

        addLambdaLbl.setFont(new java.awt.Font("Monaco", 3, 14)); // NOI18N
        addLambdaLbl.setText("Add  λ to Right Side: ");

        addLambda.setText("Submit");
        addLambda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addLambdaMouseClicked(evt);
            }
        });

        addLeftLabel1.setFont(new java.awt.Font("Monaco", 3, 12)); // NOI18N
        addLeftLabel1.setText("REMEMBER, WHEN YOU FINISH YOUR PRODUCTION, YOU HAVE TO SUBMIT THEM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(newProduction)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addLeftLabel)
                                        .addComponent(addRightTerminal)
                                        .addComponent(addRightNonTerminal))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(leftSideID, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                        .addComponent(terminalRight)
                                        .addComponent(nonTerminalRight))))
                            .addComponent(addLambdaLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addLambda)
                            .addComponent(addLeftSide)
                            .addComponent(addTerminalRight)
                            .addComponent(addNonTerminalRight)
                            .addComponent(submitGrammar)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addLeftLabel1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addLeftLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLeftLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leftSideID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addLeftSide))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRightTerminal)
                    .addComponent(terminalRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTerminalRight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addRightNonTerminal)
                    .addComponent(nonTerminalRight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addNonTerminalRight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLambdaLbl)
                    .addComponent(addLambda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newProduction)
                    .addComponent(submitGrammar))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * This method does not let the user to type more than one character
     *
     * @param evt
     */
    private void terminalRightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_terminalRightKeyTyped
        if (terminalRight.getText().length() >= 1) {
            evt.consume();
            terminalRight.setText(terminalRight.getText());
        }
    }//GEN-LAST:event_terminalRightKeyTyped

    /**
     * This method adds the left side of the production
     *
     * @param evt User Click
     */
    private void addLeftSideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLeftSideMouseClicked
        // Will be compared with "", which is equal to nothing in this case
        if (!leftSideID.getText().equals("")) {
            DefaultTableModel model = (DefaultTableModel) grammarTable.getModel();
            model.addRow(new Object[]{"< " + leftSideID.getText().toUpperCase() + " >", "--->"});
            addLeftSide.setVisible(false);
            leftSideID.setEnabled(false); //We put in false value until the user add the production
            addTerminalRight.setVisible(true); // We put in true value when the user input the left side
            addNonTerminalRight.setVisible(true); // We put in true value when the user input the left side
            terminalRight.setEnabled(true); // We put in true value when the user input the left side
            nonTerminalRight.setEnabled(true); // We put in true value when the user input the left side
            NonTerminal nonTerminal = new NonTerminal(leftSideID.getText().toUpperCase()); // We create a non terminal 
            temporalProduction.setLeftSide(nonTerminal); // Add non terminal to production in left side
            addLambda.setVisible(true);  // We are putting visible the lamba adding button
        } else {
            JOptionPane.showMessageDialog(null, "You have to input");
        }
        leftSideID.setText(null);
    }//GEN-LAST:event_addLeftSideMouseClicked

    /**
     * This method let us add terminals into the right part of the production
     *
     * @param evt
     */
    private void addTerminalRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addTerminalRightMouseClicked
        if (!terminalRight.getText().equals("")) {
            DefaultTableModel model = (DefaultTableModel) grammarTable.getModel();
            int actualRows = model.getRowCount() - 1;
            String rightSide = (String) model.getValueAt(actualRows, 2);
            // We are using rightSideAuxiliar to know if the cell of rightSide is empty
            if (rightSideAuxiliar == 0) {
                rightSide = terminalRight.getText();
                rightSideAuxiliar = 1;
                newProduction.setVisible(true); // Activate button for a new production
            } else {
                rightSide = rightSide + terminalRight.getText();
            }
            String leftSide = (String) model.getValueAt(actualRows, 0);
            model.removeRow(model.getRowCount() - 1);
            model.addRow(new Object[]{leftSide, "--->", rightSide});
            Terminal terminal = new Terminal(terminalRight.getText().charAt(0));// We create a terminal
            temporalProduction.addElementRightSide(terminal); // Add terminal to production in right side
            addLambda.setVisible(false);// Hide lambda value if the user put another symbol in the production
        } else {
            JOptionPane.showMessageDialog(null, "You have to input");
        }
        terminalRight.setText(null);
    }//GEN-LAST:event_addTerminalRightMouseClicked

    /**
     * This method let us add non terminals into the right part of the
     * production
     *
     * @param evt
     */
    private void addNonTerminalRightMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNonTerminalRightMouseClicked
        if (!nonTerminalRight.getText().equals("")) {
            DefaultTableModel model = (DefaultTableModel) grammarTable.getModel();
            int actualRows = model.getRowCount() - 1;
            String rightSide = (String) model.getValueAt(actualRows, 2);
            // We are using rightSideAuxiliar to know if the cell of rightSide is empty
            if (rightSideAuxiliar == 0) {
                rightSide = "<" + nonTerminalRight.getText().toUpperCase() + ">";
                rightSideAuxiliar = 1;
                newProduction.setVisible(true); // Activate button for a new production
            } else {
                rightSide = rightSide + "<" + nonTerminalRight.getText().toUpperCase() + ">";
            }
            String leftSide = (String) model.getValueAt(actualRows, 0);
            model.removeRow(model.getRowCount() - 1);
            model.addRow(new Object[]{leftSide, "--->", rightSide});
            NonTerminal nonTerminal = new NonTerminal(nonTerminalRight.getText().toUpperCase()); // We create a non terminal 
            temporalProduction.addElementRightSideN(nonTerminal);// Add non terminal to production in right side
            addLambda.setVisible(false); // Hide lambda value if the user put another symbol in the production
        } else {
            JOptionPane.showMessageDialog(null, "You have to input");
        }
        nonTerminalRight.setText(null);
    }//GEN-LAST:event_addNonTerminalRightMouseClicked

    /**
     * This method let us create and save the current production
     *
     * @param evt
     */
    private void newProductionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProductionMouseClicked
        addLeftSide.setVisible(true); // We are activating again the button to add left side
        addTerminalRight.setVisible(false); // We are deactivating the button to add terminals to right side
        addNonTerminalRight.setVisible(false); // We are deactivating the button to add non terminals to right side
        leftSideID.setEnabled(true); // We are activating this field to let user input the new production
        terminalRight.setEnabled(false); // We are deactivating this field to let user input the new production
        nonTerminalRight.setEnabled(false); // We are deactivating this field to let user input the new production
        rightSideAuxiliar = 0; // Reinitializing parameter
        grammar.addProduction(temporalProduction); // We are adding the production into the grammar
        this.newProduction.setVisible(false);
        System.out.println(temporalProduction.getLeftSide().getClass().toString());
        System.out.println(temporalProduction.getLeftSide().getClass().toString().equals("class grammars.NonTerminal"));
        temporalProduction = new Production(); // Reinitializing parameter

    }//GEN-LAST:event_newProductionMouseClicked

    /**
     * This method creates a grammar, if there are any problem the user have to
     * input again the grammar
     *
     * @param evt
     */
    private void submitGrammarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_submitGrammarMouseClicked
        rightSideAuxiliar = 0; // Reinitializing parameter
        //grammar.addProduction(temporalProduction);
        if (!grammar.isNonTerminalWithoutProduction()) {
            JOptionPane.showMessageDialog(null, "One, or more of your terminals does not have a production");
            DefaultTableModel model = (DefaultTableModel) grammarTable.getModel();
            model.setRowCount(0);
            grammar.reinitialize();
            this.addLambda.setVisible(false);
            this.newProduction.setVisible(false);
            this.addNonTerminalRight.setVisible(false);
            this.addTerminalRight.setVisible(false);
            this.addLeftSide.setVisible(true);
            this.leftSideID.setEnabled(true);
        } else {
            grammar.setFirstAlive();
        }
    }//GEN-LAST:event_submitGrammarMouseClicked

    /**
     * This method let us create a terminal lambda and the creates a new
     * production
     *
     * @param evt
     */
    private void addLambdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addLambdaMouseClicked
        DefaultTableModel model = (DefaultTableModel) grammarTable.getModel();
        int actualRows = model.getRowCount() - 1;
        String rightSide = "λ";
        String leftSide = (String) model.getValueAt(actualRows, 0);
        model.removeRow(model.getRowCount() - 1);
        model.addRow(new Object[]{leftSide, "--->", rightSide});
        Terminal terminal = new Terminal(rightSide.charAt(0));// We create a terminal
        temporalProduction.addElementRightSide(terminal); // Add terminal to production in right side
        newProductionMouseClicked(evt);
        newProduction.setVisible(false);
        addLambda.setVisible(false);
    }//GEN-LAST:event_addLambdaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addLambda;
    private javax.swing.JLabel addLambdaLbl;
    private javax.swing.JLabel addLeftLabel;
    private javax.swing.JLabel addLeftLabel1;
    private javax.swing.JButton addLeftSide;
    private javax.swing.JButton addNonTerminalRight;
    private javax.swing.JLabel addRightNonTerminal;
    private javax.swing.JLabel addRightTerminal;
    private javax.swing.JButton addTerminalRight;
    private javax.swing.JTable grammarTable;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField leftSideID;
    private javax.swing.JButton newProduction;
    private javax.swing.JTextField nonTerminalRight;
    private javax.swing.JButton submitGrammar;
    private javax.swing.JTextField terminalRight;
    // End of variables declaration//GEN-END:variables
}

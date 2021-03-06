/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grammars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danielescobar
 */
public class CheckGrammar extends javax.swing.JFrame {

    Grammar grammar = new Grammar();
    Stack<Object> stack = new Stack<>();
    private List<Terminal> terminals = new ArrayList<>();
    private List<NonTerminal> nonTerminals = new ArrayList<>();
    List<String> transitions = new ArrayList<>();
    int matriz[][];

    /**
     * Creates new form CheckGrammar
     */
    public CheckGrammar() {
        initComponents();
        if (grammar.isS()) {
            this.grammarType.setText("S");
        }
        if (grammar.isQ()) {
            this.grammarType.setText("Q");
        }
        if (grammar.isLL1()) {
            this.grammarType.setText("LL1");
        }
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.table.setEnabled(false);
        this.table.getTableHeader().setResizingAllowed(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        userString = new javax.swing.JTextField();
        checkLabel = new javax.swing.JLabel();
        check = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        grammarType = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("String to recognize:");

        checkLabel.setFont(new java.awt.Font("Monaco", 3, 36)); // NOI18N
        checkLabel.setText("GRAMMAR RECOGNITION");

        check.setFont(new java.awt.Font("Monaco", 3, 14)); // NOI18N
        check.setText("CHECK");
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Monaco", 3, 24)); // NOI18N
        jLabel2.setText("The string you check:");

        jLabel3.setFont(new java.awt.Font("Monaco", 3, 24)); // NOI18N
        jLabel3.setText("The grammar is:");

        status.setFont(new java.awt.Font("Monaco", 3, 24)); // NOI18N
        status.setText("is Correct");

        grammarType.setFont(new java.awt.Font("Monaco", 3, 24)); // NOI18N
        grammarType.setText("ll1");

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);

        jScrollPane2.setViewportView(jTextPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(userString, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(status))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(grammarType)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
            .addGroup(layout.createSequentialGroup()
                .addGap(210, 210, 210)
                .addComponent(checkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 496, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(checkLabel)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(userString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(check)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(grammarType))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(status))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        
        System.out.println(checkG(userString.getText()));
    }//GEN-LAST:event_checkActionPerformed

    /**
     * This method let us set the grammar to be evaluated
     *
     * @param grammar The grammar to be used
     */
    public void setGrammar(Grammar grammar) {
        this.grammar = grammar;
        this.terminals = grammar.getTerminals();
        this.nonTerminals = grammar.getLeftSiders();
        this.stack.push(grammar.getProductions().get(0).getLeftSide());
        fillTableBasics();

    }

    /**
     * This method let us fill the table with the right elements
     */
    public void fillTableBasics() {

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addColumn("In Stack");

        for (int i = 0; i < this.terminals.size(); i++) {
            // CON ESTA AÑADIMOS EL RESTO DE COLUMNAS
            model.addColumn(terminals.get(i).toString());
        }
        //CREAMOS VECTOR PARA LLENAR TABLA VACIA
        String[] x = new String[terminals.size() + 1];
        int rows = grammar.terminalsInAlpha().size() + grammar.getLeftSiders().size();
        for (int i = 0; i <= rows; i++) {
            model.addRow(x);
        }
        int j = 0;
        for (int i = 0; i < rows; i++) {
            if (i < grammar.getLeftSiders().size()) {
                model.setValueAt(grammar.getLeftSiders().get(i).toString(), i, 0);
                
            } else {
                model.setValueAt(grammar.terminalsInAlpha().get(j).toString(), i, 0);
               
                j++;
            }
        }

        //Set for the SetSelection of each N
        Recognizer a = new Recognizer(grammar);

        int k = 1;
        String b = "#" + k;
        int m = grammar.getProductions().size();
        int i = 0;
        int row = 0;
        int indexOfColumn;

        model.setValueAt("Acepte", model.getRowCount() - 1, model.getColumnCount() - 1);

        int numberOfRows = model.getRowCount();
        int numberOfColumns = model.getColumnCount();
        
        matriz = new int[numberOfRows][numberOfColumns];
        String currentN;
        while (i < m) {

            currentN = grammar.getProductions().get(i).getLeftSide().toString();

            terminals = a.getSelectionProduction().get(i);
            for (int s = 0; s < terminals.size(); s++) {
                indexOfColumn = returnColumn(model, terminals.get(s).toString());
                model.setValueAt(b, row, indexOfColumn);
                matriz[row][indexOfColumn] = k;
            }

            if ((i + 1) < m) {
                if (!grammar.getProductions().get(i + 1).getLeftSide().toString().equals(currentN)) {
                    row++;
                }
            }

            String operation = toStringRightSide(i);

            String h = b + ": " + getTransition(operation);
            transitions.add(getTransition(operation));
            jTextPane1.setText(jTextPane1.getText() + "\n" + h);

            b = b.substring(0, 1);
            k++;
            b = b + k;
            i++;

        }

        int indexOfRow = 0;
        String s = null;
        /*
        returnSymbolsOnTopStack(grammar);
        returnSymbolsOfinput(grammar);
        getMatriz(matriz);
        getTransitions(transitions);*/
        
        for(int t = 0; t < numberOfRows-1; t++){
            s =  String.valueOf(model.getValueAt(t, 0));
            if(!s.contains("<")){
            indexOfRow = t;
            indexOfColumn = returnColumn(model, s);
            model.setValueAt("#0", indexOfRow, row);
            s = " Desapile,avance";
            jTextPane1.setText(jTextPane1.getText() + "\n" +"#0: "+ s);
            transitions.add(s);
            break;
            }
        }
        
        
        System.out.println("\n");
        model.setValueAt("▼", rows, 0);

    }
    
    /**
     * This method let us know if one String can be derivated from our grammar
     * @param g Is the string to evaluate
     * @return Returns true if the string can be derivated, false if not
     */
    public  boolean checkG(String g) {

        List<Terminal> SymbolsOfInput = returnSymbolsOfinput(grammar);
        List<String> SymbolsOnStack = returnSymbolsOnTopStack(grammar);
        HashMap<String, Integer> putoPablito = new HashMap();
        
        for (int j = 0; j < SymbolsOnStack.size(); j++) {
            putoPablito.put(SymbolsOnStack.get(j), j);
        }

        Stack pila = new Stack();
        pila.push("▼");
        pila.push(grammar.getLeftSiders().get(0).getID());
        g = g+"┐";
        char[] a = g.toCharArray();
        int i = 0;
        do {
            char terminal = a[i];
            boolean f = false;
            int posicionColumna = 1;
            for (int n = 0; n < SymbolsOfInput.size(); n++) {
                if(terminal == SymbolsOfInput.get(n).getSymbol()) {
                    f = true;
                    posicionColumna += n;
                    break;
                }
            }
            //11¬
            if (!f) {
                
                return false;
            }
            
            String ss = pila.get(pila.size()-1).toString();
            
            
            int row = putoPablito.get(ss);
            
            if (matriz[row][posicionColumna] != 0) {
                if(matriz[row][posicionColumna] == -1) return true;
                String transition = transitions.get(matriz[row][posicionColumna] - 1);
                char[] b = transition.toCharArray();
                int vmax = 0;
                if (b[1] == 'R') {
                    for (int k = 10; k < b.length; k++) {
                        if (b[k] == ')'){
                        vmax = k - 1;
                        break;
                        }
                    }
                  
                    b = transition.substring(10, vmax).toCharArray();
                    pila.pop();
                    for (int l = 0; l < b.length; l++) {
                        if (b[l] != '<' && b[l] != '>') {
                            pila.push(b[l]);
                            showStack(pila);                           
                        }
                    }
                    vmax = vmax + 5;
                    char [] c = transition.toCharArray();
                    
                    if (c[vmax] == 'a') {

                        i++;
                    }
                } else {
                    pila.pop();
                    showStack(pila);
                    if (b[10] == 'a') {
                        i++;
                    }
                }
            } else {
                return false;
            }
            
        } while (i < a.length);
       
        
        return pila.pop().toString().equals("▼");
    }
    
    
    /**
     * This method let us see the stack during the recognition process
     * @param pila Is the stack
     */
    public void showStack(Stack pila){
        for(int i = 0;i<pila.size()-1;i++){
            System.out.println(pila.get(i));
        }
    
    }
    
    
    /**
     * This method let us see the matriz which has the transitions
     * @param a Is the matriz
     */
    public static void getMatriz(int a[][]) {

        int numberOfRows = a.length;
        int numberOfColumns = a[0].length;
        for (int w = 0; w < numberOfRows; w++) {
            for (int e = 0; e < numberOfColumns; e++) {
                
                System.out.print(a[w][e] + " ");

            }
            System.out.println(""); 
        }
       
    }
    
    /**
     * This metho let us know what are our transitions
     * @param a Is the list that have all transitions
     */
    public static void getTransitions(List a) {

        for (int i = 0; i < a.size(); i++) {
            System.out.println(a.get(i));
        }
    }

    /**
     * This method let us see what are the symbols on the stack for the AP
     * @param grammar Is the grammar
     * @return Returns a list of String which has all symbols on the stack
     */
    public List<String> returnSymbolsOnTopStack(Grammar grammar) {

        List<String> symbolsOnTopStack = new ArrayList<>();
        int m = grammar.getProductions().size();
        int i = 0;
        String currentN;
        String terminalOnRight;
        while (i < m) {
            currentN = grammar.getProductions().get(i).getLeftSide().getID();
            if(!terminalOnRightSide(i).equals("")){
            terminalOnRight = terminalOnRightSide(i);
            if(!symbolsOnTopStack.contains(terminalOnRight)) symbolsOnTopStack.add(terminalOnRight); 
            }
            i++;
            if(symbolsOnTopStack.contains(currentN)) continue;
            symbolsOnTopStack.add(currentN);
            
        }
        
        symbolsOnTopStack.add("▼");
        
        
        for (int g = 0; g < symbolsOnTopStack.size(); g++) {
            System.out.println(symbolsOnTopStack.get(g) + " ");
        }

        return symbolsOnTopStack;
    }
    
    /**
     * This metod let us if one production has a terminal in some alpha
     * @param i Is the number of the production
     * @return Return the alpha's terminal 
     */
    public String terminalOnRightSide(int i){
    
        String answer = "";
        String g = toStringRightSide(i);
        char [] b = g.toCharArray();
       
        int j = 1;
            while(j< b.length){
            if(b[j] == '<'){
                j = j+4;
            }else{
                if(b[j] != '>' && b[j] != ',' && b[j] != '[' && b[j] != ']' && j != 1 && b[j] != ' '){
                    answer = String.valueOf(b[j]);  
                   
                }  
            }
            j++;
        }
        
    return answer;
    }
    
    /**
     * This method let us know what are the symbols of input for the AP
     * @param grammar Is the grammar
     * @return Returns a terminal's list which has all input's symbols
     */
    public static List<Terminal> returnSymbolsOfinput(Grammar grammar) {

        List<Terminal> symbolsOfinput = new ArrayList<>();
        boolean ber = true;
        symbolsOfinput = grammar.getTerminals();
        HashSet hs = new HashSet();
        hs.addAll(symbolsOfinput);
        symbolsOfinput.clear();
        symbolsOfinput.addAll(hs);

        for (int g = 0; g < symbolsOfinput.size(); g++) {
            if (symbolsOfinput.get(g).toString().equals("┐") && ber == true) {
                symbolsOfinput.remove(g);
                ber = false;
                break;
            }
        }
        /*
        for (int f = 0; f < symbolsOfinput.size(); f++) {
            System.out.println(symbolsOfinput.get(f));
        }*/

        return symbolsOfinput;
    }

    /**
     * This metod let us get one specific production
     *
     * @param position Position is the number of the production searched
     * @return Return a list which has the terminals and non terminals of a
     * production
     */
    public String toStringRightSide(int position) {

        List<Production> productions = new ArrayList<>();
        productions = grammar.getProductions();

        return productions.get(position).rightSide.toString();

    }

    /**
     * This metod returns one transition correspondent to its production
     *
     * @param operation Operation is the production as a string
     * @return Returns the transition as a string
     */
    public String getTransition(String operation) {

        String finalTransition = reverseTransition(operation);

        if (operation.charAt(1) == '<') {
            return " Replace (" + finalTransition + ")" + " , " + "retenga";
        }
        if (operation.equals("[λ]")) {
            return " Desapile,retenga";
        }
        if (operation.length() == 3) {
            return " Desapile,avance";
        }
        return " Replace (" + finalTransition.substring(0, finalTransition.length() - 1) + ")" + " , " + "avance";

    }

    /**
     * This metod let us reverse a production for the replace operation
     *
     * @param transition Transition is the production
     * @return Returns the production in reverse
     */
    public String reverseTransition(String transition) {

        String answer = "";
        char[] v = transition.toCharArray();
        for (int i = transition.length() - 1; i > 0; i--) {

            if (v[i] == '[') {
                continue;
            }
            if (v[i] == ',') {
                continue;
            }
            if (v[i] == ' ') {
                continue;
            }
            if (v[i] == ']') {
                continue;
            }
            if (v[i] == '<') {
                answer = answer + ">";
            } else {
                if (v[i] == '>') {
                    answer = answer + "<";
                } else {
                    answer = answer + String.valueOf(v[i]);
                }
            }
        }
        return answer;
    }

    /**
     * This metod let us the number of the column acording with its header
     *
     * @param model Is the table
     * @param terminal Is the header searched
     * @return Returns the position of the column
     */
    public int returnColumn(DefaultTableModel model, String terminal) {

        for (int i = 0; i < model.getColumnCount(); i++) {
            if (model.getColumnName(i).equals(terminal)) {
                return i;
            }
        }
        return 0;
    }

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
            java.util.logging.Logger.getLogger(CheckGrammar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CheckGrammar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CheckGrammar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CheckGrammar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CheckGrammar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton check;
    private javax.swing.JLabel checkLabel;
    private javax.swing.JLabel grammarType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel status;
    private javax.swing.JTable table;
    private javax.swing.JTextField userString;
    // End of variables declaration//GEN-END:variables
}

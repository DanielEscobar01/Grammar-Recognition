/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grammars;

import java.util.ArrayList;
import java.util.List;

/**
 * This class let us create a grammar
 *
 * @author danielescobar
 */
public class Grammar {

    private List<Production> productions = new ArrayList<>();

    /**
     * Constructor to create a grammar without any productions
     */
    public Grammar() {

    }

    /**
     * Constructor to create a grammar with an initial production
     *
     * @param initialProduction Is the initial production of the grammar
     */
    public Grammar(Production initialProduction) {
        this.productions.add(initialProduction);
    }

    /**
     * This method let us add a new production to the grammar
     *
     * @param production
     */
    public void addProduction(Production production) {
        this.productions.add(production);
    }

    /**
     * This Method let us reinitialize our grammar, to create a new one.
     */
    public void reinitialize() {
        productions.clear();
    }

    /**
     * This method let us know if all the non terminals in the right side have a production for themselves
     *
     * @return
     */
    public boolean isNonTerminalWithoutProduction() {
        List<String> namesLeft = new ArrayList<>();
        List<String> namesRight = new ArrayList<>();
        for (int i = 0; i < getProductions().size(); i++) {
            namesLeft.add(getProductions().get(i).getLeftSide().getID());
        }
        for (int i = 0; i < getProductions().size(); i++) {
            for (int j = 0; j < getProductions().get(i).nonTerminalsInRight().size(); j++) {
                namesRight.add(getProductions().get(i).nonTerminalsInRight().get(j).getID());
            }
        }
        if (namesLeft.size() < namesRight.size()) {
            return false;
        } else {
            for (int i = 0; i < namesRight.size(); i++) {
                int flag = 0; // 0 means it didnt find the terminal in left
                for (int j = 0; j < namesLeft.size(); j++) {
                    if (namesRight.get(i).equals(namesLeft.get(j))) {
                        flag = 1;
                    }
                }
                if(flag==0){
                    return false;
                }
            }
            return true;
        }
    }

    public List<Production> getProductions() {
        return this.productions;
    }
}

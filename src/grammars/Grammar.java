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
    private List<NonTerminal> leftSiders = new ArrayList<>();
    private List<NonTerminal> nonTerminalsAlives = new ArrayList<>();

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
     * This method let us know if the non terminal is already added into the
     * list
     *
     * @param nonTerminal The non terminal to be checked
     * @return True if the non terminal is in the list, False if the non
     * terminal is not in the list
     */
    public boolean alreadyInLeft(NonTerminal nonTerminal) {
        if (leftSiders.isEmpty()) {
            return false;
        } else {
            for (int i = 0; i < leftSiders.size(); i++) {
                if (leftSiders.get(i).getID().equalsIgnoreCase(nonTerminal.getID())) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This method let us add a new production to the grammar
     *
     * @param production
     */
    public void addProduction(Production production) {
        if (!alreadyInLeft(production.getLeftSide())) {
            leftSiders.add(production.getLeftSide());
        }
        this.productions.add(production);
    }

    /**
     * This Method let us reinitialize our grammar, to create a new one.
     */
    public void reinitialize() {
        productions.clear();
    }

    /**
     * This method let us know if all the non terminals in the right side have a
     * production for themselves
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
                if (flag == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * This method let us get the productions of the grammar
     *
     * @return List with all productions
     */
    public List<Production> getProductions() {
        return this.productions;
    }

    /**
     * This method let us get all non terminals of the left side
     *
     * @return List with non terminals of the left side
     */
    public List<NonTerminal> getLeftSiders() {
        return this.leftSiders;
    }

    /**
     * This method let us set the first non productions with non terminals alive
     */
    public void setFirstAlive() {
        for (int i = 0; i < productions.size(); i++) {
            if (productions.get(i).isRightSideAllTerminals()) {
                if (nonTerminalsAlives.isEmpty()) {
                    addNonTerminalAlive(productions.get(i).getLeftSide());
                } else {
                    if (!isInsideAlives(productions.get(i).getLeftSide())) {
                        addNonTerminalAlive(productions.get(i).getLeftSide());
                    }
                }
            }
        }
    }

    /**
     * This method let us know if the non terminal is inside the list of alive
     *
     * @param nonTerminal The non terminal to be checked
     * @return True if the non terminal is inside, otherwise return False
     */
    public boolean isInsideAlives(NonTerminal nonTerminal) {
        for (int i = 0; i < nonTerminalsAlives.size(); i++) {
            if (nonTerminalsAlives.get(i).getID().equalsIgnoreCase(nonTerminal.getID())) {
                return true;
            }
        }
        return false;
    }

    /**
     * This method let us add a non terminal into a list where we can find non
     * terminals alives
     *
     * @param nonTerminal The non terminal alive
     */
    public void addNonTerminalAlive(NonTerminal nonTerminal) {
        nonTerminalsAlives.add(nonTerminal);
    }

}

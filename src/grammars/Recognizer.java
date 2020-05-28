/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grammars;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Juan Pablo
 */
public final class Recognizer {

    Grammar grammar;
    List<NonTerminal> nonTerminalsVoidables = new ArrayList<>();
    List<Integer> ProductionVoidables = new ArrayList<>();
    HashMap<String, List<Terminal>> firstsNonTerminal = new HashMap<>();
    HashMap<Integer, List<Terminal>> firstsProduction = new HashMap<>();
    HashMap<String, List<Terminal>> aftersNonTerminal = new HashMap<>();
    HashMap<Integer, List<Terminal>> selectionProduction = new HashMap<>();

    public Recognizer(Grammar grammar) {
        this.grammar = grammar;
        foundNonTerminalVoidables();
        foundProductionVoidables();
        foundFirstsToNonTerminal();
        foundFirstsToProduction();
        foundAftersNonTerminal();
        foundSetSelect();
    }

    private void foundNonTerminalVoidables() {
        for (NonTerminal nonTerminal : grammar.getLeftSiders()) {
            if (this.isNonTerminalVoidable(nonTerminal)) {
                boolean contains = false;
                for (NonTerminal nonTerminal2 : nonTerminalsVoidables) {
                    if (nonTerminal2.getID().equals(nonTerminal.getID())) {
                        contains = true;
                        break;
                    }
                }
                if (!contains) {
                    nonTerminalsVoidables.add(nonTerminal);
                }
            }
        }
    }

    private boolean isNonTerminalVoidable(NonTerminal nonTerminal) {
        String idNonTerminal = nonTerminal.getID();
        boolean isVoidable = false;
        for (Production production : grammar.getProductions()) {
            if (production.getLeftSide().getID().equals(idNonTerminal)) {
                if (production.firstItemIsLambda()) {
                    isVoidable = true;
                } else {
                    if (production.terminalsInRight.isEmpty()) {
                        boolean auxiliar = false;
                        for (NonTerminal nonTerminalP : production.nonTerminalsInRight) {
                            if (nonTerminalP.getID().equals(nonTerminal.getID())) {
                                auxiliar = false;
                                break;
                            }
                            auxiliar = this.isNonTerminalVoidable(nonTerminalP);
                        }
                        isVoidable = auxiliar;
                    }
                }
            }
        }
        return isVoidable;
    }

    private void foundProductionVoidables() {
        int j = 0;
        for (Production production : grammar.getProductions()) {
            if (production.firstItemIsLambda()) {
                ProductionVoidables.add(j);
            } else {
                if (production.isRightSideAllNotTerminals()) {
                    int i = 0;
                    boolean auxiliar = false;
                    while (i < production.nonTerminalsInRight.size()) {
                        if (!this.isNonTerminalVoidable(production.nonTerminalsInRight.get(i))) {
                            auxiliar = true;
                            break;
                            
                        } else {
                            i++;
                        }
                    }
                    if (!auxiliar) {
                        ProductionVoidables.add(j);
                    }
                }
            }
            j++;
        }
    }

    private void foundFirstsToNonTerminal() {
        for (NonTerminal nonTerminal : grammar.getLeftSiders()) {
            firstsNonTerminal.put(nonTerminal.getID(), this.FirstsToNonTerminal(nonTerminal));
        }
    }

    private List<Terminal> FirstsToNonTerminal(NonTerminal nonTerminal) {
        String idNonTerminal = nonTerminal.getID();
        List<Terminal> firsts = new ArrayList<>();
        for (Production production : grammar.getProductions()) {
            if (production.getLeftSide().getID().equals(idNonTerminal)) {
                if (!production.firstItemIsLambda()) {
                    if (production.firstItemIsTerminal()) {
                        firsts.add(production.firstItemTerminal());
                    } else {
                        if (production.firstItemNonTerminal().getID().equals(nonTerminal.getID())) {
                            continue;
                        }
                        firsts.addAll(this.FirstsToNonTerminal(production.firstItemNonTerminal()));
                        boolean contains = false;
                        for (NonTerminal nonTerminalP : this.nonTerminalsVoidables) {
                            if (production.firstItemNonTerminal().getID().equals(nonTerminalP.getID())) {
                                contains = true;
                                break;
                            }
                        }
                        if (contains) {
                            Production productionAuxiliar = new Production();
                            for (int i = 0; i < production.rightSide.size(); i++) {
                                productionAuxiliar.rightSide.add(production.rightSide.get(i));
                            }
                            productionAuxiliar.rightSide.remove(0);
                            if (productionAuxiliar.rightSide.size() > 0) {
                                if (productionAuxiliar.firstItemIsTerminal()) {
                                    firsts.add(productionAuxiliar.firstItemTerminal());
                                } else {
                                    if (productionAuxiliar.firstItemNonTerminal().getID().equals(nonTerminal.getID())) {
                                        continue;
                                    }
                                    firsts.addAll(this.FirstsToNonTerminal(productionAuxiliar.firstItemNonTerminal()));
                                }
                            }
                        }
                    }
                }
            }
        }
        return firsts;
    }

    private void foundFirstsToProduction() {
        int i = 0;
        for (Production production : grammar.getProductions()) {
            List<Terminal> firsts = new ArrayList<>();
            if (!production.firstItemIsLambda()) {
                if (production.firstItemIsTerminal()) {
                    firsts.add(production.firstItemTerminal());
                } else {
                    firsts.addAll(this.firstsNonTerminal.get(production.firstItemNonTerminal().getID()));
                    boolean contains = false;
                    for (NonTerminal nonTerminalP : this.nonTerminalsVoidables) {
                        if (production.firstItemNonTerminal().getID().equals(nonTerminalP.getID())) {
                            contains = true;
                            break;
                        }
                    }
                    if (contains) {
                        Production productionAuxiliar = new Production();
                        for (int j = 0; j < production.rightSide.size(); j++) {
                            productionAuxiliar.rightSide.add(production.rightSide.get(j));
                        }
                        productionAuxiliar.rightSide.remove(0);
                        if (productionAuxiliar.rightSide.size() > 0) {
                            if (productionAuxiliar.firstItemIsTerminal()) {
                                firsts.add(productionAuxiliar.firstItemTerminal());
                            } else {
                                firsts.addAll(this.FirstsToNonTerminal(productionAuxiliar.firstItemNonTerminal()));
                            }
                        }
                    }
                }
            }
            firstsProduction.put(i, firsts);
            i++;
        }
    }

    private List<Terminal> aftersToNonTerminal(NonTerminal nonTerminal) {
        String idNonTerminal = nonTerminal.getID();
        List<Terminal> afters = new ArrayList<>();
        if (grammar.getProductions().get(0).getLeftSide().getID().equals(idNonTerminal)) {
            Terminal fin = new Terminal('|');
            afters.add(fin);
        }
        for (Production production : grammar.getProductions()) {
            boolean contain = false;
            for (NonTerminal nonTerminalP : production.nonTerminalsInRight) {
                if (nonTerminalP.getID().equals(idNonTerminal)) {
                    contain = true;
                }
            }
            if (contain) {
                Production productionAuxiliar = new Production();
                for (int i = 0; i < production.rightSide.size(); i++) {
                    productionAuxiliar.rightSide.add(production.rightSide.get(i));
                }
                boolean ready = false;
                while (productionAuxiliar.rightSide.size() > 0) {
                    if (!ready) {
                        if (!productionAuxiliar.firstItemIsTerminal()) {
                            if (productionAuxiliar.firstItemNonTerminal().getID().equals(idNonTerminal)) {
                                ready = true;
                                productionAuxiliar.rightSide.remove(0);
                                break;
                            }
                        }
                        productionAuxiliar.rightSide.remove(0);
                    }
                }
                if (productionAuxiliar.rightSide.isEmpty()) {
                    if (production.getLeftSide().getID().equals(nonTerminal.getID())) {
                        continue;
                    }
                    afters.addAll(this.aftersToNonTerminal(production.getLeftSide()));
                }
                while (!productionAuxiliar.rightSide.isEmpty()) {
                    if (productionAuxiliar.firstItemIsTerminal()) {
                        afters.add(productionAuxiliar.firstItemTerminal());
                        break;
                    } else {
                        afters.addAll(this.firstsNonTerminal.get(productionAuxiliar.firstItemNonTerminal().getID()));
                        boolean contains = false;
                        for (NonTerminal noTerminalV : this.nonTerminalsVoidables) {
                            if (noTerminalV.getID().equals(productionAuxiliar.firstItemNonTerminal().getID())) {
                                contains = true;
                            }
                        }
                        if (contains) {
                            if (productionAuxiliar.rightSide.size() == 1) {
                                if (production.getLeftSide().getID().equals(nonTerminal.getID())) {
                                    continue;
                                }
                                afters.addAll(this.aftersToNonTerminal(production.getLeftSide()));
                            }
                            productionAuxiliar.rightSide.remove(0);
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return afters;
    }

    private void foundAftersNonTerminal() {
        for (NonTerminal nonTerminal : grammar.getLeftSiders()) {
            this.aftersNonTerminal.put(nonTerminal.getID(), this.aftersToNonTerminal(nonTerminal));
        }
    }
    
    private void foundSetSelect(){
        int i=0;
        for(Production production : grammar.getProductions()){
            List<Terminal> select = new ArrayList<>();
            select.addAll(this.firstsProduction.get(i));
            if(this.ProductionVoidables.contains(i)){
                select.addAll(this.aftersNonTerminal.get(production.getLeftSide().getID()));
            }
            selectionProduction.put(i, select);
            i++;
        }
    }

}

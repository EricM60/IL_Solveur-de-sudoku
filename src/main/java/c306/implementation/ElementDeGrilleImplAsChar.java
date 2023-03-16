package c306.implementation;

import c306.sudoku.ElementDeGrille;

/**
* Les elements de la grille (de 1 a f @=vide).
*/
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    /**
     * elements.
     * elements = les elements de la grille
     */
    private final char element;

    private boolean vi;

    /**
     * Constructeur de la classe.
     * @param elements entier
     */
    public ElementDeGrilleImplAsChar(final char elements) {
        this.element = elements;
        this.vi =false;
    }

    /**
     * Constructeur de la classe.
     * @param elements entier
     */
    public ElementDeGrilleImplAsChar(final char elements,boolean viM) {
        this.element = elements;
        this.vi =viM;
    }

    public boolean getVi() {
        return vi;
    }

}

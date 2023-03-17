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

    /**
     * Validation valeur initiale de la grille.
     */
    private boolean vi;

    /**
     * Constructeur de la classe.
     * @param elements entier
     */
    public ElementDeGrilleImplAsChar(final char elements) {
        this.element = elements;
        this.vi = false;
    }

    /**
     * Constructeur de la classe.
     * @param elements entier
     * @param viM booléen
     */
    public ElementDeGrilleImplAsChar(final char elements, final boolean viM) {
        this.element = elements;
        this.vi = viM;
    }

    /**
     * retourne la validation de la valeur initiale.
     * @return la validation que c'est une valeur initiale
     */
    public final boolean getVi() {
        return vi;
    }

    /**
     * retourne la valeur de element.
     * @return le charactere dans l'objet
     */
    public final char getElement() {
        return element;
    }

}

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
    char element;

    /**
     * @return la valeur de elements
     */
    public char getElements() {
        return element;
    }

    /**
     *  assignation d'une valeur à la variable elements
     * @param elements entier
     */
    public void setElements(char elements) {
        this.element = element;
    }

    /**
     * Constructeur de la classe.
     * @param elements entier
     */
    public ElementDeGrilleImplAsChar(char elements) {
        this.element = elements;
    }
    
}

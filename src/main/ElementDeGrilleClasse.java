package main;

import c306.sudoku.ElementDeGrille;

/**
* Les elements de la grille (de 1 a 9).
*/
public class ElementDeGrilleClasse implements ElementDeGrille {
    /**
     * elements.
     * elements = les elements de la grille
     */
    int elements;

    /**
     * @return la valeur de elements
     */
    public int getElements() {
        return elements;
    }

    /**
     *  assignation d'une valeur à la variable elements
     * @param elements entier
     */
    public void setElements(int elements) {
        this.elements = elements;
    }

    /**
     * Constructeur de la classe.
     * @param elements entier
     */
    public ElementDeGrilleClasse(int elements) {
        this.elements = elements;
    }
    
}

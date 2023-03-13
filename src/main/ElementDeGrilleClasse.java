package main;

import c306.sudoku.ElementDeGrille;

/**
* Les elements de la grille (de 1 a f @=vide).
*/
public class ElementDeGrilleClasse implements ElementDeGrille {
    /**
     * elements.
     * elements = les elements de la grille
     */
    char elements[] = {"@","0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};

    /**
     * @return la valeur de elements
     */
    public char getElements() {
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

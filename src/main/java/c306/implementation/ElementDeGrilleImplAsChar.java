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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + element;
        result = prime * result + (vi ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        ElementDeGrilleImplAsChar other = (ElementDeGrilleImplAsChar) obj;
        if (element != other.element)
            return false;
        if (vi != other.vi)
            return false;
        return true;
    }

    


}

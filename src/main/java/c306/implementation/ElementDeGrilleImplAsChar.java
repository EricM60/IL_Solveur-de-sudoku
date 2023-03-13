<<<<<<<< HEAD:src/main/java/c306/ElementDeGrilleImplAsChar.java
========
package c306.implementation;
>>>>>>>> 2e32c7d12445b3d175ff9a48a42cb452bba8d54e:src/main/java/c306/implementation/ElementDeGrilleImplAsChar.java


/**
* Les elements de la grille (de 1 a f @=vide).
*/
public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    /**
     * elements.
     * elements = les elements de la grille
     */
    char elements;

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
    public void setElements(char elements) {
        this.elements = elements;
    }

    /**
     * Constructeur de la classe.
     * @param elements entier
     */
    public ElementDeGrilleImplAsChar(char elements) {
        this.elements = elements;
    }
    
}

package c306.exception;

/**
 * definition de CaractereInterditException.
 * @author Groupe C
 */
public class ElementInterditException  extends Exception {
    
    /**
     * Constructeur de la classe.
     * @param error message d'erreur a afficher
     */
    public ElementInterditException(String error) {
        super(error);
    }
}

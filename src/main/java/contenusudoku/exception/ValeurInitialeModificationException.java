package contenusudoku.exception;

/**
 * definition de ValeurInitialeModificationException.
 * 
 * @author Groupe C
 */
public class ValeurInitialeModificationException extends Exception {

    /**
     * Constructeur de la classe.
     * 
     * @param error message d'erreur a afficher
     */
    public ValeurInitialeModificationException(final String error) {
        super(error);
    }
}

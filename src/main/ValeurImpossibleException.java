package main;

/**
 * definition de ValeurImpossibleException.
 * @author Groupe C
 */
public class ValeurImpossibleException  extends Exception {
    
    /**
     * Constructeur de la classe.
     * @param error message d'erreur a afficher
     */
    public ValeurImpossibleException(String error) {
        super(error);
    }
}

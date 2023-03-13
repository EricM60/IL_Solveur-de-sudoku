package main;

/**
 * definition de HorsBorneException.
 * @author Groupe C
 */
public class HorsBornesException extends Exception {
    
    /**
     * Constructeur de la classe.
     * @param error message d'erreur a afficher
     */
    public HorsBornesException(String error) {
        super(error);
    }
}

package contenusudoku.sudoku;

import contenusudoku.exception.ElementInterditException;
import contenusudoku.exception.HorsBornesException;
import contenusudoku.exception.ValeurImpossibleException;
import contenusudoku.exception.ValeurInitialeModificationException;

/**
 * Interface de résolveur de Grille.
 *
 * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
 */
public interface Solveur {
    /**
     * Résoud une Grille.
     *
     * @param grille Grille à résoudre
     * @return true si la grille a été résolue
     * @throws ElementInterditException
     *                                             si un élément interdit
     *                                             est trouvé
     *                                             dans la grille
     * @throws HorsBornesException
     *                                             si une coordonnée de
     *                                             la grille
     *                                             est en dehors
     *                                             des bornes autorisées
     * @throws ValeurInitialeModificationException
     *                                             si une valeur initiale est
     *                                             modifiée
     * @throws ValeurImpossibleException
     *                                             si une valeur est
     *                                             impossible à
     *                                             placer dans la grille
     */
    boolean solve(Grille grille) throws HorsBornesException,
            ElementInterditException, ValeurImpossibleException,
            ValeurInitialeModificationException;
}

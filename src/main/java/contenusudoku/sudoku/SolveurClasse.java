package contenusudoku.sudoku;

import java.util.Set;

import contenusudoku.exception.ElementInterditException;
import contenusudoku.exception.HorsBornesException;
import contenusudoku.exception.ValeurImpossibleException;
import contenusudoku.exception.ValeurInitialeModificationException;

/**
 *
 */
public class SolveurClasse implements Solveur {

    /**
     *
     * @param grille Grille à résoudre
     * @return vrai si resolue
     * @throws HorsBornesException
     *                                             si une valeur est hors
     *                                             des bornes valides
     * @throws ElementInterditException
     *                                             si une valeur est
     *                                             interdite dans une case
     * @throws ValeurInitialeModificationException
     *                                             si une tentative est faite
     *                                             de modifier une valeur
     *                                             initiale
     * @throws ValeurImpossibleException
     *                                             si une valeur ne peut pas
     *                                             être placée dans une case
     */
    public final boolean solve(final Grille grille)
            throws HorsBornesException, ElementInterditException,
            ValeurImpossibleException, ValeurInitialeModificationException {

        System.out.println(grille);
        boolean possible = false;

        Set<ElementDeGrille> elementvalide = grille.getElements();

        if (grille.isComplete()) {
            return true;
        }

        int nbLignes = grille.getDimension();
        int nbColonnes = nbLignes;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                for (ElementDeGrille cases : elementvalide) {
                    possible = grille.isPossible(i, j, cases);
                    ElementDeGrille element = grille.getValue(i, j);
                    System.out.println(i + "," + j + ": "
                            + cases + " possible = " + possible);
                    if (possible && element == null) {
                        grille.setValue(i, j, cases);
                        System.out.println(i + "," + j + ": " + cases);
                        if (solve(grille)) {
                            return true;
                        }
                        grille.setValue(i, j, null);
                    }
                }
            }
        }
        return false;

    }

}

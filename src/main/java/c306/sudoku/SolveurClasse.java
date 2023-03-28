package c306.sudoku;

import java.util.Set;

import c306.exception.ElementInterditException;
import c306.exception.HorsBornesException;
import c306.exception.ValeurImpossibleException;
import c306.exception.ValeurInitialeModificationException;

/**
 *
 */
public class SolveurClasse implements Solveur {

    /**
     *
     * @param grille Grille à résoudre
     * @return vrai si resolue
     * @throws ElementInterditException
     * @throws HorsBornesException
     * @throws ValeurInitialeModificationException
     * @throws ValeurImpossibleException
     */
    public final boolean solve(final Grille grille) throws HorsBornesException, ElementInterditException, ValeurImpossibleException, ValeurInitialeModificationException {

        System.out.println(grille);
        boolean possible = false;

        Set<ElementDeGrille> elementvalide = grille.getElements();

        
        if(grille.isComplete()==true) {
            return true;
        }

        int nbLignes = grille.getDimension();
        int nbColonnes = nbLignes;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                for (ElementDeGrille cases : elementvalide) {
                    possible = grille.isPossible(i, j, cases);
                    ElementDeGrille element = grille.getValue(i, j);
                    System.out.println(i + "," +j + ": " + cases + " possible = "+ possible);
                    if(possible == true && element == null) {
                        grille.setValue(i, j, cases);
                        System.out.println(i + "," +j + ": " + cases);
                        if(solve(grille)) {
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

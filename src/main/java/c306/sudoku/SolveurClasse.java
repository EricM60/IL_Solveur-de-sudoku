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
     */
    public final boolean solve(final Grille grille) {
        boolean resolue = false;

        boolean possible = false;

        Set<ElementDeGrille> elementvalide = grille.getElements();

        double nbLignes = Math.sqrt(grille.getDimension());
        double nbColonnes = Math.sqrt(grille.getDimension());
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                try {
                        for (ElementDeGrille cases : elementvalide) {
                            possible = grille.isPossible(i, j, cases);
                            if(possible == true) {
                                grille.setValue(i, j, cases);
                            }
                        }
                    
                } catch (HorsBornesException e) {
                    System.out.println("valeur hors borne");
                } catch (ElementInterditException e) {
                    System.out.println("valeur interdite");
                } catch (ValeurImpossibleException e) {
                    System.out.println("valeur impossible");
                } catch (ValeurInitialeModificationException e) {
                    System.out.println("valeur initiale non modifiable");
                }
            }
        }

        if(grille.isComplete()==true) {
            resolue = true;
        }

        return resolue;

    }

}

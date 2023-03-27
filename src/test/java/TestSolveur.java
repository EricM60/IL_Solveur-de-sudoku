import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

import c306.implementation.ElementDeGrilleImplAsChar;
import c306.exception.ElementInterditException;
import c306.exception.HorsBornesException;
import c306.exception.ValeurImpossibleException;
import c306.exception.ValeurInitialeModificationException;
import c306.implementation.GrilleImpl;
import c306.sudoku.ElementDeGrille;
import c306.sudoku.Grille;
import c306.sudoku.Solveur;
import c306.sudoku.SolveurClasse;

/**
 * doc .
 *
 * @author eric MARTIN
 */
public class TestSolveur {
    
    ElementDeGrille element0Initial = new ElementDeGrilleImplAsChar('1',true);
    ElementDeGrille element1Initial = new ElementDeGrilleImplAsChar('2',true);
    ElementDeGrille element2Initial = new ElementDeGrilleImplAsChar('3',true);
    ElementDeGrille element3Initial = new ElementDeGrilleImplAsChar('4',true);

    ElementDeGrille[][] elements2d = {
        {element1Initial,null,element2Initial,null},
        {null,null,null,null},
        {null,null,null,null},
        {element2Initial,null,element3Initial,null},
    };

    ElementDeGrille[][] elements2dImpossible = {
        {element0Initial,null,element1Initial, element2Initial},
        {element2Initial,element3Initial,element0Initial,element1Initial},
        {element3Initial,element1Initial,element2Initial,element0Initial},
        {element1Initial,element0Initial,element3Initial,element3Initial},
    };

    ElementDeGrille element1V = new ElementDeGrilleImplAsChar('1');
    ElementDeGrille element2V = new ElementDeGrilleImplAsChar('2');
    ElementDeGrille element3V = new ElementDeGrilleImplAsChar('3');
    ElementDeGrille element4V = new ElementDeGrilleImplAsChar('4');
    ElementDeGrille element5V = new ElementDeGrilleImplAsChar('5');
    ElementDeGrille element6V = new ElementDeGrilleImplAsChar('6');
    ElementDeGrille element7V = new ElementDeGrilleImplAsChar('7');
    ElementDeGrille element8V = new ElementDeGrilleImplAsChar('8');
    ElementDeGrille element9V = new ElementDeGrilleImplAsChar('9');
    ElementDeGrille elementaV = new ElementDeGrilleImplAsChar('a');
    ElementDeGrille elementbV = new ElementDeGrilleImplAsChar('b');
    ElementDeGrille elementcV = new ElementDeGrilleImplAsChar('c');
    ElementDeGrille elementdV = new ElementDeGrilleImplAsChar('d');
    ElementDeGrille elementeV = new ElementDeGrilleImplAsChar('e');
    ElementDeGrille elementfV = new ElementDeGrilleImplAsChar('f');

    private Set<ElementDeGrille>getExpectedElement() {
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(element1V);
        expectedElements.add(element2V);
        expectedElements.add(element3V);
        expectedElements.add(element4V);
        expectedElements.add(element5V);
        expectedElements.add(element6V);
        expectedElements.add(element7V);
        expectedElements.add(element8V);
        expectedElements.add(element9V);
        expectedElements.add(elementaV);
        expectedElements.add(elementbV);
        expectedElements.add(elementcV);
        expectedElements.add(elementdV);
        expectedElements.add(elementeV);
        expectedElements.add(elementfV);
        return expectedElements;
    }
    

    Grille grilleTest = new GrilleImpl(elements2d,this.getExpectedElement());

    Grille grilleTestImpossible = new GrilleImpl(elements2dImpossible,this.getExpectedElement());

    Solveur solve = new SolveurClasse();

    public static void afficherGrille(Grille grille) throws HorsBornesException {
        double nbLignes = Math.sqrt(grille.getDimension());
        double nbColonnes = Math.sqrt(grille.getDimension());
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                System.out.print(grille.getValue(i, j) + " ");
            }
        }
    }

    @Test
    public void tetsgetDimension() throws HorsBornesException {
        afficherGrille(grilleTest);
        assertEquals(true,solve.solve(grilleTest));
        afficherGrille(grilleTest);
        //assertEquals(false,solve.solve(grilleTestImpossible));
    }

}

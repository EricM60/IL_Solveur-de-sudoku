import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import contenusudoku.exception.ElementInterditException;
import contenusudoku.exception.HorsBornesException;
import contenusudoku.exception.ValeurImpossibleException;
import contenusudoku.exception.ValeurInitialeModificationException;
import contenusudoku.implementation.ElementDeGrilleImplAsChar;
import contenusudoku.implementation.GrilleImpl;
import contenusudoku.sudoku.ElementDeGrille;
import contenusudoku.sudoku.Grille;
import contenusudoku.sudoku.Solveur;
import contenusudoku.sudoku.SolveurClasse;

/**
 *  * doc .
 *
 * @author eric MARTIN
 *          
 */
public class TestSolveur {

    ElementDeGrille element0Initial = new ElementDeGrilleImplAsChar('1', true);
    ElementDeGrille element1Initial = new ElementDeGrilleImplAsChar('2', true);
    ElementDeGrille element2Initial = new ElementDeGrilleImplAsChar('3', true);
    ElementDeGrille element3Initial = new ElementDeGrilleImplAsChar('4', true);

    ElementDeGrille[][] elements2d = {
            { element1Initial, null, element2Initial, null },
            { null, null, null, null },
            { null, null, null, null },
            { element2Initial, null, element3Initial, null },
    };

    ElementDeGrille[][] elements2dImpossible = {
            { element0Initial, null, element1Initial, element2Initial },
            { element2Initial, element3Initial, element0Initial, element1Initial },
            { element3Initial, element1Initial, element2Initial, element0Initial },
            { element1Initial, element0Initial, element3Initial, element3Initial },
    };

    ElementDeGrille element1V = new ElementDeGrilleImplAsChar('1');
    ElementDeGrille element2V = new ElementDeGrilleImplAsChar('2');
    ElementDeGrille element3V = new ElementDeGrilleImplAsChar('3');
    ElementDeGrille element4V = new ElementDeGrilleImplAsChar('4');

    private Set<ElementDeGrille> getExpectedElement() {
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(element1V);
        expectedElements.add(element2V);
        expectedElements.add(element3V);
        expectedElements.add(element4V);

        return expectedElements;
    }

    Grille grilleTest = new GrilleImpl(elements2d, this.getExpectedElement());

    Grille grilleTestImpossible = new GrilleImpl(elements2dImpossible, this.getExpectedElement());

    Solveur solve = new SolveurClasse();

    @Timeout(5)
    @Test
    public void tetsgetSolveurValide() throws HorsBornesException, ElementInterditException, ValeurImpossibleException,
            ValeurInitialeModificationException {
        System.out.println(grilleTest);

        boolean resP = solve.solve(grilleTest);

        System.out.println("grille resolue : ");
        System.out.println(grilleTest);

        assertEquals(true, grilleTest.isComplete());
        assertEquals(true, resP);

    }

    @Test
    public void tetsSolveurInvalide() throws HorsBornesException, ElementInterditException, ValeurImpossibleException,
            ValeurInitialeModificationException {

        System.out.println(grilleTestImpossible);
        boolean res = solve.solve(grilleTestImpossible);

        System.out.println(grilleTestImpossible);

        assertEquals(false, res);
    }

}


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import contenusudoku.implementation.ElementDeGrilleImplAsChar;
import contenusudoku.implementation.GrilleImpl;
import contenusudoku.sudoku.ElementDeGrille;
import contenusudoku.sudoku.Grille;

/**
 *  * doc .
 *
 * @author eric MARTIN
 *          
 */
public class TestGrille {

    ElementDeGrille element1Initial = new ElementDeGrilleImplAsChar('1', true);
    ElementDeGrille element2Initial = new ElementDeGrilleImplAsChar('2', true);
    ElementDeGrille element3Initial = new ElementDeGrilleImplAsChar('3', true);
    ElementDeGrille element4Initial = new ElementDeGrilleImplAsChar('4', true);

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

    ElementDeGrille element1nonIninitial = new ElementDeGrilleImplAsChar('4');

    ElementDeGrille[][] elements2d = {
            { element1Initial, element2Initial },
            { element3Initial, element4Initial }
    };

    private Set<ElementDeGrille> getExpectedElement() {
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

    private Set<ElementDeGrille> getExpectedElement4() {
        Set<ElementDeGrille> expectedElements = new HashSet<>();
        expectedElements.add(element1V);
        expectedElements.add(element2V);
        expectedElements.add(element3V);
        expectedElements.add(element4V);
        return expectedElements;
    }

    Grille grilleTest = new GrilleImpl(elements2d, this.getExpectedElement());

    @Test
    public void testgetElements() {

        ElementDeGrille[][] elements2d = {
                { element1nonIninitial, element1nonIninitial },
                { element1nonIninitial, element1nonIninitial }
        };

        GrilleImpl grilleTest = new GrilleImpl(elements2d, this.getExpectedElement());

        Set<ElementDeGrille> possible = grilleTest.getElements();

        // assertEquals(true,possible.equals(expectedElements));

        assertEquals(true, possible.contains(element1V));

    }

    @Test
    public void testgetElementsAutre() {

        ElementDeGrille[][] elements2d = {
                { element1nonIninitial, element1nonIninitial },
                { element1nonIninitial, element1nonIninitial }
        };

        GrilleImpl grilleTest = new GrilleImpl(elements2d, this.getExpectedElement());

        Set<ElementDeGrille> possible = grilleTest.getElements();

        // assertEquals(true,possible.equals(expectedElements));

        assertEquals(true, possible.contains(element1V));

    }

    @Test
    public void tetsgetDimension() {
        ElementDeGrille[][] elements2d = {
                { null, null, null, null },
                { null, null, null, null },
                { null, null, null, null },
                { null, null, null, null }
        };

        GrilleImpl grilleTest = new GrilleImpl(elements2d, this.getExpectedElement4());
        assertEquals(grilleTest.getDimension(), 4);
    }

    @Test
    public void testgetValue() throws Exception {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestGetValue = new GrilleImpl(elements2dVide, this.getExpectedElement());
        assertEquals(null, grilleTestGetValue.getValue(0, 0));
        grilleTestGetValue.setValue(0, 0, element1V);
        assertEquals(element1V, grilleTestGetValue.getValue(0, 0));
    }

    @Test
    public void testisComplete() {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestCompleteF = new GrilleImpl(elements2dVide, this.getExpectedElement());
        assertEquals(false, grilleTestCompleteF.isComplete());

        ElementDeGrille[][] elements2d = {
                { element1Initial, element2Initial },
                { element3Initial, element4Initial }
        };
        Grille grilleTestCompleteV = new GrilleImpl(elements2d, this.getExpectedElement());
        assertEquals(true, grilleTestCompleteV.isComplete());

        ElementDeGrille[][] elements2d2 = {
                { element1Initial, element2Initial },
                { null, element4Initial }
        };
        Grille grilleTestCompleteF2 = new GrilleImpl(elements2d2, this.getExpectedElement());
        assertEquals(false, grilleTestCompleteF2.isComplete());
    }

    // testes grille 3*3 si dim = 9 (testee sur dim 4*4)
    @Test
    public void testisPossible() throws Exception {
        ElementDeGrille[][] elements2d2 = {
                { null, null, null, null },
                { null, null, null, null },
                { null, null, null, null },
                { null, null, null, null }
        };
        Grille grilleTest = new GrilleImpl(elements2d2, this.getExpectedElement4());
        assertEquals(true, grilleTest.isPossible(0, 0, element1V));

        grilleTest.setValue(0, 0, element1V);

        assertEquals(false, grilleTest.isPossible(0, 1, element1V));
        assertEquals(false, grilleTest.isPossible(1, 0, element1V));
        assertEquals(false, grilleTest.isPossible(1, 1, element1V));

        assertEquals(true, grilleTest.isPossible(0, 1, element2V));
        assertEquals(true, grilleTest.isPossible(1, 0, element2V));
        assertEquals(true, grilleTest.isPossible(1, 1, element2V));

        assertEquals(false, grilleTest.isPossible(0, 1, new ElementDeGrilleImplAsChar('1')));
        assertEquals(false, grilleTest.isPossible(1, 0, new ElementDeGrilleImplAsChar('1')));
        assertEquals(false, grilleTest.isPossible(1, 1, new ElementDeGrilleImplAsChar('1')));

        assertEquals(true, grilleTest.isPossible(0, 1, new ElementDeGrilleImplAsChar('2')));
        assertEquals(true, grilleTest.isPossible(1, 0, new ElementDeGrilleImplAsChar('2')));
        assertEquals(true, grilleTest.isPossible(1, 1, new ElementDeGrilleImplAsChar('2')));
    }

    @Test
    public void testisPossibleBug() throws Exception {
        ElementDeGrille[][] elements2d2 = {
                { element2Initial, null, element3Initial, null },
                { null, null, null, null },
                { null, null, null, null },
                { element3Initial, null, element4Initial, null }
        };
        Grille grilleTest = new GrilleImpl(elements2d2, this.getExpectedElement4());
        grilleTest.setValue(0, 1, element4V);
        assertEquals(false, grilleTest.isPossible(0, 3, element4V));
    }

    @Test
    public void testisPossibleBugColonne() throws Exception {
        ElementDeGrille[][] elements2d2 = {
                { element2Initial, element1Initial, element3Initial, null },
                { element4Initial, element3Initial, element1Initial, element2Initial },
                { null, null, element1Initial, null },
                { element3Initial, null, element4Initial, element2Initial }
        };
        Grille grilleTest = new GrilleImpl(elements2d2, this.getExpectedElement4());
        assertEquals(false, grilleTest.isPossible(0, 2, element4V));
    }

    @Test
    public void testisPossibleSousGrille() throws Exception {
        ElementDeGrille[][] elements2d2 = {
                { element2Initial, null, element3Initial, null },
                { null, null, null, null },
                { null, null, null, null },
                { element3Initial, null, element4Initial, null }
        };
        Grille grilleTest = new GrilleImpl(elements2d2, this.getExpectedElement4());
        assertEquals(false, grilleTest.isPossible(1, 1, element2V));
    }

    @Test
    public void testisValeurInitiale() throws Exception {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestVide = new GrilleImpl(elements2dVide, this.getExpectedElement());
        assertEquals(false, grilleTestVide.isValeurInitiale(0, 1));
        grilleTestVide.setValue(0, 1, element1nonIninitial);
        assertEquals(false, grilleTestVide.isValeurInitiale(0, 1));
        ElementDeGrille[][] elements2d = {
                { element1Initial, element2Initial },
                { element3Initial, element4Initial }
        };
        Grille grilleTestVI = new GrilleImpl(elements2d, this.getExpectedElement());
        assertEquals(true, grilleTestVI.isValeurInitiale(0, 1));
    }

    @Test
    public void testSetValue() throws Exception {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestVide = new GrilleImpl(elements2dVide, this.getExpectedElement());

        grilleTestVide.setValue(0, 1, element1nonIninitial);
        assertNotNull(grilleTestVide.getValue(0, 1));
        grilleTestVide.setValue(0, 1, null);
        assertNull(grilleTestVide.getValue(0, 1));
    }
}

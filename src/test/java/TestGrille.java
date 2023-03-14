

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
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

/**
 * doc .
 *
 * @author eric MARTIN
 */
public class TestGrille {


    
    ElementDeGrille element0 = new ElementDeGrilleImplAsChar('1');
    ElementDeGrille element1 = new ElementDeGrilleImplAsChar('2');
    ElementDeGrille element2 = new ElementDeGrilleImplAsChar('3');
    ElementDeGrille element3 = new ElementDeGrilleImplAsChar('4');
    ElementDeGrille[][] elements2d = {
        {element0,element1},
        {element2,element3}
    };


    Grille grilleTest = new GrilleImpl(elements2d);


    @Test
    public void testgetElements() {
        ElementDeGrille[][] elements2d = {
            {element0,element1},
            {element2,element3}
        };

        Set<ElementDeGrille> comparatif = new HashSet<>();
        comparatif.add(element0);
        comparatif.add(element1);
        comparatif.add(element2);
        comparatif.add(element3);

        Grille grilleTest = new GrilleImpl(elements2d);
        assertEquals(comparatif,grilleTest.getElements());
          
    }

    @Test
    public void tetsgetDimension() {
        assertEquals(grilleTest.getDimension(),4);
    }

    @Test
    public void testgetValue() throws Exception {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestGetValue = new GrilleImpl(elements2dVide);
        assertEquals(null,grilleTestGetValue.getValue(0,0));
        grilleTestGetValue.setValue(0, 0, element0);
        assertEquals(element0,grilleTestGetValue.getValue(0,0));
    }

    @Test
    public void testisComplete() {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestCompleteF = new GrilleImpl(elements2dVide);
        assertEquals(false,grilleTestCompleteF.isComplete());

        ElementDeGrille[][] elements2d = {
            {element0,element1},
            {element2,element3}
        };
        Grille grilleTestCompleteV = new GrilleImpl(elements2d);
        assertEquals(true,grilleTestCompleteV.isComplete());

        ElementDeGrille[][] elements2d2 = {
            {element0,element1},
            {null,element3}
        };
        Grille grilleTestCompleteF2 = new GrilleImpl(elements2d2);
        assertEquals(false,grilleTestCompleteF2.isComplete());
    }

    @Test
    public void testisPossible() throws HorsBornesException,ElementInterditException {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestGetValue = new GrilleImpl(elements2dVide);
        assertEquals(true,grilleTestGetValue.isPossible(1,1,element0));
    }

    @Test
    public void testisValeurInitiale() throws Exception{
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestVide = new GrilleImpl(elements2dVide);
        assertEquals(false,grilleTestVide.isValeurInitiale(0,1));
        grilleTestVide.setValue(0, 1, element0);
        assertEquals(true,grilleTestVide.isValeurInitiale(0,1));      
    }
}

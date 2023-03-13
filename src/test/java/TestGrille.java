

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

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
    //ElementDeGrilleImplAsChar[] elements = {element0,element1,element2,element3};
    ElementDeGrille[][] elements2d = {
        {element0,element1},
        {element2,element3}
    };


    Grille grilleTest = new GrilleImpl(elements2d);

    char[] comparatif = {'1','2','3','4'};

    @Test
    public void testgetElements() {
        assertEquals(grilleTest.getElements(),comparatif);
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
        assertEquals(grilleTest.isComplete(),false);
    }

    @Test
    public void testisPossible() throws HorsBornesException,ElementInterditException {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestGetValue = new GrilleImpl(elements2dVide);
        assertEquals(true,grilleTestGetValue.isPossible(1,1,element0));
    }

    @Test
    public void testisValeurInitiale() {
        assertEquals(grilleTest.isValeurInitiale(0,1),true);
    }
}

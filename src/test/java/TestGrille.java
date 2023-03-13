

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

/**
 * doc .
 *
 * @author eric MARTIN
 */
public class TestGrille {


    
    ElementDeGrilleImplAsChar element0 = new ElementDeGrilleImplAsChar('1');
    ElementDeGrilleImplAsChar element1 = new ElementDeGrilleImplAsChar('2');
    ElementDeGrilleImplAsChar element2 = new ElementDeGrilleImplAsChar('3');
    ElementDeGrilleImplAsChar element3 = new ElementDeGrilleImplAsChar('4');
    ElementDeGrilleImplAsChar[] elements = {element0,element1,element2,element3};
    GrilleImpl grilleTest = new GrilleImpl(elements);

    char[] comparatif = {'1','2','3','4'};

    @Test
    public void testgetElements() {
        assertEquals(grilleTest.getElements(),comparatif);
    }

    @Test
    public void tetsgetDimension() {
        assertEquals(grilleTest.getDimension(),2);
    }

    @Test
    public void testgetValue() {
        try {
            grilleTest.setValue(0, 0, elements[0]);
        } catch (HorsBornesException | ValeurImpossibleException | ElementInterditException
                | ValeurInitialeModificationException e) {
            e.printStackTrace();
        }
        assertEquals(grilleTest.getValue(0,0),1);
    }

    @Test
    public void testisComplete() {
        assertEquals(grilleTest.isComplete(),false);
    }

    @Test
    public void testisPossible() {
        try {
            assertEquals(grilleTest.isPossible(1,1,element0),true);
        } catch (HorsBornesException | ElementInterditException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testisValeurInitiale() {
        try {
            grilleTest.setValue(0, 0, elements[2]);
        } catch (HorsBornesException | ValeurImpossibleException | ElementInterditException
                | ValeurInitialeModificationException e) {
            e.printStackTrace();
        }
        assertEquals(grilleTest.isValeurInitiale(0,1),true);
    }
}

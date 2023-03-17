

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


    
    ElementDeGrille element0Initial = new ElementDeGrilleImplAsChar('1',true);
    ElementDeGrille element1Initial = new ElementDeGrilleImplAsChar('2',true);
    ElementDeGrille element2Initial = new ElementDeGrilleImplAsChar('3',true);
    ElementDeGrille element3Initial = new ElementDeGrilleImplAsChar('4',true);

    ElementDeGrille element1nonIninitial = new ElementDeGrilleImplAsChar('4');

    ElementDeGrille[][] elements2d = {
        {element0Initial,element1Initial},
        {element2Initial,element3Initial}
    };


    Grille grilleTest = new GrilleImpl(elements2d);


    @Test
    public void testgetElements() {
        ElementDeGrille[][] elements2d = {
            {element0Initial,element1Initial},
            {element2Initial,element3Initial}
        };

        Set<ElementDeGrille> comparatif = new HashSet<>();
        comparatif.add(element0Initial);
        comparatif.add(element1Initial);
        comparatif.add(element2Initial);
        comparatif.add(element3Initial);

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
        grilleTestGetValue.setValue(0, 0, element0Initial);
        assertEquals(element0Initial,grilleTestGetValue.getValue(0,0));
    }

    @Test
    public void testisComplete() {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestCompleteF = new GrilleImpl(elements2dVide);
        assertEquals(false,grilleTestCompleteF.isComplete());

        ElementDeGrille[][] elements2d = {
            {element0Initial,element1Initial},
            {element2Initial,element3Initial}
        };
        Grille grilleTestCompleteV = new GrilleImpl(elements2d);
        assertEquals(true,grilleTestCompleteV.isComplete());

        ElementDeGrille[][] elements2d2 = {
            {element0Initial,element1Initial},
            {null,element3Initial}
        };
        Grille grilleTestCompleteF2 = new GrilleImpl(elements2d2);
        assertEquals(false,grilleTestCompleteF2.isComplete());
    }
//testes grille 3*3 si dim = 9 (testee sur dim 4*4)
    @Test
    public void testisPossible() throws Exception {
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestGetValue = new GrilleImpl(elements2dVide);
        assertEquals(true,grilleTestGetValue.isPossible(1,1,element0Initial));

        grilleTestGetValue.setValue(1, 1, element0Initial);

        //assertEquals(false,grilleTestGetValue.isPossible(1,1,element0));
        assertEquals(false,grilleTestGetValue.isPossible(0,1,element0Initial));
        assertEquals(false,grilleTestGetValue.isPossible(1,0,element0Initial));
    }

    @Test
    public void testisValeurInitiale() throws Exception{
        ElementDeGrille[][] elements2dVide = new ElementDeGrille[2][2];
        Grille grilleTestVide = new GrilleImpl(elements2dVide);
        assertEquals(false,grilleTestVide.isValeurInitiale(0,1));
        grilleTestVide.setValue(0, 1, element1nonIninitial);
        assertEquals(false,grilleTestVide.isValeurInitiale(0,1));    
        ElementDeGrille[][] elements2d = {
            {element0Initial,element1Initial},
            {element2Initial,element3Initial}
        };
        Grille grilleTestVI = new GrilleImpl(elements2d);  
        assertEquals(true,grilleTestVI.isValeurInitiale(0,1));  
    }
}

package c306.implementation;

import c306.exception.ValeurImpossibleException;
import c306.exception.ValeurInitialeModificationException;
import c306.sudoku.ElementDeGrille;

import java.util.Set;

import c306.exception.*;
import c306.sudoku.Grille;


public class GrilleImpl implements Grille{
    
    private ElementDeGrille[] grille;

    public ElementDeGrille[] getGrille() {
        return grille;
    }

    public void setGrille(ElementDeGrille[] grille) {
        this.grille = grille;
    }

    public GrilleImpl(ElementDeGrille[] grille) {
        this.grille = grille;
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        return null;
    }

    public int getDimension() {
        return 0;
    }


    @Override
    public ElementDeGrille getValue(int x, int y) {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }


    @Override
    public boolean isValeurInitiale(int x,int y) {
        return false;
    }   

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
    
        throw new UnsupportedOperationException("Unimplemented method 'setValue'");
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ElementInterditException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPossible'");
    }
}

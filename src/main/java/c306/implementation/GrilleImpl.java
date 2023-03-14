package c306.implementation;

import c306.exception.ValeurImpossibleException;
import c306.exception.ValeurInitialeModificationException;
import c306.sudoku.ElementDeGrille;

import java.util.HashSet;
import java.util.Set;

import c306.exception.*;
import c306.sudoku.Grille;


public class GrilleImpl implements Grille{
    
    private ElementDeGrille[][] grille;

    public ElementDeGrille[][] getGrille() {
        return grille;
    }

    public void setGrille(ElementDeGrille grille[][]) {
        this.grille = grille;
    }

    public GrilleImpl(ElementDeGrille grille[][]) {
        this.grille = grille;
    }


    @Override
    public Set<ElementDeGrille> getElements() {
        Set<ElementDeGrille> elements = new HashSet<>();
        int nbLignes = grille[0].length;
        int nbColonnes = grille.length;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                ElementDeGrille element = grille[i][j];
                if (element != null && !elements.contains(element)) {
                    elements.add(element);
                }
            }
        }
        return elements;
    }

    public int getDimension() {
        int h = grille.length;
        int l = grille[0].length;
        int dim = h*l;
        return dim;
    }


    @Override
    public ElementDeGrille getValue(int x, int y) {
        return grille[x][y];
    }

    @Override
    public boolean isComplete() {
        boolean bc = true;
        int nbLignes = grille[0].length;
        int nbColonnes = grille.length;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if ((grille[i][j]) == null) {
                    bc = false;
                }
            }
        }
        return bc;
    }


    @Override
    public boolean isValeurInitiale(int x,int y) {
        boolean vi = false;
        if(getValue(x,y)!=null) {
            vi =true;
        }
        return vi;
    }   

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
            grille[x][y]=(ElementDeGrilleImplAsChar)value;
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ElementInterditException {
            
            boolean vp = false;
            
            if(isValeurInitiale(x, y)) {
                vp = false;
            }

        // Vérifie que la valeur n'est pas déjà présente dans la colonne
        for (int i = 0; i < grille.length; i++) {
            if (grille[x][i] == value) {
                return false;
            }
        }
        // Vérifie que la valeur n'est pas déjà présente dans la ligne
            for (int j = 0; j < grille[0].length; j++) {
                if (grille[y][j]  == value) {
                    return false;
            }
        }
        return true;

    }
}
package c306.implementation;

import c306.sudoku.ElementDeGrille;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import c306.exception.*;
import c306.sudoku.Grille;


public class GrilleImpl implements Grille{
    
    private final ElementDeGrille[][] casesGrille;

    private final Set<ElementDeGrille> elementAutorise;

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


    public GrilleImpl(ElementDeGrille grille[][],Set<ElementDeGrille> elementAutorise) {
        this.casesGrille = grille;
        this.elementAutorise = elementAutorise;
    }

    public GrilleImpl(ElementDeGrille grille[][]) {
        this.casesGrille = grille;
        this.elementAutorise = getExpectedElement();
    }


    @Override
    public  Set<ElementDeGrille> getElements() {
        Set<ElementDeGrille> elements = new HashSet<>();
        int taille = elementAutorise.size();
        Iterator iter = elementAutorise.iterator();
        elements.addAll(elementAutorise);
        return elements;
    }

    public int getDimension() {
        int h = casesGrille.length;
        int l = casesGrille[0].length;
        int dim = h*l;
        return dim;
    }


    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        if (x < 0 || x >= casesGrille.length || y < 0 || y >= casesGrille[x].length) {
            throw new HorsBornesException("valeur hors borne");
        }
        return casesGrille[x][y];
    }

    @Override
    public boolean isComplete() {
        boolean bc = true;
        int nbLignes = casesGrille[0].length;
        int nbColonnes = casesGrille.length;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if ((casesGrille[i][j]) == null) {
                    bc = false;
                }
            }
        }
        return bc;
    }


    @Override
    public boolean isValeurInitiale(int x,int y) {
        boolean vi = false;
        
        try {
            if(getValue(x,y)!=null && ((ElementDeGrilleImplAsChar) casesGrille[x][y]).getVi()==true) {
                vi =true;
            }
        } catch (HorsBornesException e) {
            vi =false;
        }
        return vi;
    }   

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
            
                //boolean autorise = false;

                Set<ElementDeGrille> possible = getElements();

                if (x < 0 || x >= casesGrille.length || y < 0 || y >= casesGrille[x].length) {
                    throw new HorsBornesException("valeur hors borne");
                }
                if (this.isValeurInitiale(x,y)) {
                    throw new ValeurInitialeModificationException("impossible de modifier une valeur initiale");
                }
                if (value != null && !isPossible(x, y,value)) {
                    throw new ValeurImpossibleException("valeur impossible a placer");
                }

                if(possible.contains(value)) {
                    casesGrille[x][y]=value;
                }
                else {
                    throw new ElementInterditException("characere interdit");
                }
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ElementInterditException {
            
            if (x < 0 || x >= casesGrille.length || y < 0 || y >= casesGrille[x].length) {
                throw new HorsBornesException("valeur hors borne");
            }
                
            boolean vp = false;
            
            if(isValeurInitiale(x, y)) {
                vp = false;
            }

        // Vérifie que la valeur n'est pas déjà présente dans la colonne
        for (int i = 0; i < casesGrille.length; i++) {
            if (casesGrille[x][i] == value) {
                return false;
            }
        }
        // Vérifie que la valeur n'est pas déjà présente dans la ligne
            for (int j = 0; j < casesGrille[0].length; j++) {
                if (casesGrille[y][j]  == value) {
                    return false;
            }
        }

        //verife que la valeur n'est pas dans la sous grille
        double tailleSousGrille = Math.sqrt(casesGrille.length*casesGrille[0].length);
        int tailleSousGrillereel = (int) Math.floor(tailleSousGrille);
        int debutX = (x / tailleSousGrillereel) * tailleSousGrillereel;
        int debutY = (y / tailleSousGrillereel) * tailleSousGrillereel;
        for (int i = debutX; i < debutX + tailleSousGrillereel; i++) {
            for (int j = debutY; j < debutY + tailleSousGrillereel; j++) {
                if (casesGrille[i][j] == value) {
                    return false;
                }
            }
        }

        return true;

    }
}
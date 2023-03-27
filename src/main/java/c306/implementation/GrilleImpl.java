package c306.implementation;

import c306.exception.ElementInterditException;
import c306.exception.HorsBornesException;
import c306.exception.ValeurImpossibleException;
import c306.exception.ValeurInitialeModificationException;
import c306.sudoku.ElementDeGrille;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import c306.sudoku.Grille;


public class GrilleImpl implements Grille {

    private final ElementDeGrille[][] casesGrille;

    private final Set<ElementDeGrille> elementAutorise;

    private ElementDeGrille element1V = new ElementDeGrilleImplAsChar('1');
    private ElementDeGrille element2V = new ElementDeGrilleImplAsChar('2');
    private ElementDeGrille element3V = new ElementDeGrilleImplAsChar('3');
    private ElementDeGrille element4V = new ElementDeGrilleImplAsChar('4');
    private ElementDeGrille element5V = new ElementDeGrilleImplAsChar('5');
    private ElementDeGrille element6V = new ElementDeGrilleImplAsChar('6');
    private ElementDeGrille element7V = new ElementDeGrilleImplAsChar('7');
    private ElementDeGrille element8V = new ElementDeGrilleImplAsChar('8');
    private ElementDeGrille element9V = new ElementDeGrilleImplAsChar('9');
    private ElementDeGrille elementaV = new ElementDeGrilleImplAsChar('a');
    private ElementDeGrille elementbV = new ElementDeGrilleImplAsChar('b');
    private ElementDeGrille elementcV = new ElementDeGrilleImplAsChar('c');
    private ElementDeGrille elementdV = new ElementDeGrilleImplAsChar('d');
    private ElementDeGrille elementeV = new ElementDeGrilleImplAsChar('e');
    private ElementDeGrille elementfV = new ElementDeGrilleImplAsChar('f');

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


    public GrilleImpl(final ElementDeGrille[][] grille,
    final Set<ElementDeGrille> elementAutorise) {
        this.casesGrille = grille;
        this.elementAutorise = elementAutorise;
    }

    public GrilleImpl(final ElementDeGrille[][] grille) {
        this.casesGrille = grille;
        this.elementAutorise = getExpectedElement();
    }


    @Override
    public final Set<ElementDeGrille> getElements() {
        Set<ElementDeGrille> elements = new HashSet<>();
        int taille = elementAutorise.size();
        Iterator iter = elementAutorise.iterator();
        elements.addAll(elementAutorise);
        return elements;
    }

    public final int getDimension() {
        int h = casesGrille.length;
        int l = casesGrille[0].length;
        int dim = h * l;
        return dim;
    }


    @Override
    public final ElementDeGrille getValue(final int x,final int y)
    throws HorsBornesException {
        if (x < 0 || x >= casesGrille.length || y < 0 || y >= casesGrille[x].length) {
            throw new HorsBornesException("valeur hors borne");
        }
        return casesGrille[x][y];
    }

    @Override
    public final boolean isComplete() {
        boolean bc = true;
        int nbLignes = casesGrille[0].length;
        int nbColonnes = casesGrille.length;
        for (int i = 0; i < nbLignes; i++) {
            for (int j = 0; j < nbColonnes; j++) {
                if (casesGrille[i][j] == null) {
                    bc = false;
                }
            }
        }
        return bc;
    }


    @Override
    public final boolean isValeurInitiale(final int x, final int y) {
        boolean vi = false;
        try {
            if (getValue(x, y) != null && 
            ((ElementDeGrilleImplAsChar) casesGrille[x][y]).getVi() == true) {
                vi = true;
            }
        } catch (HorsBornesException e) {
            vi = false;
        }
        return vi;
    }

    @Override
    public final void setValue(final int x, final int y, final ElementDeGrille value)
    throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {
                //boolean autorise = false;

                Set<ElementDeGrille> possible = getElements();

                if (x < 0 || x >= casesGrille.length ||
                y < 0 || y >= casesGrille[x].length) {
                    throw new HorsBornesException(
                        "valeur hors borne");
                }
                if (this.isValeurInitiale(x,y)) {
                    throw new ValeurInitialeModificationException(
                        "impossible de modifier une valeur initiale");
                }
                if (value != null && !isPossible(x, y,value)) {
                    throw new ValeurImpossibleException(
                        "valeur impossible a placer");
                }

                if(possible.contains(value)) {
                    casesGrille[x][y]=value;
                }
                else {
                    throw new ElementInterditException(
                        "characere interdit");
                }
    }

    @Override
    public final boolean isPossible(final int x, final int y, final ElementDeGrille value)
            throws HorsBornesException, ElementInterditException {
            if (x < 0 || x >= casesGrille.length ||
            y < 0 || y >= casesGrille[x].length) {
                throw new HorsBornesException(
                    "valeur hors borne");
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

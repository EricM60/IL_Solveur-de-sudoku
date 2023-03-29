package c306.implementation;

import c306.exception.ElementInterditException;
import c306.exception.HorsBornesException;
import c306.exception.ValeurImpossibleException;
import c306.exception.ValeurInitialeModificationException;
import c306.sudoku.ElementDeGrille;

import java.util.HashSet;
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

    public GrilleImpl(final ElementDeGrille[][] grille, final Set<ElementDeGrille> paramElementAutorise) {
        this.casesGrille = new ElementDeGrille[grille.length][grille[0].length];

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                this.casesGrille[i][j] = grille[i][j];
            }
        }
        this.elementAutorise = new HashSet<>(getExpectedElement());
        this.elementAutorise.addAll(paramElementAutorise);
    }

    public GrilleImpl(final ElementDeGrille[][] grille) {

        this.casesGrille = new ElementDeGrille[grille.length][grille[0].length];

        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                this.casesGrille[i][j] = grille[i][j];
            }
        }

        this.elementAutorise = getExpectedElement();
    }


    @Override
    public final Set<ElementDeGrille> getElements() {
        Set<ElementDeGrille> elements = new HashSet<>();
        elements.addAll(elementAutorise);
        return elements;
    }

    public final int getDimension() {
        int dimension = casesGrille.length;
        return dimension;
    }


    @Override
    public final ElementDeGrille getValue(final int x, final int y)
    throws HorsBornesException {
        if (x < 0 || x >= casesGrille.length
        || y < 0 || y >= casesGrille[x].length) {
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
            if (getValue(x, y) != null
            && ((ElementDeGrilleImplAsChar)
            casesGrille[x][y]).getVi() == true) {
                vi = true;
            }
        } catch (HorsBornesException e) {
            vi = false;
        }
        return vi;
    }

    @Override
    public final void setValue(final int x, final int y,
    final ElementDeGrille value)
    throws HorsBornesException, ValeurImpossibleException,
            ElementInterditException, ValeurInitialeModificationException {

                if (x < 0 || x >= casesGrille.length
                || y < 0 || y >= casesGrille[x].length) {
                    throw new HorsBornesException(
                        "valeur hors borne");
                }
                if (this.isValeurInitiale(x, y)) {
                    throw new ValeurInitialeModificationException(
                        "impossible de modifier une valeur initiale");
                }

                if (!isPossible(x, y, value)) {
                    throw new ValeurImpossibleException(
                        "valeur impossible a placer");
                } else {
                    casesGrille[x][y] = value;
                }

            }

    @Override
    public final boolean isPossible(
        final int x, final int y, final ElementDeGrille value)
            throws HorsBornesException, ElementInterditException {

            

            if (!elementAutorise.contains(value) && value != null) {
                throw new ElementInterditException(
                    "characere interdit");
            }

            if (x < 0 || x >= casesGrille.length
            || y < 0 || y >= casesGrille[x].length) {
                throw new HorsBornesException(
                    "valeur hors borne");
            }
            
            
            if (isValeurInitiale(x, y)) {
                return false;
            }

            if(value == null) {
                return true;
            }

        // Vérifie que la valeur n'est pas déjà présente dans la ligne
        for (int i = 0; i < getDimension(); i++) {
            if (value.equals(casesGrille[x][i])) {
                return false;
            }
        }
        // Vérifie que la valeur n'est pas déjà présente dans la colonne
            for (int j = 0; j < getDimension(); j++) {
                if (value.equals(casesGrille[j][y])) {
                    return false;
            }
        }

        //verife que la valeur n'est pas dans la sous grille
        double tailleSousGrille = Math.sqrt(getDimension());
        int tailleSousGrillereel = (int) Math.floor(tailleSousGrille);
        int debutX = (x / tailleSousGrillereel) * tailleSousGrillereel;
        int debutY = (y / tailleSousGrillereel) * tailleSousGrillereel;
        for (int i = debutX; i < debutX + tailleSousGrillereel; i++) {
            for (int j = debutY; j < debutY + tailleSousGrillereel; j++) {
                if (value.equals(casesGrille[i][j])) {
                    return false;
                }
            }
        }

        return true;

    }

    @Override
    public String toString() {
        StringBuilder chaine = new StringBuilder();
        double nbLignes = getDimension();
        double nbColonnes = nbLignes;
        for (int i = 0; i < nbLignes; i++) {
            chaine.append(i + ": ");
            for (int j = 0; j < nbColonnes; j++) {
                chaine.append(casesGrille[i][j] + " ");
            }
            chaine.append('\n');
        }
        return chaine.toString();
    }
}

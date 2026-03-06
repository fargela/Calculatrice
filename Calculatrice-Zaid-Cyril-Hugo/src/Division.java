import exceptions.DivisionParZeroException;

public class Division extends Binaire {

    /**
     * Calcul de la division
     * @param gauche: nombre de gauche
     * @param droite: nombre de droite
     * @return resultat de la division
     */
    @Override
    public double calculer(double gauche, double droite) throws DivisionParZeroException {
        validerDivisionParZero(droite);
        return gauche / droite;
    }

    /**
     * Gestion de la division par 0
     * @param droite: nombre de droite = 0
     * @throws DivisionParZeroException
     */
    public void validerDivisionParZero(double droite) throws DivisionParZeroException {
        if (droite == 0) {
            throw new DivisionParZeroException("La division par zéro est interdite");
        }
    }
}
import exceptions.DivisionParZeroException;

public abstract class Binaire extends Operateur {

    /**
     * Classe abstraite pour le calcul des additions, soustractions, multiplications et divisions
     * @param gauche: nombre saisi par l'utilisateur
     * @param droite: nombre saisi par l'utilisateur
     * @return
     * @throws DivisionParZeroException
     */
    public abstract double calculer(double gauche, double droite) throws DivisionParZeroException;

    @Override
    public double calculer() {
        return 0;
    }
}
public abstract class Unaire extends Operateur {

    /**
     * Classe abstraite pour le calcul de la factorielle
     * @param valeur: nombre saisi par l'utilisateur
     * @return
     */
    public abstract double calculer(double valeur);

    @Override
    public double calculer() {
        return 0;
    }
}
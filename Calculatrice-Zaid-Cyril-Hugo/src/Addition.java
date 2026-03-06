public class Addition extends Binaire {

    /**
     * Calcul de l'addition
     * @param gauche: nombre saisi par l'utilisateur
     * @param droite: nombre saisi par l'utilisateur
     * @return la somme de l'addition
     */
    @Override
    public double calculer(double gauche, double droite) {
        return gauche + droite;
    }
}
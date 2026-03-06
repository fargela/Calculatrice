public class Soustraction extends Binaire {

    /**
     * Calcul la soustraction
     * @param gauche: nombre saisi par l'utilisateur
     * @param droite: nombre saisi par l'utilisateur
     * @return le resultat de la soustraction
     */
    @Override
    public double calculer(double gauche, double droite) {
        return gauche - droite;
    }
}
public class Multiplication extends Binaire {

    /**
     * Calcul la multiplication
     * @param gauche: nombre saisi par l'utilisateur
     * @param droite: nombre saisi par l'utilisateur
     * @return le résultat de la multiplication
     */
    @Override
    public double calculer(double gauche, double droite) {
        return gauche * droite;
    }
}
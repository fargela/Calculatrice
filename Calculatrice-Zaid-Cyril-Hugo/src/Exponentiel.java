public class Exponentiel extends Binaire {

    /**
     * Calcul de l'exposant
     * @param base: nombre saisi par l'utilisateur
     * @param exposant: nombre saisi par l'utilisateur
     * @return
     */
    @Override
    public double calculer(double base, double exposant) {
        return Math.pow(base, exposant);
    }
}
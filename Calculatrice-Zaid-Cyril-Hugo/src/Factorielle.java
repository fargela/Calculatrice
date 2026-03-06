import exceptions.InvalideOperandeException;

public class Factorielle extends Unaire {

    /**
     * Calcul de la factorielle d'un nombre
     * @param valeur: nombre saisi par l'utilisateur
     * @return la factorielle du nombre saisi par l'utilisateur
     */
    @Override
    public double calculer(double valeur) throws InvalideOperandeException {
        if (valeur < 0) {
            throw new InvalideOperandeException("La factorielle n'est pas définie pour les nombres négatifs : " + valeur);
        }

        int n = (int) valeur;
        long resultat = 1;
        for (int i = 2; i <= n; i++) {
            resultat *= i;
        }
        return resultat;
    }
}
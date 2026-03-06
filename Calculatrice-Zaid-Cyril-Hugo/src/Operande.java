import exceptions.InvalideOperandeException;

public class Operande {

    private final double valeur;

    public Operande(String valeur) throws InvalideOperandeException {
        try {
            this.valeur = Double.parseDouble(valeur.trim());
        } catch (NumberFormatException e) {
            throw new InvalideOperandeException(valeur + "  n'est pas un valeur valide");
        }
    }

    public double getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return String.valueOf(valeur);
    }
}

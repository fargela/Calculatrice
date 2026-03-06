public class ExpressionUnaire extends Expression {

    private final Operande valeur;

    public ExpressionUnaire(Operande valeur, Operateur operateur) {
        super(operateur);
        this.valeur = valeur;
    }

    @Override
    public double calculer() {
        return ((Unaire) operateur).calculer(valeur.getValeur());
    }

    public Operande getValeur() {
        return valeur;
    }

    @Override
    public String toString() {
        return valeur + " " + operateur;
    }
}


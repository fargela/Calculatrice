import exceptions.DivisionParZeroException;

public class ExpressionBinaire extends Expression {

    private final Operande valeurGauche;
    private final Operande valeurDroite;

    public ExpressionBinaire(Operande valeurGauche, Operande valeurDroite, Operateur operateur) {
        super(operateur);
        this.valeurGauche = valeurGauche;
        this.valeurDroite = valeurDroite;
    }

    @Override
    public double calculer() throws DivisionParZeroException {
        return ((Binaire) operateur).calculer(
                valeurGauche.getValeur(),
                valeurDroite.getValeur()
        );
    }

    public Operande getValeurGauche() { return valeurGauche; }
    public Operande getValeurDroite() { return valeurDroite; }

    @Override
    public String toString() {
        return valeurGauche + " " + operateur + " " + valeurDroite;
    }
}

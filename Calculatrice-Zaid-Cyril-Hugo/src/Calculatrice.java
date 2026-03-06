import exceptions.DivisionParZeroException;
import exceptions.ExpressionInvalideException;
import exceptions.InvalideOperandeException;
import exceptions.OperateurInconnuException;

public class Calculatrice {

    private final Validateur validateur;
    private final Parseur parseur;
    private final Calculateur calculateur;

    public Calculatrice(Validateur validateur, Parseur parseur, Calculateur calculateur) {
        this.validateur = validateur;
        this.parseur = parseur;
        this.calculateur = calculateur;
    }

    // BUG CORRIGE : ExpressionInvalideException, OperateurInconnuException et
    // InvalideOperandeException sont des RuntimeException, inutile de les déclarer
    // dans throws. Seul DivisionParZeroException (checked) doit y figurer.
    public double calculer(String expression) throws DivisionParZeroException {
        String exprValidee = validateur.valider(expression);   // peut lever ExpressionInvalideException (Runtime)
        Expression parsed = parseur.parse(exprValidee);        // peut lever OperateurInconnuException / InvalideOperandeException (Runtime)
        return calculateur.calculer(parsed);                   // peut lever DivisionParZeroException (checked)
    }
}

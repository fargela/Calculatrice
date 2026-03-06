import exceptions.InvalideOperandeException;
import exceptions.OperateurInconnuException;

public class Parseur {

    private final OperateurFactory factory;

    public Parseur(OperateurFactory factory) {
        this.factory = factory;
    }

    public Expression parse(String input) throws InvalideOperandeException, OperateurInconnuException {
        String expr = input.trim();
        String[] tokens = expr.split("\\s+"); // 1+ espaces

        // Binaire : "a op b"  (ex: "3 + 5", "2 ^ 3")
        if (tokens.length == 3) {
            String gaucheStr = tokens[0];
            String opStr     = tokens[1];
            String droiteStr = tokens[2];

            Operande gauche   = new Operande(gaucheStr);
            Operateur operateur = factory.creerOperateur(opStr);
            Operande droite   = new Operande(droiteStr);

            return new ExpressionBinaire(gauche, droite, operateur);
        }

        // Unaire : "a !"  (ex: "5 !")
        // BUG CORRIGE : on vérifie que l'opérateur est bien une instance de Unaire
        // avant de créer une ExpressionUnaire, pour éviter le ClassCastException
        if (tokens.length == 2) {
            String valeurStr = tokens[0];
            String opStr     = tokens[1];

            Operateur operateur = factory.creerOperateur(opStr);

            if (!(operateur instanceof Unaire)) {
                throw new OperateurInconnuException(
                    "L'opérateur '" + opStr + "' n'est pas un opérateur unaire. Attendu: '!'"
                );
            }

            Operande valeur = new Operande(valeurStr);
            return new ExpressionUnaire(valeur, operateur);
        }

        throw new InvalideOperandeException(expr + " n'est pas une expression valide");
    }

    @Override
    public String toString() {
        return "Parseur{}";
    }
}

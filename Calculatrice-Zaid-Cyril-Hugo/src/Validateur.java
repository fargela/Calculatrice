import exceptions.ExpressionInvalideException;

public class Validateur {

    public String valider(String expression) {
        if (expression == null || expression.isBlank()) {
            throw new ExpressionInvalideException("L'expression ne peut pas être vide.");
        }

        String expr = expression.trim();

        // 1) Factorielle : "5!", "5 !", "-3.5!"
        if (expr.matches("^-?\\d+(\\.\\d+)?\\s*!$")) {
            return expr.replace("!", "").trim() + " !";
        }

        // 2) Expression binaire : espaces optionnels (accepte "2+3" et "2 + 3")
        String nombre = "\\(?-?\\d+(\\.\\d+)?\\)?";
        String regexBinaire = "^" + nombre + "\\s*[+\\-*/^]\\s*" + nombre + "$";

        if (!expr.matches(regexBinaire)) {
            throw new ExpressionInvalideException(
                    "Format invalide : attendu ex. '2+3', '-2 + 3', '2^3' ou '5!' — reçu : '" + expression + "'"
            );
        }

        // 3) Extraire et reformater proprement "gauche op droite"
        // Groupes Java : $1=gauche(avec parenth.), $2=.decimal gauche, $3=op, $4=droite(avec parenth.), $5=.decimal droite
        String regexCapture = "^(" + nombre + ")\\s*([+\\-*/^])\\s*(" + nombre + ")$";
        return expr.replaceAll(regexCapture, "$1 $3 $4");
    }
}

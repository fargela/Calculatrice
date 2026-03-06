import exceptions.OperateurInconnuException;

public class OperateurFactory {

    public Operateur creerOperateur(String symbole) throws OperateurInconnuException {
        switch (symbole) {
            case "+": return new Addition();
            case "-": return new Soustraction();
            case "*": return new Multiplication();
            case "/": return new Division();
            case "^": return new Exponentiel();
            case "!": return new Factorielle();
            default:
                throw new OperateurInconnuException(
                        "Opérateur inconnu : '" + symbole + "'"
                );
        }
    }

    @Override
    public String toString() {
        return "OperateurFactory{}";
    }
}

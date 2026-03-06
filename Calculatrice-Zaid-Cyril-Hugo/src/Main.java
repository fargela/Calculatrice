import exceptions.ExpressionInvalideException;
import exceptions.DivisionParZeroException;
import exceptions.OperateurInconnuException;
import exceptions.InvalideOperandeException;

public class Main {

    public static void main(String[] args) {
        Validateur validateur = new Validateur();
        OperateurFactory factory = new OperateurFactory();
        Parseur parseur = new Parseur(factory);
        Calculateur calculateur = new Calculateur();
        Calculatrice calculatrice = new Calculatrice(validateur, parseur, calculateur);

        try (InterfaceUtilisateur ui = new InterfaceUtilisateur()) {

            ui.afficherRegles();

            String input = ui.lireInput();   // une seule saisie

            try {
                double resultat = calculatrice.calculer(input);
                ui.afficherResultat(resultat);
            } catch (ExpressionInvalideException
                     | DivisionParZeroException
                     | OperateurInconnuException
                     | InvalideOperandeException e) {
                ui.afficherErreur(e);
            }
        }
    }
}

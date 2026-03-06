import java.util.Scanner;
public class InterfaceUtilisateur implements AutoCloseable {

    private final Scanner scanner;

    public InterfaceUtilisateur() {
        this.scanner = new Scanner(System.in);
    }

    public void afficherResultat(double resultat) {
        if (resultat == Math.floor(resultat)) {
            System.out.println("= " + (long) resultat);
        } else {
            System.out.println("= " + resultat);
        }
    }

    public void afficherErreur(Exception e) {
        System.err.println("[ERREUR] " + e.getMessage());
    }

    public String lireInput() {
        System.out.print("Entrez une expression : ");
        return scanner.nextLine();
    }

    public void afficherRegles() {
        System.out.println("""
                === Calculatrice ===
                Entrez une expression du type : 3 + 5 ou 10 / 2
                Opérateurs supportés : +  -  *  / ! ^
                Tapez 'entrer' pour valider.
                ====================""");
    }

    @Override
    public void close() {
        scanner.close();
    }
}



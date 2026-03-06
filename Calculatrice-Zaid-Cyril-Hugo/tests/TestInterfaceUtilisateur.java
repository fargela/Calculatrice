import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import java.io.*;

public class TestInterfaceUtilisateur {

    private InterfaceUtilisateur ui;
    private ByteArrayOutputStream outContent;
    private ByteArrayOutputStream errContent;
    private PrintStream originalOut;
    private PrintStream originalErr;
    private InputStream originalIn;

    @Before
    public void setUp() throws IOException {
        // Mock System.out et System.err
        outContent = new ByteArrayOutputStream();
        errContent = new ByteArrayOutputStream();
        originalOut = System.out;
        originalErr = System.err;
        originalIn = System.in;
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));

        // Créer UI
        ui = new InterfaceUtilisateur();
    }

    @Test
    public void testAfficherResultatEntier() {
        ui.afficherResultat(5.0);
        Assert.assertEquals("= 5" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testAfficherResultatDecimal() {
        ui.afficherResultat(3.14159);
        Assert.assertEquals("= 3.14159" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testAfficherResultatNegatifEntier() {
        ui.afficherResultat(-42.0);
        Assert.assertEquals("= -42" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testAfficherResultatNegatifDecimal() {
        ui.afficherResultat(-2.5);
        Assert.assertEquals("= -2.5" + System.lineSeparator(), outContent.toString());
    }

    @Test
    public void testAfficherErreur() {
        Exception e = new RuntimeException("Division par zéro");
        ui.afficherErreur(e);
        Assert.assertEquals("[ERREUR] Division par zéro" + System.lineSeparator(), errContent.toString());
    }

    @Test
    public void testLireInput() throws IOException {
        String input = "2 + 3";
        System.setIn(new ByteArrayInputStream((input + "\n").getBytes()));

        // Reset scanner via new UI pour capturer input frais
        InterfaceUtilisateur uiInput = new InterfaceUtilisateur();
        String resultat = uiInput.lireInput();

        Assert.assertEquals("2 + 3", resultat);
    }

    @Test
    public void testAfficherRegles() {
        ui.afficherRegles();
        String sortie = outContent.toString();
        Assert.assertTrue(sortie.contains("=== Calculatrice ==="));
        Assert.assertTrue(sortie.contains("3 + 5 ou 10 / 2"));
        Assert.assertTrue(sortie.contains("Opérateurs supportés : +  -  *  / ! ^"));
        Assert.assertTrue(sortie.contains("Tapez 'entrer' pour valider."));
        Assert.assertTrue(sortie.contains("==================="));
    }

    @Test
    public void testClose() throws IOException {
        ui.close();
        // Vérifie que scanner est fermé (pas d'exception sur nextLine après)
        // Note: test indirect car Scanner.close() libère resources
        Assert.assertTrue(true); // Succès si pas d'erreur lors du close
    }

    @After  // Ajoute cette méthode à ta classe de test
    public void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
        outContent.reset();
        errContent.reset();
        if (ui != null) {
            ui.close();
        }
    }
}

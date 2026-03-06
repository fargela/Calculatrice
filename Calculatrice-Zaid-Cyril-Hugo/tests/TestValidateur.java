import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import exceptions.ExpressionInvalideException;

public class TestValidateur {

    private Validateur validateur;

    @Before
    public void setUp() {
        this.validateur = new Validateur();
    }

    @Test
    public void testExpressionBinaireSimple() {
        String resultat = this.validateur.valider("2 + 3");
        Assert.assertEquals("2 + 3", resultat);
    }

    @Test
    public void testExpressionAvecNegatifs() {
        String resultat = this.validateur.valider("-2 + 3");
        Assert.assertEquals("-2 + 3", resultat);
    }

    @Test
    public void testExpressionAvecParantheses() {
        String resultat = this.validateur.valider("(-2 * 4)");
        Assert.assertEquals("(-2 * 4)", resultat);
    }

    @Test
    public void testExpressionDecimales() {
        String resultat = this.validateur.valider("-2.5 + 1.2");
        Assert.assertEquals("-2.5 + 1.2", resultat);
    }

    // BUG CORRIGE : le validateur normalise "5!" en "5 !" (avec espace)
    @Test
    public void testFactorielleSimple() {
        String resultat = this.validateur.valider("5!");
        Assert.assertEquals("5 !", resultat);
    }

    @Test
    public void testFactorielleAvecEspace() {
        String resultat = this.validateur.valider("5 !");
        Assert.assertEquals("5 !", resultat);
    }

    // BUG CORRIGE : même normalisation pour les négatifs et décimaux
    @Test
    public void testFactorielleNegative() {
        String resultat = this.validateur.valider("-5!");
        Assert.assertEquals("-5 !", resultat);
    }

    @Test
    public void testFactorielleDecimal() {
        String resultat = this.validateur.valider("3.5!");
        Assert.assertEquals("3.5 !", resultat);
    }

    @Test
    public void testTrimEspaces() {
        String resultat = this.validateur.valider("  2 + 3  ");
        Assert.assertEquals("2 + 3", resultat);
    }

    // BUG CORRIGE : test de l'exposant ^ qui manquait dans la regex
    @Test
    public void testExponentiel() {
        String resultat = this.validateur.valider("2 ^ 3");
        Assert.assertEquals("2 ^ 3", resultat);
    }

    @Test
    public void testExpressionNull() {
        try {
            this.validateur.valider(null);
            Assert.fail("Une ExpressionInvalideException aurait dû être levée");
        } catch (ExpressionInvalideException e) {
            Assert.assertEquals("L'expression ne peut pas être vide.", e.getMessage());
        }
    }

    @Test
    public void testExpressionVide() {
        try {
            this.validateur.valider("");
            Assert.fail("Une ExpressionInvalideException aurait dû être levée");
        } catch (ExpressionInvalideException e) {
            Assert.assertEquals("L'expression ne peut pas être vide.", e.getMessage());
        }
    }

    @Test
    public void testExpressionBlanks() {
        try {
            this.validateur.valider("   ");
            Assert.fail("Une ExpressionInvalideException aurait dû être levée");
        } catch (ExpressionInvalideException e) {
            Assert.assertEquals("L'expression ne peut pas être vide.", e.getMessage());
        }
    }

    @Test
    public void testFormatInvalideEspacesManquants() {
        // Les espaces sont désormais optionnels : "1+2" est valide et normalisé en "1 + 2"
        String resultat = this.validateur.valider("1+2");
        Assert.assertEquals("1 + 2", resultat);
    }

    @Test
    public void testFormatInvalideTropComplexe() {
        try {
            this.validateur.valider("1 + 2 + 3");
            Assert.fail("Une ExpressionInvalideException aurait dû être levée");
        } catch (ExpressionInvalideException e) {
            Assert.assertTrue(e.getMessage().contains("Format invalide"));
        }
    }

    @Test
    public void testFormatInvalideCaracteres() {
        try {
            this.validateur.valider("abc + 1");
            Assert.fail("Une ExpressionInvalideException aurait dû être levée");
        } catch (ExpressionInvalideException e) {
            Assert.assertTrue(e.getMessage().contains("Format invalide"));
        }
    }
}

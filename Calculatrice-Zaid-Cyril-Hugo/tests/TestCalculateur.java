import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import exceptions.*;

public class TestCalculateur {

    private Calculateur calculateur;
    private Parseur parseur;

    @Before
    public void setUp() {
        OperateurFactory factory = new OperateurFactory();
        this.parseur = new Parseur(factory);
        this.calculateur = new Calculateur();
    }

    @Test
    public void testCalculerAddition() throws Exception {
        Expression expr = this.parseur.parse("2 + 3");
        Assert.assertEquals(5.0, this.calculateur.calculer(expr), 0.000001);
    }

    @Test
    public void testCalculerSoustraction() throws Exception {
        Expression expr = this.parseur.parse("10 - 4");
        Assert.assertEquals(6.0, this.calculateur.calculer(expr), 0.000001);
    }

    @Test
    public void testCalculerMultiplication() throws Exception {
        Expression expr = this.parseur.parse("4 * 5");
        Assert.assertEquals(20.0, this.calculateur.calculer(expr), 0.000001);
    }

    @Test
    public void testCalculerDivision() throws Exception {
        Expression expr = this.parseur.parse("10 / 2");
        Assert.assertEquals(5.0, this.calculateur.calculer(expr), 0.000001);
    }

    @Test
    public void testCalculerExponentiel() throws Exception {
        Expression expr = this.parseur.parse("2 ^ 3");
        Assert.assertEquals(8.0, this.calculateur.calculer(expr), 0.000001);
    }

    @Test
    public void testCalculerFactorielle() throws Exception {
        Expression expr = this.parseur.parse("5 !");
        Assert.assertEquals(120.0, this.calculateur.calculer(expr), 0.000001);
    }

    @Test
    public void testDivisionParZero() {
        try {
            Expression expr = this.parseur.parse("10 / 0");
            this.calculateur.calculer(expr);
            Assert.fail("Une DivisionParZeroException aurait dû être levée");
        } catch (DivisionParZeroException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e) {
            Assert.fail("Mauvaise exception levée : " + e.getClass().getName());
        }
    }

    @Test
    public void testOperateurInconnu() {
        try {
            Expression expr = this.parseur.parse("2 @ 3");
            this.calculateur.calculer(expr);
            Assert.fail("Une OperateurInconnuException aurait dû être levée");
        } catch (OperateurInconnuException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e) {
            Assert.fail("Mauvaise exception levée : " + e.getClass().getName());
        }
    }

    @Test
    public void testOperandeInvalide() {
        try {
            Expression expr = this.parseur.parse("abc + 3");
            this.calculateur.calculer(expr);
            Assert.fail("Une InvalidOperandException aurait dû être levée");
        } catch (InvalideOperandeException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e) {
            Assert.fail("Mauvaise exception levée : " + e.getClass().getName());
        }
    }

    @Test
    public void testFactorielleNegative() {
        try {
            Expression expr = this.parseur.parse("-3 !");
            this.calculateur.calculer(expr);
            Assert.fail("Une exception aurait dû être levée pour une valeur négative");
        } catch (Exception e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}

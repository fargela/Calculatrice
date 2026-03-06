import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import exceptions.*;

public class TestParseur {

    private Parseur parseur;

    @Before
    public void setUp() {
        this.parseur = new Parseur(new OperateurFactory());
    }

    @Test
    public void testParseAddition() throws Exception {
        Expression expr = this.parseur.parse("2 + 3");
        Assert.assertTrue(expr instanceof ExpressionBinaire);
        Assert.assertEquals(5.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testParseSoustraction() throws Exception {
        Expression expr = this.parseur.parse("10 - 4");
        Assert.assertTrue(expr instanceof ExpressionBinaire);
        Assert.assertEquals(6.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testParseMultiplication() throws Exception {
        Expression expr = this.parseur.parse("4 * 5");
        Assert.assertTrue(expr instanceof ExpressionBinaire);
        Assert.assertEquals(20.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testParseDivision() throws Exception {
        Expression expr = this.parseur.parse("10 / 2");
        Assert.assertTrue(expr instanceof ExpressionBinaire);
        Assert.assertEquals(5.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testParseExponentiel() throws Exception {
        Expression expr = this.parseur.parse("2 ^ 3");
        Assert.assertTrue(expr instanceof ExpressionBinaire);
        Assert.assertEquals(8.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testParseFactorielle() throws Exception {
        Expression expr = this.parseur.parse("5 !");
        Assert.assertTrue(expr instanceof ExpressionUnaire);
        Assert.assertEquals(120.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testOperateurInconnu() {
        try {
            this.parseur.parse("2 @ 3");
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
            this.parseur.parse("abc + 3");
            Assert.fail("Une InvalidOperandException aurait dû être levée");
        } catch (InvalideOperandeException e) {
            Assert.assertNotNull(e.getMessage());
        } catch (Exception e) {
            Assert.fail("Mauvaise exception levée : " + e.getClass().getName());
        }
    }
}

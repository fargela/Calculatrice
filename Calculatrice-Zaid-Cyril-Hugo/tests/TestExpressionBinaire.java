import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import exceptions.*;

public class TestExpressionBinaire {

    private Addition addition;
    private Soustraction soustraction;
    private Multiplication multiplication;
    private Division division;
    private Exponentiel exponentiel;

    @Before
    public void setUp() {
        this.addition = new Addition();
        this.soustraction = new Soustraction();
        this.multiplication = new Multiplication();
        this.division = new Division();
        this.exponentiel = new Exponentiel();
    }

    @Test
    public void testAdditionCorrecte() throws InvalideOperandeException, DivisionParZeroException {
        ExpressionBinaire expr = new ExpressionBinaire(new Operande("2"), new Operande("3"), this.addition);
        Assert.assertEquals(5.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testSoustractionCorrecte() throws InvalideOperandeException, DivisionParZeroException {
        ExpressionBinaire expr = new ExpressionBinaire(new Operande("10"), new Operande("4"), this.soustraction);
        Assert.assertEquals(6.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testSoustractionResultatNegatif() throws InvalideOperandeException, DivisionParZeroException {
        ExpressionBinaire expr = new ExpressionBinaire(new Operande("3"), new Operande("10"), this.soustraction);
        Assert.assertEquals(-7.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testMultiplicationCorrecte() throws InvalideOperandeException, DivisionParZeroException {
        ExpressionBinaire expr = new ExpressionBinaire(new Operande("4"), new Operande("5"), this.multiplication);
        Assert.assertEquals(20.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testDivisionCorrecte() throws InvalideOperandeException, DivisionParZeroException {
        ExpressionBinaire expr = new ExpressionBinaire(new Operande("10"), new Operande("2"), this.division);
        Assert.assertEquals(5.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testDivisionParZero() throws InvalideOperandeException {
        try {
            ExpressionBinaire expr = new ExpressionBinaire(new Operande("10"), new Operande("0"), this.division);
            expr.calculer();
            Assert.fail("Une DivisionParZeroException aurait dû être levée");
        } catch (DivisionParZeroException e) {
            Assert.assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testExponentielCorrecte() throws InvalideOperandeException, DivisionParZeroException {
        ExpressionBinaire expr = new ExpressionBinaire(new Operande("2"), new Operande("3"), this.exponentiel);
        Assert.assertEquals(8.0, expr.calculer(), 0.000001);
    }
}

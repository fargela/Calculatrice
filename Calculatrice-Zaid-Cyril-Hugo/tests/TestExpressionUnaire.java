import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import exceptions.*;

public class TestExpressionUnaire {

    private Factorielle factorielle;

    @Before
    public void setUp() {
        this.factorielle = new Factorielle();
    }

    @Test
    public void testFactorielleCorrecte() throws InvalideOperandeException {
        ExpressionUnaire expr = new ExpressionUnaire(new Operande("5"), this.factorielle);
        Assert.assertEquals(120.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testFactorielleZero() throws InvalideOperandeException {
        ExpressionUnaire expr = new ExpressionUnaire(new Operande("0"), this.factorielle);
        Assert.assertEquals(1.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testFactorielleUn() throws InvalideOperandeException {
        ExpressionUnaire expr = new ExpressionUnaire(new Operande("1"), this.factorielle);
        Assert.assertEquals(1.0, expr.calculer(), 0.000001);
    }

    @Test
    public void testFactorielleNombreNegatif() throws InvalideOperandeException {
        try {
            ExpressionUnaire expr = new ExpressionUnaire(new Operande("-3"), this.factorielle);
            expr.calculer();
            Assert.fail("Une exception aurait dû être levée pour une valeur négative");
        } catch (Exception e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}

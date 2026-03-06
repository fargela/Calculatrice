import org.junit.Test;
import org.junit.Assert;
import exceptions.InvalideOperandeException;

public class TestOperande {

    @Test
    public void testOperandeValide() throws InvalideOperandeException {
        Operande op = new Operande("5");
        Assert.assertEquals(5.0, op.getValeur(), 0.000001);
    }

    @Test
    public void testOperandeDecimale() throws InvalideOperandeException {
        Operande op = new Operande("3.14");
        Assert.assertEquals(3.14, op.getValeur(), 0.000001);
    }

    @Test
    public void testOperandeNegatif() throws InvalideOperandeException {
        Operande op = new Operande("-7");
        Assert.assertEquals(-7.0, op.getValeur(), 0.000001);
    }

    @Test
    public void testOperandeAvecEspaces() throws InvalideOperandeException {
        Operande op = new Operande("  42  ");
        Assert.assertEquals(42.0, op.getValeur(), 0.000001);
    }

    @Test
    public void testToString() throws InvalideOperandeException {
        Operande op = new Operande("5");
        Assert.assertEquals("5.0", op.toString());
    }

    @Test
    public void testOperandeInvalide() {
        try {
            new Operande("abc");
            Assert.fail("Une InvalidOperandException aurait dû être levée");
        } catch (InvalideOperandeException e) {
            Assert.assertNotNull(e.getMessage());
        }
    }

    @Test
    public void testOperandeVide() {
        try {
            new Operande("");
            Assert.fail("Une InvalidOperandException aurait dû être levée");
        } catch (InvalideOperandeException e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}

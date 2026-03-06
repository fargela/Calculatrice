import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import exceptions.*;

public class TestOperateurFactory {

    private OperateurFactory factory;

    @Before
    public void setUp() {
        this.factory = new OperateurFactory();
    }

    @Test
    public void testCreerAddition() throws OperateurInconnuException {
        Assert.assertTrue(this.factory.creerOperateur("+") instanceof Addition);
    }

    @Test
    public void testCreerSoustraction() throws OperateurInconnuException {
        Assert.assertTrue(this.factory.creerOperateur("-") instanceof Soustraction);
    }

    @Test
    public void testCreerMultiplication() throws OperateurInconnuException {
        Assert.assertTrue(this.factory.creerOperateur("*") instanceof Multiplication);
    }

    @Test
    public void testCreerDivision() throws OperateurInconnuException {
        Assert.assertTrue(this.factory.creerOperateur("/") instanceof Division);
    }

    @Test
    public void testCreerExponentiel() throws OperateurInconnuException {
        Assert.assertTrue(this.factory.creerOperateur("^") instanceof Exponentiel);
    }

    @Test
    public void testCreerFactorielle() throws OperateurInconnuException {
        Assert.assertTrue(this.factory.creerOperateur("!") instanceof Factorielle);
    }

    @Test
    public void testOperateurInconnu() {
        try {
            this.factory.creerOperateur("@");
            Assert.fail("Une OperateurInconnuException aurait dû être levée");
        } catch (OperateurInconnuException e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}

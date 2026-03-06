import exceptions.DivisionParZeroException;
import org.junit.*;

/**
 * Classe de test pour la classe Division.
 */
public class TestDivision {

    /**
     * Attribut de test pour la division.
     */
    private Division division;

    /**
     * Initialisation avant chaque test.
     */
    @Before
    public void setUp() {
        this.division = new Division();
    }

    /**
     * Test de la division entière exacte.
     */
    @Test
    public void testDivisionExacte() throws DivisionParZeroException {
        double result = this.division.calculer(10, 2);
        Assert.assertEquals(5.0, result, 0.0);
    }

    /**
     * Test de la division avec résultat décimal.
     */
    @Test
    public void testDivisionDecimale() throws DivisionParZeroException {
        double result = this.division.calculer(5, 2);
        Assert.assertEquals(2.5, result, 0.0);
    }

    /**
     * Test de la division par zéro.
     */
    @Test
    public void testDivisionParZero() throws DivisionParZeroException {
        try {
            this.division.calculer(10, 0);
            Assert.fail("Expected DivisionParZeroException for division by zero");
        } catch (DivisionParZeroException e) {
            Assert.assertNotNull(e.getMessage());
        }
    }
}
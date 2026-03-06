import org.junit.*;

/**
 * Classe de test pour la classe Factorielle.
 */
public class TestFactorielle {

    /**
     * Attribut de test pour la factorielle.
     */
    private Factorielle factorielle;

    /**
     * Initialisation avant chaque test.
     */
    @Before
    public void setUp() {
        this.factorielle = new Factorielle();
    }

    /**
     * Test de factorielle de 5 = 120.
     */
    @Test
    public void testFactorielleCinq() {
        double result = this.factorielle.calculer(5);
        Assert.assertEquals(120.0, result, 0.0);
    }
}


import org.junit.*;

/**
 * Classe de test pour la classe Exponentiel.
 */
public class TestExponentiel {

    /**
     * Attribut de test pour l'exponentiel.
     */
    private Exponentiel exponentiel;

    /**
     * Initialisation avant chaque test.
     */
    @Before
    public void setUp() {
        this.exponentiel = new Exponentiel();
    }

    /**
     * Test de 2^3 = 8.
     */
    @Test
    public void testExposantEntier() {
        double result = this.exponentiel.calculer(2, 3);
        Assert.assertEquals(8.0, result, 0.0);
    }

    /**
     * Test d'un nombre à la puissance 0.
     */
    @Test
    public void testExposantZero() {
        double result = this.exponentiel.calculer(5, 0);
        Assert.assertEquals(1.0, result, 0.0);
    }

    /**
     * Test d'un nombre à la puissance 1.
     */
    @Test
    public void testExposantUn() {
        double result = this.exponentiel.calculer(7, 1);
        Assert.assertEquals(7.0, result, 0.0);
    }
}

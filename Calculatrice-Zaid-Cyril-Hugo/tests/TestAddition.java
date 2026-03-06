import org.junit.*;

/**
 * Classe de test pour la classe Addition.
 */
public class TestAddition {

    /**
     * Attribut de test pour l'addition.
     */
    private Addition addition;

    /**
     * Initialisation avant chaque test.
     */
    @Before
    public void setUp() {
        this.addition = new Addition();
    }

    /**
     * Test de l'addition de deux entiers positifs.
     */
    @Test
    public void testAdditionPositifs() {
        double result = this.addition.calculer(2, 4);
        Assert.assertEquals(6.0, result, 0.0);
    }
}
import org.junit.*;

/**
 * Classe de test pour la classe Soustraction.
 */
public class TestSoustraction {

    /**
     * Attribut de test pour la soustraction.
     */
    private Soustraction soustraction;

    /**
     * Initialisation avant chaque test.
     */
    @Before
    public void setUp() {
        this.soustraction = new Soustraction();
    }

    /**
     * Test de la soustraction simple.
     */
    @Test
    public void testSoustractionSimple() {
        double result = this.soustraction.calculer(4, 2);
        Assert.assertEquals(2.0, result, 0.0);
    }

    /**
     * Test de la soustraction donnant un résultat négatif.
     */
    @Test
    public void testSoustractionResultatNegatif() {
        double result;
        result = this.soustraction.calculer(3, 4);
        Assert.assertEquals(-1.0, result, 0.0);
    }
}
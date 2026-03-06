import org.junit.*;

/**
 * Classe de test pour la classe Multiplication.
 */
public class TestMultiplication {

    /**
     * Attribut de test pour la multiplication.
     */
    private Multiplication multiplication;

    /**
     * Initialisation avant chaque test.
     */
    @Before
    public void setUp() {
        this.multiplication = new Multiplication();
    }

    /**
     * Test de la multiplication de deux entiers positifs.
     */
    @Test
    public void testMultiplicationPositifs() {
        double result = this.multiplication.calculer(4, 2);
        Assert.assertEquals(8.0, result, 0.0);
    }

    /**
     * Test de la multiplication par zéro.
     */
    @Test
    public void testMultiplicationParZero() {
        double result = this.multiplication.calculer(5, 0);
        Assert.assertEquals(0.0, result, 0.0);

        result = this.multiplication.calculer(0, 5);
        Assert.assertEquals(0.0, result, 0.0);
    }

    /**
     * Test de la multiplication par un (élément neutre).
     */
    @Test
    public void testMultiplicationParUn() {
        double result = this.multiplication.calculer(9, 1);
        Assert.assertEquals(9.0, result, 0.0);
    }

    /**
     * Test de la multiplication avec des négatifs.
     */
    @Test
    public void testMultiplicationAvecNegatifs() {
        double result = this.multiplication.calculer(-2, -3);
        Assert.assertEquals(6.0, result, 0.0);

        result = this.multiplication.calculer(3, -4);
        Assert.assertEquals(-12.0, result, 0.0);
    }
}
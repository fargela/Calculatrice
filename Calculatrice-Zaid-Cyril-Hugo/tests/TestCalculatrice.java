import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import exceptions.*;

public class TestCalculatrice {

    private Calculatrice calculatrice;

    @Before
    public void setUp() {
        Validateur validateur = new Validateur();
        OperateurFactory factory = new OperateurFactory();
        Parseur parseur = new Parseur(factory);
        Calculateur calculateur = new Calculateur();
        calculatrice = new Calculatrice(validateur, parseur, calculateur);
    }

    // BUG CORRIGE : throws aligné sur la nouvelle signature (DivisionParZeroException seulement)
    @Test(expected = ExpressionInvalideException.class)
    public void testOperateurInconnuPasseParValidateur() throws DivisionParZeroException {
        calculatrice.calculer("2 # 3");
    }

    @Test
    public void testSansEspaces() throws DivisionParZeroException {
        // Les espaces sont désormais optionnels : "2+3" est accepté et vaut 5
        double res = calculatrice.calculer("2+3");
        Assert.assertEquals(5.0, res, 0.0001);
    }

    @Test(expected = DivisionParZeroException.class)
    public void testDivisionParZero() throws DivisionParZeroException {
        calculatrice.calculer("10 / 0");
    }

    @Test
    public void testExpressionValide() throws Exception {
        double res = calculatrice.calculer("2 + 3");
        Assert.assertEquals(5.0, res, 0.0001);
    }

    // BUG CORRIGE : test de l'exposant ^ qui était rejeté par le validateur
    @Test
    public void testExponentiel() throws Exception {
        double res = calculatrice.calculer("2 ^ 3");
        Assert.assertEquals(8.0, res, 0.0001);
    }

    // Test de la factorielle bout en bout
    @Test
    public void testFactorielle() throws Exception {
        double res = calculatrice.calculer("5!");
        Assert.assertEquals(120.0, res, 0.0001);
    }
}

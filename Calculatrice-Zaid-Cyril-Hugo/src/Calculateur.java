import exceptions.DivisionParZeroException;

public class Calculateur {

    public double calculer(Expression expression) throws DivisionParZeroException {
        return expression.calculer();
    }

    @Override
    public String toString() {
        return "Calculateur{}";
    }
}

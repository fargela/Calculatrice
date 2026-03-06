import exceptions.DivisionParZeroException;

public abstract class Expression {

    protected final Operateur operateur;

    public Expression(Operateur operateur) {
        this.operateur = operateur;
    }

    public abstract double calculer() throws DivisionParZeroException;

    public Operateur getOperateur() {
        return operateur;
    }

    @Override
    public String toString() {
        return "Expression[" + operateur + "]";
    }
}
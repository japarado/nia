package rootcomputer.expression;

public class Polynomial extends Expression
{
    public Polynomial(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public Double computeFunction(Double value)
    {
        return this.adjustPrecision(value - Math.pow(value, 2));
    }

    @Override
    public Double computePrime(Double value)
    {
        return this.adjustPrecision((value - Math.pow(value, 2)) / (1 - 2 * value));
    }
}

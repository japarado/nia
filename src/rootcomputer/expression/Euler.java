package rootcomputer.expression;

public class Euler extends Expression
{
    public Euler(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public Double computeFunction(Double value)
    {
        return this.adjustPrecision(Math.pow(Math.E, value) - 3 * value);
    }

    @Override
    public Double computePrime(Double value)
    {
        return this.adjustPrecision((Math.pow(Math.E, value) - 3 * value) / Math.pow(Math.E, value) - 3);
    }
}

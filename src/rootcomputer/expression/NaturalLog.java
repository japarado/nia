package rootcomputer.expression;

public class NaturalLog extends Expression
{
    public NaturalLog(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public Double computeFunction(Double value)
    {
        return this.adjustPrecision(Math.log(value + 1) + 1);
    }

    @Override
    public Double computePrime(Double value)
    {
        return this.adjustPrecision((Math.log(value + 1) + 1) / (1 / (value + 1)));
    }
}

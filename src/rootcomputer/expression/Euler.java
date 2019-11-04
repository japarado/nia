package rootcomputer.expression;

import java.math.BigDecimal;

public class Euler extends Expression
{
    public Euler(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public BigDecimal computeFunction(BigDecimal value)
    {
        return null;
    }

    @Override
    public BigDecimal computePrime(BigDecimal value)
    {
        return null;
    }
}

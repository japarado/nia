package rootcomputer.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Euler extends Expression
{
    public Euler(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public BigDecimal computeFunction(BigDecimal value)
    {
        return new BigDecimal(Math.pow(Math.E, value.doubleValue())).subtract(value.multiply(new BigDecimal(3))).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal computePrime(BigDecimal value)
    {
        BigDecimal numerator = new BigDecimal(Math.pow(Math.E, value.doubleValue())).subtract(value.multiply(new BigDecimal(3))).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);
        BigDecimal denominator = new BigDecimal( Math.pow(Math.E, value.doubleValue()) ).subtract(new BigDecimal(3)).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);

        return value.subtract(numerator.divide(denominator, RoundingMode.HALF_UP));
    }
}

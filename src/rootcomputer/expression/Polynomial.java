package rootcomputer.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Polynomial extends Expression
{
    public Polynomial(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public BigDecimal computeFunction(BigDecimal value)
    {
        return value.subtract(value.pow(2)).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);
//        return value.subtract(value.pow(2));
    }

    @Override
    public BigDecimal computePrime(BigDecimal value) throws ArithmeticException
    {
        BigDecimal numerator = value.subtract(value.pow(2)).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);
        BigDecimal denominator = new BigDecimal(1).subtract(value.multiply(new BigDecimal(2))).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);

//        BigDecimal numerator = value.subtract(value.pow(2));
//        BigDecimal denominator = new BigDecimal(1);

        return numerator.divide(denominator, RoundingMode.HALF_UP);
//        return this.adjustPrecision((value - Math.pow(value, 2)) / (1 - 2 * value));
    }
}

package rootcomputer.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NaturalLog extends Expression
{
    public static void main(String[] args)
    {
    }
    public NaturalLog(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public BigDecimal computeFunction(BigDecimal value)
    {
        return new BigDecimal( Math.log( value.add(new BigDecimal(1)).doubleValue() ) ).add(new BigDecimal(1)).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal computePrime(BigDecimal value)
    {
        BigDecimal numerator = new BigDecimal( Math.log( value.doubleValue() + 1 ) ).add(new BigDecimal(1));
        BigDecimal denominator = new BigDecimal(1).divide((value.add(new BigDecimal(1))), this.getDecimalPrecision(), RoundingMode.HALF_UP);

        return value.subtract(numerator.divide(denominator, RoundingMode.HALF_UP));
    }
}

package rootcomputer.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class NaturalLog extends Expression
{
    public static void main(String[] args)
    {
        BigDecimal valueOne = new BigDecimal("12.0001");
        BigDecimal valueTwo = new BigDecimal("12.129");
        BigDecimal rounded = valueTwo.setScale(3, RoundingMode.HALF_UP);
        rounded = valueTwo.add(valueOne).setScale(3, RoundingMode.HALF_UP);
        System.out.println(rounded);
    }
    public NaturalLog(int decimalPrecision)
    {
        super(decimalPrecision);
    }

    @Override
    public BigDecimal computeFunction(BigDecimal value)
    {
        return new BigDecimal( Math.log( value.doubleValue() + 1 ) ).add(new BigDecimal(1)).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);
    }

    @Override
    public BigDecimal computePrime(BigDecimal value)
    {
        BigDecimal numerator = new BigDecimal( Math.log( value.doubleValue() + 1 ) ).add(new BigDecimal(1)).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);
        BigDecimal denominator = new BigDecimal(1).divide((value.add(new BigDecimal(1))), RoundingMode.HALF_UP).setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP);

        return numerator.divide(denominator, RoundingMode.HALF_UP);
    }
}

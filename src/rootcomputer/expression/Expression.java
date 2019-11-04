package rootcomputer.expression;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Expression
{
    public Expression(int decimalPrecision)
    {
        this.decimalPrecision = decimalPrecision;
    }

    private int decimalPrecision;

    public int getDecimalPrecision()
    {
        return decimalPrecision;
    }

    public void setDecimalPrecision(int decimalPrecision)
    {
        this.decimalPrecision = decimalPrecision;
    }

    protected Double adjustPrecision(Double value)
    {
        double result;
        try
        {
            result = BigDecimal.valueOf(value)
                .setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP)
                .doubleValue();
        }
        catch (Exception e)
        {
            result = value;
        }
        return result;
    }

    public abstract BigDecimal computeFunction(BigDecimal value);

    public abstract BigDecimal computePrime(BigDecimal value);
}

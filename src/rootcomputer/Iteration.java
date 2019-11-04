package rootcomputer;

import java.math.BigDecimal;

public class Iteration
{
    public Iteration(int iteration, BigDecimal primeResult, BigDecimal functionResult)
    {
        this.iteration = iteration;
        this.primeResult = primeResult;
        this.functionResult = functionResult;
    }

    public Iteration()
    {

    }

    private int iteration;
    private BigDecimal primeResult;
    private BigDecimal functionResult;

    public int getIteration()
    {
        return iteration;
    }

    public void setIteration(int iteration)
    {
        this.iteration = iteration;
    }

    public BigDecimal getPrimeResult()
    {
        return primeResult;
    }

    public void setPrimeResult(BigDecimal primeResult)
    {
        this.primeResult = primeResult;
    }

    public BigDecimal getFunctionResult()
    {
        return functionResult;
    }

    public void setFunctionResult(BigDecimal functionResult)
    {
        this.functionResult = functionResult;
    }
}

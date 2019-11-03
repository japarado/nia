package rootcomputer;

public class Iteration
{
    public Iteration(int iteration, double primeResult, double functionResult)
    {
        this.iteration = iteration;
        this.primeResult = primeResult;
        this.functionResult = functionResult;
    }

    public Iteration(int iteration)
    {
        this.iteration = iteration;
    }

    public Iteration(int iteration, double functionResult)
    {
        this.iteration = iteration;
        this.functionResult = functionResult;
    }

    public Iteration()
    {

    }

    private int iteration;
    private double primeResult;
    private double functionResult;

    public int getIteration()
    {
        return iteration;
    }

    public void setIteration(int iteration)
    {
        this.iteration = iteration;
    }

    public double getPrimeResult()
    {
        return primeResult;
    }

    public void setPrimeResult(double primeResult)
    {
        this.primeResult = primeResult;
    }

    public double getFunctionResult()
    {
        return functionResult;
    }

    public void setFunctionResult(double functionResult)
    {
        this.functionResult = functionResult;
    }
}

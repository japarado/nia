package rootcomputer;

import rootcomputer.expression.Euler;
import rootcomputer.expression.NaturalLog;
import rootcomputer.expression.Polynomial;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Computer
{
    public Computer(int decimalPrecision, Double initialX)
    {
        this.decimalPrecision = decimalPrecision;
        this.initialX = this.adjustPrecision(initialX);
    }

    private int decimalPrecision;
    private Double initialX;

    /*Getters and setters*/
    public int getDecimalPrecision()
    {
        return decimalPrecision;
    }

    public void setDecimalPrecision(int decimalPrecision)
    {
        this.decimalPrecision = decimalPrecision;
    }

    public Double getInitialX()
    {
        return initialX;
    }

    public void setInitialX(Double initialX)
    {
        this.initialX = adjustPrecision(initialX);
    }
    /*End getters and setters*/

    public LinkedList<Iteration> computePolynomial()
    {
        LinkedList<Iteration> iterations = new LinkedList<>();
        Polynomial polynomial = new Polynomial(this.getDecimalPrecision());

        // Create the first iteration
        iterations.add(new Iteration(0, this.getInitialX(), polynomial.computeFunction(this.getInitialX())));

        System.out.println(iterations.getLast().getFunctionResult());

        while (iterations.getLast().getFunctionResult() != 0)
        {
            Iteration iteration = new Iteration();
            iteration.setIteration(iterations.getLast().getIteration() + 1);

            // Compute the next x value through the Newton Raphson expression
            Double primeResult = polynomial.computePrime(this.getInitialX());
            this.setInitialX(primeResult);
            Double functionResult = polynomial.computeFunction(this.getInitialX());

            iteration.setPrimeResult(primeResult);
            iteration.setFunctionResult(functionResult);

            if (iterations.getLast().getFunctionResult() == iteration.getFunctionResult())
            {
                iterations.add(iteration);
                break;
            }
            else
            {
                iterations.add(iteration);
            }
        }

        return iterations;
    }

    public LinkedList<Iteration> computeNaturalLog()
    {
        LinkedList<Iteration> iterations = new LinkedList<>();
        NaturalLog naturalLog = new NaturalLog(this.getDecimalPrecision());

        // Create the first iteration
        iterations.add(new Iteration(0, this.getInitialX(), naturalLog.computeFunction(this.getInitialX())));

        System.out.println(iterations.getLast().getFunctionResult());

        while (iterations.getLast().getFunctionResult() != 0)
        {
            Iteration iteration = new Iteration();
            iteration.setIteration(iterations.getLast().getIteration() + 1);

            // Compute the next x value through the Newton Raphson expression
            Double primeResult = naturalLog.computePrime(this.getInitialX());
            this.setInitialX(primeResult);
            Double functionResult = naturalLog.computeFunction(this.getInitialX());

            iteration.setPrimeResult(primeResult);
            iteration.setFunctionResult(functionResult);

            if (iterations.getLast().getFunctionResult() == iteration.getFunctionResult())
            {
                iterations.add(iteration);
                break;
            }
            else
            {
                iterations.add(iteration);
            }
        }
        return iterations;
    }

    public LinkedList<Iteration> computeEuler()
    {
        LinkedList<Iteration> iterations = new LinkedList<>();
        Euler euler = new Euler(this.getDecimalPrecision());

        // Create the first iteration
        iterations.add(new Iteration(0, this.getInitialX(), euler.computeFunction(this.getInitialX())));

        System.out.println(iterations.getLast().getFunctionResult());

        while (iterations.getLast().getFunctionResult() != 0)
        {
            Iteration iteration = new Iteration();
            iteration.setIteration(iterations.getLast().getIteration() + 1);

            // Compute the next x value through the Newton Raphson expression
            Double primeResult = euler.computePrime(this.getInitialX());
            this.setInitialX(primeResult);
            Double functionResult = euler.computeFunction(this.getInitialX());

            iteration.setPrimeResult(primeResult);
            iteration.setFunctionResult(functionResult);

            if (iterations.getLast().getFunctionResult() == iteration.getFunctionResult())
            {
                iterations.add(iteration);
                break;
            }
            else
            {
                iterations.add(iteration);
            }
        }

        return iterations;
    }


    // Helper functions

    /*
     * Formats the double value correctly
     *
     * @param Double value
     * @return Double
     */
    private Double adjustPrecision(Double value)
    {
        Double result;
        try
        {
            result = BigDecimal.valueOf(value)
                .setScale(this.getDecimalPrecision(), RoundingMode.HALF_UP)
                .doubleValue();
        }
        catch (NumberFormatException e)
        {
            System.out.println(e.getMessage());
            result = value;
        }

        return result;
    }
}

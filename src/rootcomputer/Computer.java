package rootcomputer;

import rootcomputer.expression.Euler;
import rootcomputer.expression.NaturalLog;
import rootcomputer.expression.Polynomial;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;

public class Computer
{
    public Computer(int decimalPrecision, BigDecimal initialX)
    {
        this.decimalPrecision = decimalPrecision;
        this.initialX = initialX;
    }

    private int decimalPrecision;
    private BigDecimal initialX;

    public int getDecimalPrecision()
    {
        return decimalPrecision;
    }

    public void setDecimalPrecision(int decimalPrecision)
    {
        this.decimalPrecision = decimalPrecision;
    }

    public BigDecimal getInitialX()
    {
        return initialX;
    }

    public void setInitialX(BigDecimal initialX)
    {
        this.initialX = initialX;
    }

    public LinkedList<Iteration> computePolynomial()
    {
        LinkedList<Iteration> iterations = new LinkedList<>();
        Polynomial polynomial = new Polynomial(this.getDecimalPrecision());

        // Create the first iteration
        try
        {
            iterations.add(new Iteration(0, this.getInitialX(), polynomial.computeFunction(this.getInitialX())));
        } catch (Exception e)
        {
            return iterations;
        }

        while (!iterations.getLast().getFunctionResult().equals(new BigDecimal(0)) && iterations.getLast().getIteration() < 500)
//        while (iterations.getLast().getIteration() < 500)
        {
            Iteration iteration = new Iteration();
            iteration.setIteration(iterations.getLast().getIteration() + 1);

            // Compute the next x value through Newton Raphson
            try
            {
                BigDecimal primeResult = polynomial.computePrime(this.getInitialX());
                this.setInitialX(primeResult);
                BigDecimal functionResult = polynomial.computeFunction(this.getInitialX());

                iteration.setPrimeResult(primeResult);
                iteration.setFunctionResult(functionResult);

                if (iterations.getLast().getFunctionResult().equals(iteration.getFunctionResult()))
                {
                    iterations.add(iteration);
                    break;
                }
                else
                {
                    iterations.add(iteration);
                }
            } catch (ArithmeticException e)
            {
                System.out.println(e.getMessage());
                break;
            }
        }

        return iterations;
    }

    public LinkedList<Iteration> computeNaturalLog()
    {
        LinkedList<Iteration> iterations = new LinkedList<>();
        NaturalLog naturalLog = new NaturalLog(this.getDecimalPrecision());

        // Create the first iteration
        try
        {
            iterations.add(new Iteration(0, this.getInitialX(), naturalLog.computeFunction(this.getInitialX())));
        } catch (Exception e)
        {
            return iterations;
        }

        while (!iterations.getLast().getFunctionResult().equals(new BigDecimal(0)) && iterations.getLast().getIteration() < 500)
        {
            Iteration iteration = new Iteration();
            iteration.setIteration(iterations.getLast().getIteration() + 1);

            // Compute the next x value through Newton Raphson
            try
            {
                BigDecimal primeResult = naturalLog.computePrime(this.getInitialX());
                this.setInitialX(primeResult);
                BigDecimal functionResult = naturalLog.computeFunction(this.getInitialX());

                iteration.setPrimeResult(primeResult);
                iteration.setFunctionResult(functionResult);

                if (iterations.getLast().getFunctionResult().equals(iteration.getFunctionResult()))
                {
                    iterations.add(iteration);
                    break;
                }
                else
                {
                    iterations.add(iteration);
                }
            } catch (ArithmeticException e)
            {
                System.out.println("ERROR");
                System.out.println(e.getMessage());
                break;
            }
        }

        return iterations;
    }

    public LinkedList<Iteration> computeEuler()
    {
        LinkedList<Iteration> iterations = new LinkedList<>();
        Euler euler = new Euler(this.getDecimalPrecision());

        // Create the first iteration
        try
        {
            iterations.add(new Iteration(0, this.getInitialX(), euler.computeFunction(this.getInitialX())));
        } catch (Exception e)
        {
            return iterations;
        }

        while (!iterations.getLast().getFunctionResult().equals(new BigDecimal(0)) && iterations.getLast().getIteration() < 500)
        {
            Iteration iteration = new Iteration();
            iteration.setIteration(iterations.getLast().getIteration() + 1);

            // Compute the next x value through Newton Raphson
            try
            {
                BigDecimal primeResult = euler.computePrime(this.getInitialX());
                this.setInitialX(primeResult);
                BigDecimal functionResult = euler.computeFunction(this.getInitialX());

                iteration.setPrimeResult(primeResult);
                iteration.setFunctionResult(functionResult);

                if (iterations.getLast().getFunctionResult().equals(iteration.getFunctionResult()))
                {
                    iterations.add(iteration);
                    break;
                }
                else
                {
                    iterations.add(iteration);
                }
            } catch (ArithmeticException e)
            {
                System.out.println("ERROR");
                System.out.println(e.getMessage());
                break;
            }
        }

        return iterations;
    }
}

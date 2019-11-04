package rootcomputer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

public class Controller
{
    // Buttons for selecting the expression
    @FXML
    ToggleButton expressionOneBtn, expressionTwoBtn, expressionThreeBtn;

    // Button to compute the roots
    @FXML
    Button computeRootsBtn;

    // Text fields for initial x value input and decimal place count
    @FXML
    TextField initialXValueTxtField, decimalPlacesTxtField;

    @FXML
    TableView tableView;

    @FXML
    TableColumn iterationCountTableColumn,
        iterationTablePrimeColumn,
        iterationTableFunctionResultColumn;

    @FXML
    LineChart<Double, Double> chart;

    @FXML
    NumberAxis yAxis, xAxis;

    @FXML
    void computeRootsBtnHandler(ActionEvent event)
    {
        initializeTableColumns();

        // Initialize the data structure that will hold the table rows
        List<Iteration> iterations;

        deleteTableItems();
        deleteChartData();


        // Get the required precision
        int decimalPrecision = Integer.parseInt(decimalPlacesTxtField.getText());

        // Get the input value from the initial x value field
        BigDecimal initialXValue = new BigDecimal(initialXValueTxtField.getText()).setScale(decimalPrecision, RoundingMode.HALF_UP);

        // Create new computer instance
        Computer computer = new Computer(decimalPrecision, initialXValue);

        Expressions expression = getButtonExpressionType();

        switch (expression)
        {
            case POLYNOMIAL:
                iterations = computer.computePolynomial();
                break;
            case NATURALLOG:
                iterations = computer.computeNaturalLog();
                break;
            case EULER:
                iterations = computer.computeEuler();
                break;
            default:
                iterations = computer.computePolynomial();
        }

        ObservableList<Iteration> tableData =
            FXCollections.observableArrayList(new ArrayList<>(iterations));
        tableView.getItems().addAll(tableData);

//        System.out.println("Expression type " + expression);
//        System.out.println("Initial x value: " + initialXValue);
//        System.out.println("Precision digits " + decimalPrecision);
//        System.out.println("Adjsuted x value: " + BigDecimal.valueOf(initialXValue));

        drawChart(new LinkedList<>(iterations));

        for (Iteration iteration : iterations)
        {
            System.out.println("----------");
            System.out.println("Iteration: " + iteration.getIteration());
            System.out.println("Prime Result: " + iteration.getPrimeResult());
            System.out.println("Function Result: " + iteration.getFunctionResult());
            System.out.println("----------");
        }
    }

    @FXML
    public void clearBtnHandler(ActionEvent event)
    {
        event.consume();
        deleteTableItems();
        deleteChartData();
    }

    private void drawChart(LinkedList<Iteration> iterations)
    {
        XYChart.Series<Double, Double> series = new XYChart.Series<>();

        series.setName("Plot");
        for (Iteration iteration : iterations)
        {
            BigDecimal x = iteration.getPrimeResult();
            BigDecimal y = iteration.getFunctionResult();
            series.getData().add(new XYChart.Data<Double, Double>(x.doubleValue(), y.doubleValue()));
        }
        chart.getData().add(series);
    }

    /**
     * Initializes the columns used in the table view
     */
    private void initializeTableColumns()
    {
        iterationCountTableColumn.setCellValueFactory(new PropertyValueFactory<>("iteration"));
        iterationTablePrimeColumn.setCellValueFactory(new PropertyValueFactory<>("primeResult"));
        iterationTableFunctionResultColumn.setCellValueFactory(
            new PropertyValueFactory<>("functionResult"));
    }

    /*
     * Returns the expression type of the pressed button via the Expression enum
     *
     * @param ToggleButton toggleButton
     * @return Expressions
     */
    private Expressions getButtonExpressionType() throws Error
    {
        Expressions expression;
        if (expressionOneBtn.isSelected())
        {
            deleteTableItems();
            expression = Expressions.POLYNOMIAL;
        }
        else if (expressionTwoBtn.isSelected())
        {
            deleteTableItems();
            expression = Expressions.NATURALLOG;
        }
        else if (expressionThreeBtn.isSelected())
        {
            deleteTableItems();
            expression = Expressions.EULER;
        }
        else
        {
            throw new Error("Expression type not recognized");
        }

        return expression;
    }

    private void deleteTableItems()
    {
        tableView.getItems().clear();
    }

    private void deleteChartData()
    {
        chart.getData().clear();
    }

    private DecimalFormat createDecimalFormat()
    {
        String formatString = "#";

        if (decimalPlacesTxtField.getText().isEmpty())
        {
            formatString = "#.##";
            decimalPlacesTxtField.setText("2");
        }
        else
        {
            for (int ctr = 0; ctr < Integer.parseInt(decimalPlacesTxtField.getText()); ctr++)
            {
                if (ctr == 0)
                {
                    formatString = formatString.concat(".#");
                }
                else
                {
                    formatString = formatString.concat("#");
                }
            }
        }

        return new DecimalFormat(formatString);
    }
}

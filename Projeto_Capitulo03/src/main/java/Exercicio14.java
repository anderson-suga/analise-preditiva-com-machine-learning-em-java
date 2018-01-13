import com.github.lwhite1.tablesaw.api.NumericColumn;
import com.github.lwhite1.tablesaw.api.Table;
import com.github.lwhite1.tablesaw.api.plot.Histogram;
import com.github.lwhite1.tablesaw.api.plot.Pareto;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;

import java.io.IOException;

import static com.github.lwhite1.tablesaw.api.QueryHelper.column;
import static com.github.lwhite1.tablesaw.reducing.NumericReduceUtils.sum;

/**
 * Created by suemareverton on 16/08/17.
 * Gráficos com XChart
 */
public class Exercicio14 {

    public static void main(String[] args) {

        try {
            Table tornado = Table.createFromCsv("src/main/java/files/tornadoes_1950-2014.csv");

            Table table = tornado
                    .selectWhere(column("Fatalities").isGreaterThan(10));

            /*XYChart chart =
                    new XYChartBuilder().width(600).height(500)
                            .title("ScatterPlot")
                            .xAxisTitle("Feridos")
                            .yAxisTitle("Mortos")
                            .build();

            chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);

            chart.addSeries(
                    "Série 1",
                    table.column("Injuries").toDoubleArray(),
                    table.column("Fatalities").toDoubleArray()
            );

            new SwingWrapper(chart).displayChart();*/

            //////////////////

            /*Table funcionarios = Table.createFromCsv("src/main/java/files/funcionarios.csv");
            NumericColumn salarios = funcionarios.nCol("salario");
            Histogram.show("Distribuição de salário", salarios);*/

            try {
                Pareto.show("Fatalidades por Estado",
                        table.summarize("fatalities", sum).by("State"));
            } catch (Exception e) {
                e.printStackTrace();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

import java.io.IOException;

/**
 * Created by suemareverton on 16/08/17.
 * Gráficos com XChart: https://github.com/timmolter/XChart
 */
public class Exercicio13 {

    public static void main(String[] args) {

        double[] xData = new double[] { 0.0, 1.0, 2.0 };
        double[] yData = new double[] { 2.0, 1.0, 0.0 };

        // Criando gráfico
        XYChart chart = QuickChart.getChart(
                "Sample Chart",
                "X", "Y",
                "y(x)",
                xData,
                yData
        );

        // Exibindo gráfico
        new SwingWrapper(chart).displayChart();

        // Salvando em alta resolução
        try {
            BitmapEncoder.saveBitmapWithDPI(
                    chart, "src/main/java/files/grafico1.png",
                    BitmapEncoder.BitmapFormat.PNG,
                    300
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

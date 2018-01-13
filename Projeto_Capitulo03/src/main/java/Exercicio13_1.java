import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

/**
 * Created by suemareverton on 16/08/17.
 * Gráficos com XChart: https://github.com/timmolter/XChart
 */
public class Exercicio13_1 {

    public static void main(String[] args) {

        // Create Chart
        XYChart chart =
                new XYChartBuilder().width(600).height(500)
                        .title("XYChart")
                        .xAxisTitle("X")
                        .yAxisTitle("Y")
                        .build();

        // Customize Chart
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(16);

        // Series
        chart.addSeries("Série 1", new double[] { 1,2,3,4}, new double[] { 5,6,7,8} );

        XYSeries series =
                chart.addSeries("Série 2", new double[] { 5,6,7,8}, new double[] { 1,2,3,4 });
        series.setMarker(SeriesMarkers.DIAMOND);

        XYSeries series3 =
                chart.addSeries("Série 3", new double[] { 6,6.2,6.3,6.4}, new double[] { 6,6.2,6.3,6.4 });
        series3.setMarker(SeriesMarkers.SQUARE);

        new SwingWrapper(chart).displayChart();

    }
}

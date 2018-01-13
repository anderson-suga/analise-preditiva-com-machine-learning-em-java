import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.Random;

/**
 * Created by suemareverton on 18/08/17.
 * Apache Commons Math
 */

public class Exercicio08_2 {

    public static void main(String[] args) {

        DescriptiveStatistics stats = new DescriptiveStatistics();

        Random random = new Random();
        for(int i = 0; i < 1000; i++) {
            stats.addValue(random.nextInt(100));
        }

        System.out.println("Máximo: " + stats.getMax());
        System.out.println("Mínimo: " + stats.getMin());
        System.out.println("Soma: " + stats.getSum());
        System.out.println("Média: " + stats.getMean());
        System.out.println("Mediana: " + stats.getPercentile(50));
        System.out.println("Variância: " + stats.getVariance());
        System.out.println("Desvio padrão: " + stats.getStandardDeviation());

        System.out.println();
    }

}

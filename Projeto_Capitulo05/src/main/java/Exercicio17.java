import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by suemareverton on 04/09/17.
 * Estatísticas com Weka: http://weka.sourceforge.net/doc.stable/weka/classifiers/Evaluation.html
 */

public class Exercicio17 {

    public static void main(String[] args) {

        // Adicionar dependências no arquivo POM.XML

        NaiveBayes nb = null;
        Instances dataset = null;
        try {
            DataSource source = new DataSource("src/main/datasets/iris.arff");
            dataset = source.getDataSet();

            // Configurando a variável que nós queremos prever: a última
            dataset.setClassIndex(dataset.numAttributes()-1);

            // INSPECIONAR O DATASET NO DEBUGGER!

            // Instanciando o classificador
            // Observe que temos classes 'NaiveBayes' no Weka e no Smile -> fazer import corretamente
            nb = new NaiveBayes();
            nb.buildClassifier(dataset);

            Evaluation eval = new Evaluation(dataset);

            // Ordem dos parâmetros
            eval.crossValidateModel(nb,dataset,10, new Random(1));

            double[][] matrix = eval.confusionMatrix();
            System.out.println(Arrays.deepToString(matrix));

            for(int i = 0; i < 3; i++) {
                System.out.println("Verdadeiros positivos para classe " + i + ": " + eval.truePositiveRate(i));
                System.out.println("Verdadeiros negativos para classe " + i + ": " + eval.trueNegativeRate(i));
            }

            System.out.println("Instâncias classificadas corretamente: " + eval.correct());
            System.out.println("Percentual de instâncias classificadas corretamente: " + eval.pctCorrect());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }

    }

}

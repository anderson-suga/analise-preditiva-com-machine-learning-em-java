import weka.classifiers.bayes.NaiveBayes;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * Created by suemareverton on 04/09/17.
 * Java + Weka: https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
 * Construindo um classificador com Weka API
 */

public class Exercicio13 {

    public static void main(String[] args) {

        // Adicionar dependências no arquivo POM.XML

        DataSource source = null;
        try {
            source = new DataSource("src/main/datasets/iris.arff");
            Instances dataset = source.getDataSet();

            // Configurando a variável que nós queremos prever: a última
            dataset.setClassIndex(dataset.numAttributes()-1);

            // Instanciando o classificador
            // Observe que temos classes 'NaiveBayes' no Weka e no Smile -> fazer import corretamente
            NaiveBayes nb = new NaiveBayes();

            nb.buildClassifier(dataset);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }
    }

}

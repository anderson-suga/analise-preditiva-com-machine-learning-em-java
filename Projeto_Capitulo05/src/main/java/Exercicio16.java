import weka.classifiers.Evaluation;
import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

import java.util.Random;

/**
 * Created by suemareverton on 04/09/17.
 * Java + Weka: https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
 * CrossValidation com Weka
 */

public class Exercicio16 {

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

            // Agora observando os métodos do objeto eval, obtenha:
            // a Confusion Matrix
            // a taxa de verdadeiros positivos e verdadeiros negativos para cada classe
            // número de instâncias classificadas corretamente
            // percentual de instâncias classificadas corretamente

            // Para resolver o exercício proposto acima
            // consulte a documentação da classe Evaluation, disponível em:
            // http://weka.sourceforge.net/doc.stable/weka/classifiers/Evaluation.html

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }

    }

}

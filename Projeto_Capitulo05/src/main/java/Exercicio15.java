import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * Created by suemareverton on 04/09/17.
 * Java + Weka: https://weka.wikispaces.com/Use+WEKA+in+your+Java+code
 * Realizando uma predição com Weka API
 */

public class Exercicio15 {

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
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar arquivo: " + e.getMessage());
        }

        // Retornando caso não tenha criado o classificador
        if(nb == null || dataset == null)
            return;

        Instance inst = new DenseInstance(4);

        // 5.1,3.5,1.4,0.2 => Iris Setosa
        /*inst.setValue(0, 5.1);
        inst.setValue(1, 3.5);
        inst.setValue(2, 1.4);
        inst.setValue(3, 0.2);
        inst.setDataset(dataset);*/

        // 7.0,3.2,4.7,1.4 => Iris-versicolor
        /*inst.setValue(0, 7.0);
        inst.setValue(1, 3.2);
        inst.setValue(2, 4.7);
        inst.setValue(3, 1.4);
        inst.setDataset(dataset);*/

        // 6.3,3.3,6.0,2.5 => Iris-virginica
        inst.setValue(0, 6.3);
        inst.setValue(1, 3.3);
        inst.setValue(2, 6.0);
        inst.setValue(3, 2.5);
        inst.setDataset(dataset);

        System.out.println("Instância recém-criada: " + inst);

        // INSPECIONAR A INSTÂNCIA NO DEBUGGER!

        // Consegue fazer uma previsão? Qual método de nb classifica uma instância?
        // Quais argumentos devemos passar ao método e qual retorno iremos obter?

        try {
            double result = nb.classifyInstance(inst);
            System.out.println("Resultado: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

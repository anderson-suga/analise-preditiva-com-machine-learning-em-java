import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.Remove;

import java.util.Arrays;

/**
 * Created by suemareverton on 13/09/17.
 * Avaliando um modelo de clusterização
 */
public class Exercicio05 {

    public static void main(String[] args) {

        try {
            // Carregando instâncias do arquivo Weka
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("src/main/datasets/iris.arff");
            Instances data = source.getDataSet();

            // Removendo atributos utilizando filtros
            Remove filter = new Remove();

            // Estamos removendo somente o atributo class
            // Ou seja, o modelo também será criado utilizando as medidas das sépalas
            filter.setAttributeIndicesArray(new int[] { 4 });
            filter.setInputFormat(data);
            Instances dataClusterer = Filter.useFilter(data, filter);

            SimpleKMeans model = new SimpleKMeans();
            model.setNumClusters(3);
            model.setPreserveInstancesOrder(true);

            // Importante aqui, treinamos os modelos com os dados resultantes do filtro
            model.buildClusterer(dataClusterer);

            // Avaliando o modelo
            System.out.println("Avaliação do modelo");
            ClusterEvaluation eval = new ClusterEvaluation();
            eval.setClusterer(model);
            data.setClassIndex(4);
            eval.evaluateClusterer(data);
            System.out.println(eval.clusterResultsToString());
            System.out.println(Arrays.toString(model.getAssignments()));
            System.out.println("FIM");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

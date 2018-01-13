import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

/**
 * Created by suemareverton on 13/09/17.
 * Criando um modelo baseado no K-Means
 */
public class Exercicio01 {

    public static void main(String[] args) {

        try {
            // Carregando instâncias do arquivo Weka
            DataSource source = new DataSource("src/main/datasets/iris.arff");
            Instances data = source.getDataSet();

            // Criando um modelo baseado no K-Means
            SimpleKMeans model = new SimpleKMeans();

            // O número de clusters deverá ser definido por você
            // Pode ser simplesmente o número de clusters que você deseja
            // Pode ser devido a uma regra de negócio

            // Como vimos também existem métodos para ajudar a calcular o valor "ideal" de
            // clusters que melhor se ajusta a seus datasets, minimizando a distância dos
            // pontos de dados de um mesmo cluster (intra-cluster) e maximizando a distância
            // entre os pontos de dados de clusters diferentes (extra-cluster).
            model.setNumClusters(3);

            // Por padrão, a função de distância utilizada é a Distância Euclidiana
            // Caso queira, você pode especificar uma outra função, como a Distância de Manhattan
            // model.setDistanceFunction(new weka.core.ManhattanDistance());

            model.buildClusterer(data);
            System.out.println(model);

            // Que erros cometemos ao criar este modelo?
            // Consegue resolver?

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

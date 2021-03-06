import weka.clusterers.SimpleKMeans;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.util.Arrays;

/**
 * Created by suemareverton on 13/09/17.
 * Obtendo o cluster de uma nova observação
 */
public class Exercicio03 {

    public static void main(String[] args) {

        try {
            // Carregando instâncias do arquivo Weka
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("src/main/datasets/iris.arff");
            Instances data = source.getDataSet();

            // Vamos remover os atributos que não queremos, e principalmente
            data.deleteAttributeAt(data.attribute("sepallength").index());
            data.deleteAttributeAt(data.attribute("sepalwidth").index());
            data.deleteAttributeAt(data.attribute("class").index());

            SimpleKMeans model = new SimpleKMeans();
            model.setNumClusters(3);

            model.buildClusterer(data);
            System.out.println(model);

            // Classificando um ponto de dados em um cluster

            // Etapa 1: Criando uma nova observação
            Instance inst = new DenseInstance(2);
            inst.setValue(0, 1.4); // comprimento da pétala
            inst.setValue(1, 0.2); // largura da pétala

            // Etapa 2: "Classificando" a observação
            int cluster = model.clusterInstance(inst);

            System.out.println("Instância 1 pertence ao cluster: " + cluster);

            // Classificando outra instância
            Instance inst2 = new DenseInstance(2);
            inst.setValue(0, 5.1); // comprimento da pétala
            inst.setValue(1, 1.8); // largura da pétala
            System.out.println("Instância 2 pertence ao cluster: " + model.clusterInstance(inst2));

            // Também podemos ver as probabilidades de uma instância pertencer a cada um dos clusters
            // A soma deve ser igual a 1.0
            double[] probabilidades = model.distributionForInstance(inst2);
            System.out.println("Probabilidades: " + Arrays.toString(probabilidades));

            // http://weka.sourceforge.net/doc.dev/weka/clusterers/SimpleKMeans.html
            // Analisando os métodos do objeto model, obtenha:
            // a) Número de instâncias em cada cluster
            // b) Centróides dos clusters

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

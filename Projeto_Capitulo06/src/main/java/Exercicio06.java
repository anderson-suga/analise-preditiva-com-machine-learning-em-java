import weka.clusterers.ClusterEvaluation;
import weka.clusterers.SimpleKMeans;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.PrincipalComponents;
import weka.filters.unsupervised.attribute.Remove;

/**
 * Created by suemareverton on 13/09/17.
 */
public class Exercicio06 {

    public static void main(String[] args) {

        try {
            // Carregando instâncias do arquivo Weka
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("src/main/datasets/iris.arff");
            Instances data = source.getDataSet();

            // Removendo atributos utilizando filtros
            Remove filter = new Remove();

            // Estamos removendo somente o atributo class
            filter.setAttributeIndicesArray(new int[] { 4 });
            filter.setInputFormat(data);
            Instances dataClusterer = Filter.useFilter(data, filter);

            // Convertendo 4 variáveis preditoras em 2 componentes principais
            PrincipalComponents pca = new PrincipalComponents();

            // Entrada do PCA são só as 4 variáveis preditoras, sem target
            pca.setInputFormat(dataClusterer);

            // Queremos 2 componentes principais
            pca.setMaximumAttributes(2);

            // dataPrincipalComponents terá apenas 2 componentes principais
            Instances dataPrincipalComponents = Filter.useFilter(dataClusterer, pca);

            // Renomeando atributos
            dataPrincipalComponents.renameAttribute(0,"pc1");
            dataPrincipalComponents.renameAttribute(1,"pc2");

            SimpleKMeans model = new SimpleKMeans();
            model.setNumClusters(3);
            model.setPreserveInstancesOrder(true);

            // Importante aqui, treinamos os modelos com os dados resultantes do filtro
            // ou seja, somente os 2 componentes principais
            model.buildClusterer(dataPrincipalComponents);

            // Avaliando o modelo
            System.out.println("Avaliação do modelo");
            ClusterEvaluation eval = new ClusterEvaluation();

            // Para avaliarmos o modelo precisamos dos seguintes dados
            // pc1, pc2, class
            Instances dataEvaluation = source.getStructure();

            // Removendo atributos não utilizados para avaliação
            dataEvaluation.deleteAttributeAt(dataEvaluation.attribute("sepallength").index());
            dataEvaluation.deleteAttributeAt(dataEvaluation.attribute("sepalwidth").index());
            dataEvaluation.deleteAttributeAt(dataEvaluation.attribute("petallength").index());
            dataEvaluation.deleteAttributeAt(dataEvaluation.attribute("petalwidth").index());

            System.out.println("Número de atributos: " + dataEvaluation.numAttributes());
            for(int i = 0; i < dataEvaluation.numAttributes(); i++)
                System.out.println("Atributo " + i + ": " + dataEvaluation.attribute(i).name());

            // Recuperando atributos pc1 e pc2
            Attribute pc1Attribute = dataPrincipalComponents.attribute(0);
            Attribute pc2Attribute = dataPrincipalComponents.attribute(1);

            // Adicionando atributos pc1 e pc2 nos dados de avaliação
            dataEvaluation.insertAttributeAt(pc1Attribute,0);
            dataEvaluation.insertAttributeAt(pc2Attribute,1);

            System.out.println("Número de atributos: " + dataEvaluation.numAttributes());
            for(int i = 0; i < dataEvaluation.numAttributes(); i++)
                System.out.println("Atributo " + i + ": " + dataEvaluation.attribute(i).name());

            // Agora o atributo "Class" está no índice 2 (0 é o pc1 e 1 é o pc2)
            dataEvaluation.setClassIndex(2);

            // Temos a estrutura do dataset, mas precisamos adicionar as observações no mesmo
            for(int i = 0; i < dataPrincipalComponents.numInstances(); i++) {

                // Cada instância terá 2 atributos
                Instance instance = new DenseInstance(3);

                // Informando os valores dos atributos
                instance.setValue(0, dataPrincipalComponents.get(i).value(0));
                instance.setValue(1, dataPrincipalComponents.get(i).value(1));
                instance.setValue(2, data.get(i).value(4));

                // Adicionando instancia
                dataEvaluation.add(instance);
            }

            eval.setClusterer(model);
            eval.evaluateClusterer(dataEvaluation);
            System.out.println(eval.clusterResultsToString());
            System.out.println("FIM");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

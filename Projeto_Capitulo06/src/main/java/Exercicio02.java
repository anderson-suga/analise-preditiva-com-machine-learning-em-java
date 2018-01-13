import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

/**
 * Created by suemareverton on 13/09/17.
 * Removendo atributos não utilizados
 */
public class Exercicio02 {

    public static void main(String[] args) {

        try {
            ConverterUtils.DataSource source = new ConverterUtils.DataSource("src/main/datasets/iris.arff");
            Instances data = source.getDataSet();

            // Vamos remover os atributos que não queremos, e principalmente
            // remover o atributo class

            // Cuidado com o código abaixo!!!
            //data.deleteAttributeAt(0);
            //data.deleteAttributeAt(1);
           // data.deleteAttributeAt(4);

            data.deleteAttributeAt(data.attribute("sepallength").index());
            data.deleteAttributeAt(data.attribute("sepalwidth").index());
            data.deleteAttributeAt(data.attribute("class").index());

            // Outra possibilidade acima é a utilização de filtros, veremos mais adiante
            // weka.filters.unsupervised.attribute.Remove


            // Criando um modelo baseado no K-Means
            SimpleKMeans model = new SimpleKMeans();

            model.setNumClusters(3);

            model.buildClusterer(data);
            System.out.println(model);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Exercício: Como podemos classificar um novo ponto de dados (instância)
        // em um cluster utilizando o modelo recém-criado?

        // Analise a documentação da classe SimpleKMeans
        // http://weka.sourceforge.net/doc.dev/weka/clusterers/SimpleKMeans.html
    }

}

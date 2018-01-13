import org.apache.log4j.BasicConfigurator;
import smile.classification.LogisticRegression;
import smile.data.AttributeDataset;
import smile.data.parser.ArffParser;
import smile.math.Math;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by suemareverton on 04/09/17.
 */
public class Exercicio06 {

    public static void main(String[] args) {

        // Log
        BasicConfigurator.configure();

        ArffParser parser = new ArffParser();
        parser.setResponseIndex(8);

        AttributeDataset ds = null;

        try {
            ds = parser.parse("src/main/datasets/diabetes.arff");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(ds == null) {
            System.out.println("Ocorreu um erro");
            return;
        }

        double[][] X = ds.toArray(new double[ds.size()][]);
        int[] y = ds.toArray(new int[ds.size()]);

        // Split dos dados
        // https://github.com/haifengl/smile/issues/155

        // Fazer import de smile.math.Math
        int[] indexes = Math.permutate(ds.size());
        int trainSize = (int) (ds.size() * 0.7);
        int testSize = ds.size() - trainSize;

        double[][] X_train = new double[trainSize][];
        double[][] X_test  = new double[testSize][];
        int[] y_train = new int[trainSize];
        int[] y_test  = new int[testSize];

        // Agora observe os índices
        // Os [trainSize] primeiros índices deverão fazer parte dos dados de treino
        // Os [testSize] últimos índices deverão fazer parte dos dados de teste
        // Você consegue dividi-los?

        // Faça um loop for, olhando cada um dos índices e alocando os dados
        // nos arrays de treino ou teste
        int j = -1;

        // Dados de treino
        for(int i = 0; i < trainSize; i++) {
            j++;
            X_train[j] = X[indexes[i]];
            y_train[j] = y[indexes[i]];
        }

        j = -1;
        // Dados de teste
        for(int i = trainSize; i < ds.size(); i++) {
            j++;
            X_test[j] = X[indexes[i]];
            y_test[j] = y[indexes[i]];
        }


        // Criando o modelo de Regressão Logística
        LogisticRegression logR =
                new LogisticRegression.Trainer().train(X_train,y_train);

        // Fazendo mesma previsão para a primeira observação
        int temDiabetes = logR.predict(X[0]);

        System.out.println("Tem diabetes? " + temDiabetes);

        // Avaliando o modelo
        // Lembre-se que para avaliarmos o nosso modelo precisaremos das previsões do modelo
        // para seus dados de teste para depois comparar as respostas com os valores observados

        // Caso queira, também calcule as previsões para os dados de treino
        // Assim você poderá comparar as métricas nos dados de treino e teste

        // Então, crie 2 variáveis, y_pred_train e y_pred_test com os resultados
        // das previsões do seu modelo
    }

}

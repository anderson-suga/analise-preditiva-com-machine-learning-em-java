import org.apache.log4j.BasicConfigurator;
import smile.classification.LogisticRegression;
import smile.data.AttributeDataset;
import smile.data.parser.ArffParser;
import smile.math.Math;
import smile.validation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.Arrays;

/**
 * Created by suemareverton on 04/09/17.
 */
public class Exercicio09 {

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

        // Vamos fazer as previsões para dados de treino e teste!
        int[] y_pred_train = new int[trainSize];
        int[] y_pred_test  = new int[testSize];

        for(int i = 0; i < trainSize; i++)
            y_pred_train[i] = logR.predict(X_train[i]);

        for(int i = 0; i < testSize; i++)
            y_pred_test[i] = logR.predict(X_test[i]);

        // Avaliando o modelo
        // Tente obter a sensibilidade e a especificidade do modelo?
        // http://haifengl.github.io/smile/api/java/smile/validation/Sensitivity.html
        // http://haifengl.github.io/smile/api/java/smile/validation/Specificity.html

        // Seu modelo é melhor para predizer pacientes que tem diabetes,
        // ou para predizer pacientes que não tem diabetes?

        double sensibilidadeTreino = new Sensitivity().measure(y_train, y_pred_train);
        double sensibilidadeTeste = new Sensitivity().measure(y_test, y_pred_test);
        double especificidadeTreino = new Specificity().measure(y_train, y_pred_train);
        double especificidadeTeste = new Specificity().measure(y_test, y_pred_test);

        System.out.println("Sensibilidade (treino): " + sensibilidadeTreino);
        System.out.println("Sensibilidade (teste): " + sensibilidadeTeste);
        System.out.println("---");
        System.out.println("Especificidade (treino): " + especificidadeTreino);
        System.out.println("Especificidade (teste): " + especificidadeTeste);

        // E agora, como obter a Confusion Matrix e o F1-Score?
        ConfusionMatrix cm = new ConfusionMatrix(y_test, y_pred_test);
        int[][] matrix = cm.getMatrix();
        System.out.println(Arrays.deepToString(matrix));

        double recall = new Recall().measure(y_test, y_pred_test);
        System.out.println("Recall: " + recall);

        double f1 = new FMeasure().measure(y_test, y_pred_test);
        System.out.println("F1: " + f1);
    }

}

import smile.classification.LogisticRegression;
import smile.data.AttributeDataset;
import smile.data.parser.ArffParser;
import smile.validation.*;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by suemareverton on 04/09/17.
 */
public class Exercicio12 {

    public static void main(String[] args) {

        // Log
        //BasicConfigurator.configure();

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

        // Cross Validation
        int folds = 10;

        // A cada round vamos acumulando a acurácia e depois dividimos pelo número de rounds
        double accuracy_total = 0;

        // Vamos dividir nosso conjunto em 10 partes
        // Teremos 10 rounds...
        // para cada round usaremos 9 partes para treino e 1 parte para teste
        CrossValidation cv = new CrossValidation(ds.size(), folds);

        for(int i = 0; i < folds; i++) {
            // Obtendo o número de dados de treino e de teste PARA CADA DOBRA

            // Importante calcular para cada dobra porque a dobra final
            // pode ter menos elementos que o esperado
            int nTrainSamples = cv.train[i].length;
            int nTestSamples = cv.test[i].length;

            double[][] X_train = new double[nTrainSamples][];
            double[][] X_test  = new double[nTestSamples][];

            int[] y_train = new int[nTrainSamples];
            int[] y_test  = new int[nTestSamples];

            // Para cada "round", criar o X_train e o y_train com amostras diferentes
            // cujos índices foram retornados pelo objeto cv

            for(int j = 0; j < nTrainSamples; j++) {
                X_train[j] = X[cv.train[i][j]];
                y_train[j] = y[cv.train[i][j]];
            }
            for(int j = 0; j < nTestSamples; j++) {
                X_test[j] = X[cv.test[i][j]];
                y_test[j] = y[cv.test[i][j]];
            }

            // Criando o modelo do round atual!
            LogisticRegression logR =
                    new LogisticRegression.Trainer().train(X_train, y_train);

            // Fazendo as predições do round atual
            int[] y_pred_test = new int[nTestSamples];
            for(int j = 0; j < nTestSamples; j++) {
                y_pred_test[j] = logR.predict(X_test[j]);
            }

            double accuracy = new Accuracy().measure(y_test, y_pred_test);
            System.out.println("Acurácia do round " + (i+1) + ": " + accuracy);

            accuracy_total += accuracy;
        }

        System.out.println("---");
        System.out.println("Acurácia média: " + accuracy_total / folds);
    }

}

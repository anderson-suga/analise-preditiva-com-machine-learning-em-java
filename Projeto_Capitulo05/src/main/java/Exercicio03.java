import org.apache.log4j.BasicConfigurator;
import smile.classification.LogisticRegression;
import smile.data.AttributeDataset;
import smile.data.parser.ArffParser;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by suemareverton on 04/09/17.
 */
public class Exercicio03 {

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

        // Criando o modelo de Regressão Logística
        LogisticRegression logR =
                new LogisticRegression.Trainer().train(X,y);

        // Fazendo mesma previsão para a primeira observação
        int temDiabetes = logR.predict(X[0]);

        System.out.println("Tem diabetes? " + temDiabetes);
    }

}

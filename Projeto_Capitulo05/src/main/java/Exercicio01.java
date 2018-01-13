import org.apache.log4j.BasicConfigurator;
import smile.data.AttributeDataset;
import smile.data.parser.ArffParser;

import java.io.IOException;
import java.text.ParseException;

/**
 * Created by suemareverton on 04/09/17.
 */
public class Exercicio01 {

    public static void main(String[] args) {

        // Log
        BasicConfigurator.configure();

        ArffParser parser = new ArffParser();
        parser.setResponseIndex(4);

        AttributeDataset ds = null;

        try {
            ds = parser.parse("src/main/datasets/weather.arff");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        if(ds == null) {
            System.out.println("Ocorreu um erro");
            return;
        }

        // Atribuindo variáveis preditoras
        double[][] X = ds.toArray(new double[ds.size()][]);

        // Atribuindo variável target
        // Observe que ao contrário da regressão,
        // agora estamos instanciando um array de inteiros para as variáveis dependentes
        int[] y = ds.toArray(new int[ds.size()]);

        // Atenção, observe no debugger como o Smile
        // mudou a representação dos dados para variáveis categóricas

        // Conferindo alguns valores
        System.out.println(X[0][0]);
        System.out.println(y[0]);

        // Crie o modelo de Regressão Logística e faça uma predição
        // Haverá jogo de tênis para o caso abaixo?
        // Tempo: chovendo
        // Temperatura: 65
        // Umidade:70
        // Vento: SIM

        // Obs.: para realizar a predição você precisará passar as
        // variáveis preditoras codificadas como inteiro
        // Novamente: observe como o Smile realizou esta codificação
    }

}

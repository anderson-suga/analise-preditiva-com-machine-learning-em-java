import opennlp.tools.doccat.*;
import opennlp.tools.util.*;

import java.io.*;

/**
 * Created by suemareverton on 09/10/17.
 *
 */

public class Exercicio14 {

    public static void main(String[] args) {

        try {

            // Lendo os dados de teste
            InputStreamFactory factory = new MarkableFileInputStreamFactory(new File("nlp_files/tweets-test.txt"));
            ObjectStream<String> lineStream = new PlainTextByLineStream(factory, "UTF-8");
            ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

            // Carregando o modelo, ele foi criado no exercício anterior
            InputStream is = new FileInputStream("nlp_files/en-tweets-sentiments.bin");
            DoccatModel model = new DoccatModel(is);
            DocumentCategorizerME myCategorizer = new DocumentCategorizerME(model);

            // Instanciando o objeto que realizará a avaliação do modelo
            DocumentCategorizerEvaluator evaluator = new DocumentCategorizerEvaluator(myCategorizer);
            evaluator.evaluate(sampleStream);
            System.out.println("Acurácia: " + evaluator.getAccuracy());

            // Lembrando que a acurácia é uma métrica para avaliação de modelos de classificação
            // É o total de acertos dividido pelo total de testes
            // Cuidado ao avaliar seu modelo utilizando uma única métrica,
            // por exemplo: casos em que as classes estão desbalanceadas

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

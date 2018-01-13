import opennlp.tools.doccat.*;
import opennlp.tools.util.*;

import java.io.*;

/**
 * Created by suemareverton on 09/10/17.
 * Document Categorizer
 * https://opennlp.apache.org/docs/1.8.0/manual/opennlp.html#tools.cli.doccat.Doccat
 */
public class Exercicio13 {

    public static void main(String[] args) {

        try {
            // Vamos treinar um modelo para análise de sentimentos

            // Lendo os dados de treino
            InputStreamFactory factory = new MarkableFileInputStreamFactory(new File("nlp_files/tweets-train.txt"));
            ObjectStream<String> lineStream = new PlainTextByLineStream(factory, "UTF-8");
            ObjectStream<DocumentSample> sampleStream = new DocumentSampleStream(lineStream);

            // Criando o modelo a partir dos dados de treino
            DoccatModel model =
                    DocumentCategorizerME.train(
                            "en",
                            sampleStream,
                            TrainingParameters.defaultParams(),
                            new DoccatFactory()
                    );

            System.out.println("Modelo treinado");

            // Salvando o modelo, para que ele possa ser reutilizado depois
            BufferedOutputStream modelOut =
                    new BufferedOutputStream(new FileOutputStream("nlp_files/en-tweets-sentiments.bin"));

            model.serialize(modelOut);
            System.out.println("Modelo salvo");

            // Realizando uma predição
            DocumentCategorizer doccat = new DocumentCategorizerME(model);
            double[] aProbs = doccat.categorize("I dont love you");

            // Obtendo as probabilidades
            for(int i = 0; i < doccat.getNumberOfCategories(); i++ ) {
                System.out.println(doccat.getCategory(i) + " : " + aProbs[i]);
            }

            // Obtendo a classe (resultado da predição)
            System.out.println("Resultado: " + doccat.getBestCategory(aProbs));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

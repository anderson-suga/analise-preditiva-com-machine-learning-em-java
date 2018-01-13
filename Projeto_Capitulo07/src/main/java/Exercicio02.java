import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by suemareverton on 06/10/17.
 * Detecção de posições de sentenças
 */

public class Exercicio02 {

    public static void main(String[] args) {

        SentenceModel model = null;

        try {
            InputStream inputStream = new FileInputStream("nlp_models/en-sent.bin");
            model = new SentenceModel(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(model == null) {
            System.out.println("Modelo não foi carregado!");
            return;
        }

        // Com o modelo carregado, vamos utilizar a classe SentenceDetectorME
        // para detectar as posições da sentença no texto

        String sentence = "Artificial intelligence (AI, also machine intelligence, MI) is apparently " +
                "intelligent behaviour by machines, rather than the natural intelligence (NI) of " +
                "humans and other animals. In computer science AI research is defined as the study " +
                "of intelligent agents: any device that perceives its environment and takes actions " +
                "that maximize its chance of success at some goal.";

        SentenceDetectorME detector = new SentenceDetectorME(model);
        Span[] spans = detector.sentPosDetect(sentence);

        for (Span span : spans)
            System.out.println(span);

        int i = 0 ;
        for (Span span : spans) {
            System.out.println(
                    "Sentença " + (++i) + " vai de " + span.getStart() +
                            " até " + span.getEnd() +
                            " com " + span.length() + " caracteres."
            );
        }

    }

}

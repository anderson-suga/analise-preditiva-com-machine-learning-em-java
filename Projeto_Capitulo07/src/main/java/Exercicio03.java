import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by suemareverton on 06/10/17.
 * Probabilidades na detecção de sentenças
 */

public class Exercicio03 {

    public static void main(String[] args) {

        SentenceModel model = null;
        String text = null;

        try {
            InputStream inputStream = new FileInputStream("nlp_models/en-sent.bin");
            model = new SentenceModel(inputStream);

            Path text1_path = Paths.get("nlp_files", "text1.txt");
            Charset charset = Charset.forName("ISO-8859-1");
            List<String> lines = Files.readAllLines(text1_path, charset);
            text = lines.toString();

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
        // para detectar as probabilidades das setenças no texto
        SentenceDetectorME detector = new SentenceDetectorME(model);
        Span[] spans = detector.sentPosDetect(text);

        String sentences[] = detector.sentDetect(text);
        double[] probs = detector.getSentenceProbabilities();

        for(int i = 0; i < sentences.length; i++) {
            System.out.println(probs[i] + " - " + sentences[i]);
            System.out.println();
        }
    }

}

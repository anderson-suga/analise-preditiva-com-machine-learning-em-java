import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by suemareverton on 06/10/17.
 * Part of Speech
 * Etiquetamento (Tagging)
     NN	substantivo
     DT	artigo (determiner)
     VB	verbo (base form)
     VBD	verbo (past tense)
     VBZ	verbo (third person singular present)
     IN	preposição
     NNP	nome próprio
     JJ	adjetivo
 */

public class Exercicio10 {

    public static void main(String[] args) {

        InputStream inputStream = null;
        POSModel posModel = null;

        try {
            inputStream = new FileInputStream("nlp_models/en-pos-maxent.bin");
            posModel = new POSModel(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(posModel == null) {
            System.out.println("Não foi possível carregar o modelo");
            return;
        }

        POSTaggerME tagger = new POSTaggerME(posModel);
        String sentence = "Mary is beautiful";

        // Tokenizando
        WhitespaceTokenizer whitespaceTokenizer= WhitespaceTokenizer.INSTANCE;
        String[] tokens = whitespaceTokenizer.tokenize(sentence);

        // Etiquetando cada um dos tokens
        String[] tags = tagger.tag(tokens);

        System.out.println(Arrays.toString(tags));

        double[] probs = tagger.probs();

        // Imprimindo tokens, tags e probabilidades
        for(int i = 0; i < probs.length; i++) {
            System.out.println(tokens[i] + " : " + tags[i] + " : " + probs[i]);
        }
    }

}

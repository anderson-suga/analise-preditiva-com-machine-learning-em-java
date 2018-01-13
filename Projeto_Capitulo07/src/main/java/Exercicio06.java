import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by suemareverton on 06/10/17.
 * Tokenização - Parte 3
 */

public class Exercicio06 {

    public static void main(String[] args) {
        String sentence = "Natural language processing (NLP) is a field of computer science, " +
                "artificial intelligence and computational linguistics concerned with " +
                "the interactions between computers and human (natural) languages, and, " +
                "in particular, concerned with programming computers to fruitfully process " +
                "large natural language corpora.";

        TokenizerModel tokenModel = null;

        try {
            InputStream inputStream = new FileInputStream("nlp_models/en-token.bin");
            tokenModel = new TokenizerModel(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(tokenModel == null) {
            System.out.println("Não foi possível carregar o modelo");
            return;
        }

        // Instanciando a classe TokenizerME que recebe o modelo por parâmetro
        TokenizerME tokenizer = new TokenizerME(tokenModel);

        // Tokenizando
        String tokens[] = tokenizer.tokenize(sentence);

        for (String token : tokens)
            System.out.println(token);

        // Nos vídeos anteriores nós utilizamos um array de Span para obter a localização
        // das sentenças em um texto.
        // Altere o programa para obter a localização dos tokens no texto.
    }

}

import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.Span;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by suemareverton on 06/10/17.
 */

public class Exercicio09 {

    public static void main(String[] args) {

        String text = "Salt Lake City is the capital and the most populous municipality of the U.S. state of Utah.";

        // Observe que o nome do município (Salt Lake City) é composto por 3 tokens
        // Se lembra do conceito de Collocations?

        // Etapa 1 - Tokenização

        TokenizerModel tokenModel = null;

        try {
            InputStream inputStreamTokenizer = new FileInputStream("nlp_models/en-token.bin");
            tokenModel = new TokenizerModel(inputStreamTokenizer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(tokenModel == null) {
            System.out.println("Não foi possível carregar o modelo de tokenização");
            return;
        }

        TokenizerME tokenizer = new TokenizerME(tokenModel);

        // Obtendo os tokens
        // Eles serão necessários mais adiante
        String tokens[] = tokenizer.tokenize(text);

        // Etapa 2 - Reconhecendo os nomes de entidades
        TokenNameFinderModel tokenNameFinderModel = null;
        try {
            InputStream inputStreamNameFinder = new FileInputStream("nlp_models/en-ner-location.bin");
            tokenNameFinderModel = new TokenNameFinderModel(inputStreamNameFinder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(tokenNameFinderModel == null) {
            System.out.println("Não foi possível carregar o modelo de reconhecimento de nomes de entidades");
            return;
        }

        // Instanciando um objeto da classe NameFinderME passando o modelo como parâmetro
        NameFinderME nameFinder = new NameFinderME(tokenNameFinderModel);

        // Reconhecendo os nomes das entidades
        // Observe que aqui temos que passar como parâmetro os tokens obtidos anteriormente e não o texto propriamente dito
        Span nameSpans[] = nameFinder.find(tokens);

        // Imprimindo as entidades reconhecidas
        // Observe a estrutura nameSpans
        for(Span nameSpan: nameSpans) {
            String location = "";
            for(int i = nameSpan.getStart(); i < nameSpan.getEnd(); i++)
                location += tokens[i] + " ";
            System.out.println(nameSpan.toString().trim() + " - " + location);
        }
    }

}

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

public class Exercicio08 {

    public static void main(String[] args) {

        String text = "Mike has a sister. Her name is Mary.";

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
            InputStream inputStreamNameFinder = new FileInputStream("nlp_models/en-ner-person.bin");
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
        for(Span nameSpan: nameSpans) {
            System.out.println(nameSpan.toString() + " em " + nameSpan.getStart() + ": " + tokens[nameSpan.getStart()]);
        }

        // Exercício 1: Altere este programa para ele reconhecer localizações.

        // Exercício 2: Utilize a frase: Salt Lake City is the capital of Utah.
        // Observe que o nome do município (Salt Lake City) é composto por 3 tokens
        // Se lembra do conceito de Collocations?
    }

}

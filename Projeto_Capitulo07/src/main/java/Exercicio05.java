import opennlp.tools.tokenize.WhitespaceTokenizer;

/**
 * Created by suemareverton on 06/10/17.
 * Tokenização - Parte 2
 */

public class Exercicio05 {

    public static void main(String[] args) {
        String sentence = "Natural language processing (NLP) is a field of computer science, " +
                "artificial intelligence and computational linguistics concerned with " +
                "the interactions between computers and human (natural) languages, and, " +
                "in particular, concerned with programming computers to fruitfully process " +
                "large natural language corpora.";

        // Utilizando WhiteSpaceTokenizer
        // Observe como é realizada a instanciação do objeto
        WhitespaceTokenizer whitespaceTokenizer = WhitespaceTokenizer.INSTANCE;

        // Tokenizando
        String tokens[] = whitespaceTokenizer.tokenize(sentence);

        // Imprimindo os tokens
        for(String token : tokens) {
            System.out.println(token);
        }
    }

}

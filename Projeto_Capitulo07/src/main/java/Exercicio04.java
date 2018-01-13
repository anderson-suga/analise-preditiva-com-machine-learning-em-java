import opennlp.tools.tokenize.SimpleTokenizer;

/**
 * Created by suemareverton on 06/10/17.
 * Tokenização - Parte 1
 */

public class Exercicio04 {

    public static void main(String[] args) {
        String sentence = "Natural language processing (NLP) is a field of computer science, " +
                "artificial intelligence and computational linguistics concerned with " +
                "the interactions between computers and human (natural) languages, and, " +
                "in particular, concerned with programming computers to fruitfully process " +
                "large natural language corpora.";

        // Utilizando SimpleTokenizer
        // Observe como é realizada a instanciação do objeto
        SimpleTokenizer simpleTokenizer = SimpleTokenizer.INSTANCE;

        // Tokenizando
        String tokens[] = simpleTokenizer.tokenize(sentence);

        // Imprimindo os tokens
        for(String token : tokens) {
            System.out.println(token);
        }

        // Agora realize a tokenização utilizando a classe WhiteSpaceTokenizer
    }

}

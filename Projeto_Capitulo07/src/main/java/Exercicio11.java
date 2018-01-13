import opennlp.tools.stemmer.PorterStemmer;

/**
 * Created by suemareverton on 09/10/17.
 *
 * Stemming
 *
 *  Vários motores de buscas tratam palavras com o mesmo tronco como
 *  sinônimos como um tipo de expansão  de consulta, em um processo de combinação.
 *
 */

public class Exercicio11 {

    public static void main(String[] args) {

        String[] words = new String[] {
                "The", "boy's", "cars", "are", "different", "colors"
        };

        PorterStemmer stemmer = new PorterStemmer();

        System.out.println("Word - Stem");
        for(String word : words) {
            String stem = stemmer.stem(word);
            System.out.println(word + " - " + stem);
        }
    }

}

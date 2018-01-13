import opennlp.tools.lemmatizer.SimpleLemmatizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.*;

/**
 * Created by suemareverton on 09/10/17.
 *
 * Lemmatization
 *
 * Documentação do OpenNLP
 * The lemmatizer returns, for a given word form (token) and Part of Speech tag,
 * the dictionary form of a word, which is usually referred to as its lemma.
 *
 * Referência:
 * https://nlp.stanford.edu/IR-book/html/htmledition/stemming-and-lemmatization-1.html
 *
 * https://stackoverflow.com/questions/1787110/what-is-the-true-difference-between-lemmatization-vs-stemming
 * Lemmatisation is closely related to stemming. The difference is that a stemmer operates on a single word without
 * knowledge of the context, and therefore cannot discriminate between words which have different meanings
 * depending on part of speech.
 * However, stemmers are typically easier to implement and run faster,
 * and the reduced accuracy may not matter for some applications.
 * For instance:
 * The word "better" has "good" as its lemma. This link is missed by stemming, as it requires a dictionary look-up.
 * The word "walk" is the base form for word "walking", and hence this is matched in both stemming and lemmatisation.
 * The word "meeting" can be either the base form of a noun or a form of a verb ("to meet") depending on the context, e.g.,
 * "in our last meeting" or "We are meeting again tomorrow".
 * Unlike stemming, lemmatisation can in principle select the appropriate lemma depending on the context.
 */

public class Exercicio12 {

    public static void main(String[] args) {

        try{
            // Parte 1: Tokenização
            // Tokenizar a sentença para obter os tokens
            // Para facilitar, neste exemplo já especificaremos diretamente os tokens
            String[] tokens = new String[] {
                    "The", "boy's", "cars", "are", "different", "colors"
            };

            // Parte 2: Taggeamento
            InputStream posModelIn = new FileInputStream("nlp_models/en-pos-maxent.bin");
            POSModel posModel = new POSModel(posModelIn);
            POSTaggerME posTagger = new POSTaggerME(posModel);
            String tags[] = posTagger.tag(tokens);

            // Parte 3: Lemmatization
            InputStream dictLemmatizer = new FileInputStream("nlp_files/en-lemmatizer.dict.txt");
            SimpleLemmatizer lemmatizer = new SimpleLemmatizer(dictLemmatizer);

            // Resultados
            System.out.println("Token - Tag - Lemma");
            for(int i = 0 ; i < tokens.length; i++) {
                String token = tokens[i];
                String tag = tags[i];
                String lemma = lemmatizer.lemmatize(token, tag);
                System.out.println(token + " - " + tag + " : " + lemma);
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;

/**
 * Created by suemareverton on 14/08/17.
 * Apache Commons Colections
 * Bags
 */

public class Exercicio01 {

    public static void main(String[] args) {
        Bag bag = new HashBag();

        // 6 ocorrências do termo "Machine Learning"
        bag.add("Machine Learning", 8);

        // 2 ocorrências do termo "Big Data"
        bag.add("Big Data",2);

        // removendo 2 ocorrências do termo "Machine Learning"
        bag.remove("Machine Learning", 10);

        // quantas ocorrências de "Machine Learning"?
        int totalOcorrencias =
                bag.getCount("Machine Learning");

        System.out.println(totalOcorrencias + " afinal, 8 - 3 = 5");
    }

}

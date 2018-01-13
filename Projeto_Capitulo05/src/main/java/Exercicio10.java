import smile.validation.Accuracy;
import smile.validation.CrossValidation;

/**
 * Created by suemareverton on 04/09/17.
 * https://en.wikipedia.org/wiki/Cross-validation_(statistics)
 */
public class Exercicio10 {

    public static void main(String[] args) {

        // Crie uma métrica para retornar a acurácia do modelo

        int[] truth   = new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1, 0};
        int[] predict = new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1, 1};

        System.out.println("Acurácia: " + new Accuracy().measure(truth, predict));

    }

}

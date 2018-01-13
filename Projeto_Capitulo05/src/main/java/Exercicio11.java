import smile.validation.CrossValidation;

/**
 * Created by suemareverton on 04/09/17.
 * https://en.wikipedia.org/wiki/Cross-validation_(statistics)
 */
public class Exercicio11 {

    public static void main(String[] args) {

        // Observe como é obtido os índices de uma validação cruzada

        CrossValidation cv = new CrossValidation(100, 10);
        int[][] train = cv.train;
        int[][] test = cv.test;

        // Exercício.:
        // Aplique a validação cruzada no exercício anterior (diabetes)
        // criando 10 classificadores e obtendo a média da acurácia dos classificadores
    }

}

package validation;

import smile.validation.ClassificationMeasure;

/**
 * Created by suemareverton on 04/09/17.
 */
public class Accuracy implements ClassificationMeasure {


    public double measure(int[] truth, int[] predict) {

        // Validações (paramêtros não-nulos, tamanhos iguais, etc);

        int totalAcertos = 0;
        for(int i = 0; i < truth.length; i++) {
            if(truth[i] == predict[i])
                totalAcertos++;
        }

        return totalAcertos / truth.length;
    }
}

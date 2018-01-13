import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;

/**
 * Created by suemareverton on 16/08/17.
 * Apache Commons Math
 * http://commons.apache.org/proper/commons-math/ *
 */

public class Exercicio08_1 {

    public static void main(String[] args) {

        // Multiplicação de Matrizes

        // Matriz 3 X 2
        double[][] matrixData = { {2,3}, {0,1}, {-1,4} };
        RealMatrix m = MatrixUtils.createRealMatrix(matrixData);

        // Matrix 2 X 3
        double[][] matrixData2 = { {1,2,3}, {-2, 0, 4}};
        RealMatrix n = MatrixUtils.createRealMatrix(matrixData2);

        // Número de colunas da Matriz m (2) == número de linhas da matriz n (2)
        // então podemos multiplicá-la

        RealMatrix p = m.multiply(n);

        System.out.println(p);
        System.out.println();
    }
}

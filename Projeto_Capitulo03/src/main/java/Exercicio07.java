import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.primitives.Ints;

/**
 * Created by suemareverton on 14/08/17.
 * Google Guava
 * Ranges
 */

public class Exercicio07 {

    public static void main(String[] args) {

        // Criando um intervalo de 0 a 9 (inclusive => closed)
        Range<Integer> range1 = Range.closed(0, 9);
        System.out.print("[0,9] : ");
        printRange(range1);

        System.out.println("5 está presente: " + range1.contains(5));
        System.out.println("(5,6,7) está presente: " + range1.containsAll(Ints.asList(5, 6, 7)));
        System.out.println("Limite inferior " + range1.lowerEndpoint());
        System.out.println("Limite superior: " + range1.upperEndpoint());

        // Criando um invervalo de 0 a 9 (exclusivo => open)
        Range<Integer> range2 = Range.open(0, 9);
        System.out.print("(0,9) : ");
        printRange(range2);

        // Criando um invervalo de 0 a 9 (aberto-fechado)
        Range<Integer> range3 = Range.openClosed(0, 9);
        System.out.print("(0,9] : ");
        printRange(range3);

        // Criando um intervalo de 0 a 9 (fechado-aberto)
        Range<Integer> range4 = Range.closedOpen(0, 9);
        System.out.print("[0,9) : ");
        printRange(range4);

        // Criando um intervalo de 9 ao infinito
        Range<Integer> range5 = Range.greaterThan(9);
        System.out.println("(9,infinito) : ");
        System.out.println("Limite inferior: " + range5.lowerEndpoint());
        System.out.println("Limite superior está presente? : " + range5.hasUpperBound());

        Range<Integer> range6 = Range.closed(3, 5);
        printRange(range6);

        // O sub-intervalo [3,5] está em [0,9]
        System.out.println("Intervalo [0,9] possui [3,5]:" + range1.encloses(range6));

        Range<Integer> range7 = Range.closed(5, 15);

        // Intersecção dos elementos no range 1 e range 7
        printRange(range1.intersection(range7));

        // Span [0..9] e [5..15]
        // Retorna o intervalo mínimo que delimita os 2 intervalos
        printRange(range1.span(range7));
    }

    private static void printRange(Range<Integer> range) {
        System.out.print("[ ");
        for(int grade : ContiguousSet.create(range, DiscreteDomain.integers())) {
            System.out.print(grade +" ");
        }
        System.out.println("]");
    }

}

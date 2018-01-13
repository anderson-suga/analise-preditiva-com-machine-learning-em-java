import models.Curso;
import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

/**
 * Created by suemareverton on 14/08/17.
 * Apache Commons Collections
 * Mapas bidirecionais
 */

public class Exercicio04 {

    public static void main(String[] args) {
        BidiMap<Integer, Curso> catalogo = new TreeBidiMap<Integer, Curso>();
        catalogo.put(3, new Curso("Java Fundamentos", 100));
        catalogo.put(2, new Curso("Java Machine Learning",200));
        catalogo.put(1, new Curso("Java Deep Learning",300));

        Curso curso2 = catalogo.get(2);
        System.out.println("Curso 2: " + curso2.getNome());

        // Retorna um mapa com chaves e valores invertidos
        BidiMap inverso = catalogo.inverseBidiMap();

        // Agora a chave é um curso e os valores são inteiros
        // Ou seja, temos um mapa de Curso => Integer
        System.out.println(inverso.get(curso2));
    }

}

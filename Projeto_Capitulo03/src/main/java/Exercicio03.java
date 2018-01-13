import models.Curso;
import org.apache.commons.collections4.OrderedMap;
import org.apache.commons.collections4.map.LinkedMap;

/**
 * Created by suemareverton on 14/08/17.
 * Apache Commons Collections
 * Ordered Maps
 */

public class Exercicio03 {

    public static void main(String[] args) {

        OrderedMap<Integer, Curso> catalogo = new LinkedMap<Integer, Curso>();
        catalogo.put(3, new Curso("Java Fundamentos", 100));
        catalogo.put(2, new Curso("Java Machine Learning",200));
        catalogo.put(1, new Curso("Java Deep Learning",300));

        System.out.println("Primeira chave: " + catalogo.firstKey());
        System.out.println("Primeiro curso: " + catalogo.get(catalogo.firstKey()).getNome());

        System.out.println("Última chave: " + catalogo.lastKey());
        System.out.println("Último curso: " + catalogo.get(catalogo.lastKey()).getNome());

        Integer proximaChave = catalogo.nextKey(catalogo.firstKey());
        System.out.println("Segunda chave: " + proximaChave);

        System.out.println("Terceiro curso: " + catalogo.get(catalogo.nextKey(proximaChave)).getNome());
    }

}

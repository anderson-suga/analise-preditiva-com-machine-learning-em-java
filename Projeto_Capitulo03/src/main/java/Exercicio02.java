import models.Curso;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.map.HashedMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by suemareverton on 14/08/17.
 * Apache Commons Collections
 * Maps Iterators
 */
public class Exercicio02 {

    public static void main(String[] args) {

        // Forma tradicional
        /*Map<Integer, Curso> catalogo1 = new HashMap<Integer,Curso>();
        catalogo1.put(1, new Curso("Java Fundamentos", 100));
        catalogo1.put(2, new Curso("Java Machine Learning",200));
        catalogo1.put(3, new Curso("Java Deep Learning",300));

        for(Integer chave : catalogo1.keySet()) {
            System.out.println(catalogo1.get(chave).getNome());
            // O que acontece aqui?
            catalogo1.remove(chave);
        }

        System.out.println("---");*/

        // Maps Iterators
        HashedMap<Integer,Curso> catalogo2 = new HashedMap<Integer, Curso>();
        catalogo2.put(1, new Curso("Java Fundamentos", 100));
        catalogo2.put(2, new Curso("Java Machine Learning",200));
        catalogo2.put(3, new Curso("Java Deep Learning",300));

        MapIterator it = catalogo2.mapIterator();
        while (it.hasNext()) {
            Integer chave = (Integer) it.next();
            Curso valor =  (Curso) it.getValue();

            if(chave == 2)
                it.remove();
            else
                System.out.println(chave + " => " + valor.getNome());
        }

        System.out.println("---");
        System.out.println("Total de elementos: " + catalogo2.size());
    }


}

import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;

/**
 * Created by suemareverton on 14/08/17.
 * Google Guava
 * Tables
 */

public class Exercicio06 {

    // Uma 'Table' do Google Guava é uma coleção que representa uma tabela.
    // A estrutura possui linhas 'R' e colunas 'C'.
    // Uma linha e uma coluna se torna um par de chaves para se obter o valor 'V' de uma célula.

    // Imagine a seguinte tabela
    //+========================+=========+========================+
    //|                        |Créditos |        Valor           |
    //+========================+=========+========================+
    //| Java Fundamentos       |      15 |                  1000  |
    //+------------------------+---------+------------------------+
    //| Java Machine Learning  |      25 |                  2000  |
    //+------------------------+---------+------------------------+
    //| Java Deep Learning     |      35 |                  3000  |
    //+------------------------+---------+------------------------+



    public static void main(String[] args) {

        // Por que <String,String,Integer>?
        Table<String, String, Integer> catalogo = TreeBasedTable.create();

        catalogo.put("Java Fundamentos", "Créditos", 15);
        catalogo.put("Java Fundamentos", "Valor", 1000);

        catalogo.put("Java Machine Learning", "Créditos", 25);
        catalogo.put("Java Machine Learning", "Valor", 2000);

        catalogo.put("Java Deep Learning", "Créditos", 35);
        catalogo.put("Java Deep Learning", "Valor", 3000);

        // Contém a coluna "Valor"?
        System.out.println(catalogo.containsColumn("Valor"));

        // Contém a linha "Java Machine Learning"?
        System.out.println(catalogo.containsRow("Java Machine Learning"));

        // "Java Machine Learning" possui "Créditos"?
        System.out.println(catalogo.contains("Java Machine Learning","Créditos"));

        // Quais são o "Valor" de "Java Deep Learning"?
        System.out.println(catalogo.get("Java Deep Learning","Valor"));

        catalogo.remove("Java Deep Learning","Créditos");
        System.out.println(catalogo.contains("Java Deep Learning","Créditos"));
        System.out.println(catalogo.get("Java Deep Learning","Créditos"));
    }

}

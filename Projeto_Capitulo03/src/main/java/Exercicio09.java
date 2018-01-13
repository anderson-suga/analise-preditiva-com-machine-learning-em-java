import org.jsoup.Jsoup;

import java.io.IOException;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by suemareverton on 16/08/17.
 * JSoup
 * Referência: https://jsoup.org/
 */

public class Exercicio09 {

    public static void main(String[] args) {

        try {
            Document doc =
                    Jsoup.connect("https://www.w3schools.com/html/html_tables.asp").get();

            // Mostrando título da página
            System.out.println("Título da página: " + doc.title());

            // Selecionando elementos tbody tr do objeto de id customers
            Elements tableRows = doc.select("#customers tbody tr");
            //System.out.println(tableRows);

            for (Element tr : tableRows) {
                Elements columns = tr.select("td");

                if (columns.isEmpty())
                    continue;

                String empresa = columns.get(0).text();
                String contato = columns.get(1).text();
                String pais = columns.get(2).text();

                System.out.println(contato + " é o contato da empresa " + empresa + " em " + pais);
            }

        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
        }
    }

}

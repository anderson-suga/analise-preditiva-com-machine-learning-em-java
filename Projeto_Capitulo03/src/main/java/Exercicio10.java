import com.google.gson.Gson;
import models.Post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by suemareverton on 16/08/17.
 * Lendo objetos JSON
 * Uso da biblioteca GSON: https://github.com/google/gson
 */

public class Exercicio10 {

    public static void main(String[] args) {

        URL url = null;
        String jsonString = "";

        // Fazendo requisição e obtendo resposta (em formato JSON)
        try {
            url = new URL("https://jsonplaceholder.typicode.com/posts/2");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null)
                jsonString += inputLine;

            in.close();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(jsonString);

        // Desserializando -> Convertendo uma String em notação JSON para
        // uma instância da classe Post

        Gson gson = new Gson();
        Post post = gson.fromJson(jsonString, Post.class);

        System.out.println("");
        System.out.println("Título: " + post.getTitle());
        System.out.println("");
        System.out.println("Corpo: " + post.getBody());
    }
}

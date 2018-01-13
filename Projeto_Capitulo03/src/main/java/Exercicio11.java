import com.google.gson.Gson;
import models.Fighter;
import models.Post;
import utils.UrlUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by suemareverton on 16/08/17.
 * Lendo listas de objetos JSON
 * Uso da biblioteca GSON: https://github.com/google/gson
 */
public class Exercicio11 {

    public static void main(String[] args) {

        String jsonString =
                UrlUtils.getResponseFromUrl("http://ufc-data-api.ufc.com/api/v3/iphone/fighters");

        Gson gson = new Gson();

        // Desserializando -> Convertendo uma String em notação JSON
        // para um ARRAY de instâncias da classe Fighter
        Fighter[] fightersArray = gson.fromJson(jsonString, Fighter[].class);

        // E se precisarmos converter para uma Lista?
        List<Fighter> fightersList = Arrays.asList(fightersArray);

        for(Fighter fighter : fightersList) {
            System.out.println(
                    fighter.firstName + " " + fighter.lastName + " possui " + fighter.wins + " vitórias"
            );
            System.out.println("Foto: " + fighter.profileImage);
            System.out.println("");
        }
    }

}

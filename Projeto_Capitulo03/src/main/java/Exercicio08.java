import models.Funcionario;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by suemareverton on 16/08/17.
 * Apache Commons CSV
 */

public class Exercicio08 {

    public static void main(String[] args) {
        List<Funcionario> listaFuncionarios = new ArrayList<>();
        Path csvFile = Paths.get("src/main/java/files/funcionarios.csv");

        try (BufferedReader reader = Files.newBufferedReader(csvFile, StandardCharsets.UTF_8)) {

            CSVFormat csv = CSVFormat.RFC4180.withHeader();

            try (CSVParser parser = csv.parse(reader)) {
                Iterator<CSVRecord> it = parser.iterator();

                it.forEachRemaining(rec -> {
                    String nome = rec.get("nome");
                    String email = rec.get("email");
                    String empresa = rec.get("empresa");
                    float salario = Float.parseFloat(rec.get("salario"));
                    Funcionario funcionario =
                            new Funcionario(nome, email, empresa, salario);
                    listaFuncionarios.add(funcionario);
                });
            } catch (IllegalArgumentException iaException) {
                System.out.println("Falha ao interpretar arquivo: " + iaException.getMessage());
            }

        } catch (IOException ioException) {
            System.out.println("Falha ao ler arquivo: " + ioException.getMessage());
        }

        listaFuncionarios.stream()
                .forEach(f -> System.out.println(f.getNome() + " " + f.getSalario()));



    }
}

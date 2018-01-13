import com.github.lwhite1.tablesaw.api.CategoryColumn;
import com.github.lwhite1.tablesaw.api.Table;

import java.io.IOException;

import static com.github.lwhite1.tablesaw.api.QueryHelper.column;

/**
 * Created by suemareverton on 16/08/17.
 * "Dataframes"
 *
 * TableSaw: https://github.com/jtablesaw/tablesaw *
 * Joinery: https://github.com/cardillo/joinery
 */
public class Exercicio12 {

    public static void main(String[] args) {

        try {
            long ti = System.currentTimeMillis();
            Table tornados =
                    Table.createFromCsv("src/main/java/files/tornadoes_1950-2014.csv");

            long tf = System.currentTimeMillis();
            System.out.println("Carregado em " + (tf - ti) + " ms");

            System.out.println("Colunas: " + tornados.columnNames());

            System.out.println("Shape: " + tornados.shape());
            System.out.println(tornados.rowCount() + " X " + tornados.columnCount());

            System.out.println(tornados.structure().print());

            // Filtrando linhas
            Table tornadosComMais100Mortes =
                  tornados.selectWhere(column("Fatalities").isGreaterThan(100));
            System.out.println(tornadosComMais100Mortes.shape());

            // Imprimindo resultado
            System.out.println(tornadosComMais100Mortes.print());

            // Visualizando 2 primeiras linhas
            System.out.println(tornadosComMais100Mortes.first(2).print());

            // Mapeamento
            CategoryColumn month = tornados.dateColumn("Date").month();
            tornadosComMais100Mortes.addColumn(month);

            // Removendo coluna
            tornadosComMais100Mortes.removeColumns("Date");

            // Ordenando (observe o retorno do método)
            tornadosComMais100Mortes =
                tornadosComMais100Mortes.sortDescendingOn("Injuries");

            // Estatística descritiva
            System.out.println(
                tornadosComMais100Mortes.column("Injuries").summary().print()
            );

            // Tornados no 4 trimestre com mais de 4 feridos
            Table tornadosNoQuartoTrimestre =
                    tornados.selectWhere(column("Injuries").isGreaterThanOrEqualTo(5))
                            .selectWhere(column("Scale").isGreaterThan(2))
                            .select("Date", "Injuries","Scale")
                                .where(column("Date").isInQ4());

            System.out.println("Tornados no Quarto Trimestre com mais de 4 feridos");
            System.out.println(tornadosNoQuartoTrimestre.print());

            tornadosNoQuartoTrimestre
                    .exportToCsv("src/main/java/files/tornados_4_trimestre.csv");

            // Utilizando o formato .saw para otimização de leitura
            // Para salvar
            String datasetName = tornados.save("src/main/java/files");

            // Para carregar
            ti = System.currentTimeMillis();
            Table meuNovoDataSet = Table.readTable(datasetName);
            tf = System.currentTimeMillis();
            System.out.println("Carregado em " + (tf - ti) + " ms");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
            e.printStackTrace();
        }

    }

}

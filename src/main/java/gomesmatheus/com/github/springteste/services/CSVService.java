package gomesmatheus.com.github.springteste.services;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import gomesmatheus.com.github.springteste.domain.Jogador;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVService {

    public static String CAMINHO_CSV = System.getProperty("user.dir") + "\\src\\main\\resources\\data.csv";

    public static List<Jogador> lerArquivo(String caminho) {
        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build(); // Separador
        List<Jogador> listaJogador = new ArrayList<Jogador>();

        try {
            CSVReader reader = new CSVReaderBuilder(new FileReader(caminho))
                    .withCSVParser(csvParser)
                    .withSkipLines(1) // Pula a primeira Linha (cabe�alho)
                    .build();

            List<String[]> r = reader.readAll();
            for (String[] strings : r) {
                Jogador jogador = new Jogador();
                jogador.setNickname(strings[0]);
                jogador.setIdade(Integer.valueOf(strings[1]));
                jogador.setMain(strings[2]);
                jogador.setElo(strings[3]);

                listaJogador.add(jogador);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

        return listaJogador;
    }
}

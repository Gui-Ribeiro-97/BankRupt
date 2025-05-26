package game;
import model.Propriedade;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;

public class Configuracao {
    public static List<Propriedade> carregarPropriedades(String caminhoArquivo) throws IOException {
        List<Propriedade> propriedades = new ArrayList<>();
        List<String> linhas = Files.readAllLines(Paths.get(caminhoArquivo));

        for (String linha : linhas) {
            String[] valores = linha.split(" ");
            int precoVenda = Integer.parseInt(valores[0]);
            int aluguel = Integer.parseInt(valores[1]);
            propriedades.add(new Propriedade(precoVenda, aluguel));
        }
        return propriedades;
    }
}

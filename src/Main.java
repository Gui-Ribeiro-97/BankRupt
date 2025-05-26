//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import game.*;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<Propriedade> propriedades = Configuracao.carregarPropriedades("src/gameConfig.txt");
            Tabuleiro tabuleiro = new Tabuleiro(propriedades);
            List<Jogador> jogadores = new ArrayList<>();

            // Criando os jogadores com diferentes comportamentos
            jogadores.add(new Jogador("Impulsivo", TipoComportamento.IMPULSIVO));
            jogadores.add(new Jogador("Exigente", TipoComportamento.EXIGENTE));
            jogadores.add(new Jogador("Cauteloso", TipoComportamento.CAUTELOSO));
            jogadores.add(new Jogador("Aleatório", TipoComportamento.ALEATORIO));

            // Criando e iniciando o jogo
            Jogo jogo = new Jogo(jogadores, tabuleiro);
            jogo.iniciar();

        } catch (IOException e) {
            System.err.println("Erro ao carregar o arquivo de configuração: " + e.getMessage());
        }
    }
}
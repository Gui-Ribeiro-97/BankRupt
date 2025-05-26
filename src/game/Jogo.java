package game;
import model.Jogador;
import model.Propriedade;
import util.Dado;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Jogo {
    private List<Jogador> jogadores;
    private Tabuleiro tabuleiro;
    private int rodadaAtual;

    public Jogo(List<Jogador> jogadores, Tabuleiro tabuleiro) {
        this.jogadores = jogadores;
        this.tabuleiro = tabuleiro;
        this.rodadaAtual = 0;
        Collections.shuffle(this.jogadores);
    }

    public void iniciar() {
        while (rodadaAtual < 1000 && jogadores.size() > 1) {
            rodadaAtual++;
            for (Jogador jogador : new ArrayList<>(jogadores)) {
                if (jogador.getDinheiro() < 0) {
                    jogadores.remove(jogador);
                    tabuleiro.liberarPropriedades(jogador);
                    continue;
                }

                int movimento = Dado.jogar();
                Propriedade propriedade = tabuleiro.getPropriedade(movimento);

                if (propriedade.getDono() == null && jogador.podeComprar(propriedade)) {
                    jogador.comprarPropriedade(propriedade);
                } else {
                    jogador.pagarAluguel(propriedade);
                }
            }
        }
        declararVencedor();
    }

    private void declararVencedor() {
        System.out.println("O jogo terminou. Vencedor: " + jogadores.get(0).getNome());
    }
}

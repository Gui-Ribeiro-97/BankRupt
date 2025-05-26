package game;
import model.Propriedade;
import model.Jogador;
import java.util.List;

public class Tabuleiro {
    private List<Propriedade> propriedades;

    public Tabuleiro(List<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    public Propriedade getPropriedade(int posicao) {
        return propriedades.get(posicao % propriedades.size());
    }

    public void liberarPropriedades(Jogador jogador) {
        for (Propriedade propriedade : propriedades) {
            if (propriedade.getDono() == jogador) {
                propriedade.setDono(null);
            }
        }
    }
}

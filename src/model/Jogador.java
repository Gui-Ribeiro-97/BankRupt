package model;
import java.util.ArrayList;
import java.util.List;

public class Jogador {
    private String nome;
    private int dinheiro;
    private List<Propriedade> propriedades;
    private TipoComportamento comportamento;

    public Jogador(String nome, TipoComportamento comportamento) {
        this.nome = nome;
        this.dinheiro = 300;
        this.propriedades = new ArrayList<>();
        this.comportamento = comportamento;
    }

    public boolean podeComprar(Propriedade propriedade) {
        return comportamento.deveComprar(propriedade, dinheiro);
    }

    public void comprarPropriedade(Propriedade propriedade) {
        if (podeComprar(propriedade)) {
            dinheiro -= propriedade.getPrecoVenda();
            propriedades.add(propriedade);
            propriedade.setDono(this);
        }
    }

    public void pagarAluguel(Propriedade propriedade) {
        if (propriedade.getDono() != null && propriedade.getDono() != this) {
            int aluguel = propriedade.getAluguel();
            dinheiro -= aluguel;
            propriedade.getDono().dinheiro += aluguel;
        }
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public String getNome() {
        return null;
    }
}
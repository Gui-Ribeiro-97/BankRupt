package model;

public class Propriedade {
    private int precoVenda;
    private int aluguel;
    private Jogador dono;

    public Propriedade(int precoVenda, int aluguel) {
        this.precoVenda = precoVenda;
        this.aluguel = aluguel;
        this.dono = null;
    }

    public int getPrecoVenda() { return precoVenda; }
    public int getAluguel() { return aluguel; }
    public Jogador getDono() { return dono; }

    public void setDono(Jogador dono) {
        this.dono = dono;
    }
}
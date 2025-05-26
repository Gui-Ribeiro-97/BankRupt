package model;

public enum TipoComportamento {
    IMPULSIVO {
        @Override
        public boolean deveComprar(Propriedade propriedade, int dinheiro) {
            return true;
        }
    },
    EXIGENTE {
        @Override
        public boolean deveComprar(Propriedade propriedade, int dinheiro) {
            return propriedade.getAluguel() > 50;
        }
    },
    CAUTELOSO {
        @Override
        public boolean deveComprar(Propriedade propriedade, int dinheiro) {
            return dinheiro - propriedade.getPrecoVenda() >= 80;
        }
    },
    ALEATORIO {
        @Override
        public boolean deveComprar(Propriedade propriedade, int dinheiro) {
            return Math.random() < 0.5;
        }
    };

    public abstract boolean deveComprar(Propriedade propriedade, int dinheiro);
}
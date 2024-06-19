package modelos;

public class Moeda {
    private String moeda;
    private String moedaAlvo;
    private Double taxa;

    public Moeda(MoedaAPI moedaAPI) {
        this.moeda = moedaAPI.base_code();
        this.moedaAlvo = moedaAPI.target_code();
        this.taxa = moedaAPI.conversion_rate();
    }


    public String getMoedaBase() {
        return moeda;
    }

    public String getMoedaAlvo() {
        return moedaAlvo;
    }

    public Double getTaxa() {
        return taxa;
    }

    @Override
    public String toString() {
        return "modelos.Moeda: " + moeda + "---> Cotações: " + taxa;
    }

}

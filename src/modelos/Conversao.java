package modelos;

import com.google.gson.Gson;

import java.io.IOException;

public class Conversao {
    private Moeda moeda;
    private MoedaAPI moedaAPI;
    private double valorBase;
    private double valorFinal;
    private Consulta novaConsulta = new Consulta();
    private Gson gson;


    public void setValorBase(double valorBase) {
        this.valorBase = valorBase;
    }

    public double converteValor(double valorBase, double taxa){
        return this.valorBase * taxa;
    }

    private void consultaMoeda(String moedaBase, String moedaAlvo) throws IOException, InterruptedException {
        this.moedaAPI = novaConsulta.consultaMoeda(moedaBase,moedaAlvo);
        this.moeda = new Moeda(moedaAPI);
        this.valorFinal =  converteValor(valorBase, moeda.getTaxa());
    }

    public void escolhaOpcao(int opcao) throws IOException, InterruptedException {
        switch (opcao){
            case 1:
                consultaMoeda("USD","ARS");
                break;
            case 2:
                consultaMoeda("ARS","USD");
                break;
            case 3:
                consultaMoeda("USD","BRL");
                break;
            case 4:
                consultaMoeda("BRL","USD");
                break;
            case 5:
                consultaMoeda("USD","COP");
                break;
            case 6:
                consultaMoeda("COP","USD");
                break;
            case 7:
                consultaMoeda("USD","CLP");
                break;
            case 8:
                consultaMoeda("CLP","USD");
                break;
            case 9:
                consultaMoeda("USD","EUR");
                break;
            case 10:
                consultaMoeda("EUR","USD");
                break;
            case 11:
                consultaMoeda("EUR","BRL");
                break;
            case 12:
                consultaMoeda("BRL","EUR");
                break;
            default:
                break;
        }
    }

    public void exibeConversao(){
        System.out.println("Valor "+ valorBase + " ["+ moeda.getMoedaBase()+"] " +
                "corresponde ao valor de -----> " + valorFinal + "["+moeda.getMoedaAlvo()+"]");
    }

    @Override
    public String toString() {
        return  "\nmodelos.Moeda base: " + moeda.getMoedaBase() + "\n" +
                "modelos.Moeda alvo: " + moeda.getMoedaAlvo() + "\n" +
                "rating: " + moeda.getTaxa() + "\n" +
                "Valor inicial: "+ valorBase + "\n" +
                "Valor final: "+ valorFinal ;
    }


}

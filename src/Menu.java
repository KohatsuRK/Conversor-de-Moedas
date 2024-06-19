import modelos.Moeda;

public class Menu {
    private String menu = """
            **********************************************************************
            Seja bem-vindo/a ao Conversor de moedas :) \n
            1) Dólar ---> Peso Argentino
            2) Peso Argentino ---> Dólar
            3) Dólar ---> Real Brasileiro
            4) Real Brasileiro ---> Dólar
            5) Dólar ---> Peso Colombiano
            6) Peso Colombiano ---> Dólar
            7) Dólar ---> Peso chileno
            8) Peso chileno ---> Dólar
            9) Dólar ---> Euro
            10) Euro ---> Dólar
            11) Euro ---> Real Brasileiro
            12) Real Brasileiro ---> Euro
            0) Sair
            Escolha uma opção válida: 
            **********************************************************************
            """;
    Moeda moeda;
    public void exibeMenu(){
        System.out.println(menu);
    }

    public void exibeMoeda(){
        System.out.println(moeda);
    }

}

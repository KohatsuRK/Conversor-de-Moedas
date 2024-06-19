import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sin = new Scanner(System.in);
        Consulta novaConsulta = new Consulta();
        Menu menu = new Menu();
        ArrayList<Conversao> listaDeConversoes = new ArrayList<>();

        while (true) {
            menu.exibeMenu();
            int opcao = sin.nextInt();
            if (opcao==0)
                break;
            try {
                System.out.println("Digite o valor que deseja converter: ");
                double valorIncial = sin.nextDouble();
                Conversao conversao = new Conversao();
                conversao.setValorBase(valorIncial);
                conversao.escolhaOpcao(opcao);
                listaDeConversoes.add(conversao);
                conversao.exibeConversao();
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        GeradorDeArquivo gerador = new GeradorDeArquivo();
        gerador.salvaJson(listaDeConversoes);
        gerador.salvaListaConversoes(listaDeConversoes);
        System.out.println("Lista de conversões: " + listaDeConversoes);
    }
}
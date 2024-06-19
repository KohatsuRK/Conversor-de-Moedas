package modelos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class GeradorDeArquivo {
    LocalDateTime date = LocalDateTime.now();
    String dataHoraFormatada = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy-HH:mm:ss"));

    public void salvaJson(ArrayList<Conversao> conversoes) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter arquivoJson = new FileWriter("ListaDeConversoes.json");
        arquivoJson.write(gson.toJson(conversoes.toString()));
        arquivoJson.close();
    }

    String mensagem = """
            ====================================================================
            Aqui está seu recibo com suas trocas! =)
            ____________________________________________________________________
            Horário das conversões: %s
                       
            """.formatted(dataHoraFormatada);

    public void salvaListaConversoes(ArrayList<Conversao> conversoes) throws IOException {
        dataHoraFormatada = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy-HH-mm-ss"));
        FileWriter listaDeConversoes = new FileWriter("ListaDeConversoes"+dataHoraFormatada+".txt");
        listaDeConversoes.write(mensagem);
        listaDeConversoes.write(conversoes.toString().replace("[","").replace("]",""));
        listaDeConversoes.write("\n____________________________________________________________________\n" +
                "BY: Renan Kohatsu :)");
        listaDeConversoes.close();

    }
}

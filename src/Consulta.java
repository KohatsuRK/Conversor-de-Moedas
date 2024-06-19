import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    private MoedaAPI moeda;

    public MoedaAPI consultaMoeda(String nomeMoeda, String moedaAlvo) throws IOException, InterruptedException {
        String endereco = "https://v6.exchangerate-api.com/v6/59c54c7e6977cf7d663f7bbf/pair/" +
                nomeMoeda + "/" + moedaAlvo;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().
                uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        //System.out.println(json);

        return new Gson().fromJson(json,MoedaAPI.class);
    }
}

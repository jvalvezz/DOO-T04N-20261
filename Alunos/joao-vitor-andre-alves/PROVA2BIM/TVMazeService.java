import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TVMazeService {

    public String buscarTexto(String nome) throws Exception {
        // esse trecho vai mudar o input do usuario de 'breaking bad' para
        // 'breaking%20bad' ja que a url da requisicao nao aceita espaco
        // %20 = ' ' em UTF8
        String nomeCodificado = URLEncoder.encode(nome, StandardCharsets.UTF_8);
        // o q= significa query=, ou seja, a query que vai ser buscada no banco de dados
        // das series
        String url = "https://api.tvmaze.com/search/shows?q=" + nomeCodificado;

        HttpClient cliente = HttpClient.newHttpClient();
        HttpRequest requisicao = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> resposta = cliente.send(requisicao, HttpResponse.BodyHandlers.ofString());
        return resposta.body();
    }
}
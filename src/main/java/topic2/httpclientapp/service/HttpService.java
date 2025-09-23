package topic2.httpclientapp.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class HttpService {
    protected static final HttpClient client = HttpClient.newBuilder()
            .connectTimeout(Duration.ofSeconds(5))
            .build();

    protected HttpResponse<String> get(String url)throws Exception{
        HttpRequest req=HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .build();
        HttpResponse<String> resp=client.send(req, HttpResponse.BodyHandlers.ofString());
        if(resp.statusCode()/100!=2){
            throw  new IllegalStateException("Http error "+resp.statusCode()+": "+resp.body());
        }
        return resp;
    }
    protected HttpResponse<String> post(String url, String json)throws Exception{
        HttpRequest req=HttpRequest.newBuilder()
                .uri(URI.create(url))
                .timeout(Duration.ofSeconds(10))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
        HttpResponse<String> resp=client.send(req, HttpResponse.BodyHandlers.ofString());
        if(resp.statusCode()/100!=2){
            throw  new IllegalStateException("Http error "+resp.statusCode()+": "+resp.body());
        }
        return resp;
    }
    protected CompletableFuture<HttpResponse<String>> getAsync(String url) {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .header("Accept", "application/json")
                .build();

        return client.sendAsync(req, HttpResponse.BodyHandlers.ofString())
                .thenApply(resp -> {
                    if (resp.statusCode() / 100 != 2) {
                        throw new IllegalStateException("HTTP " + resp.statusCode() + ": " + resp.body());
                    }
                    return resp;
                });
    }
}

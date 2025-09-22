package topic2;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpDemo {
    public static void main(String[] args) throws  Exception {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/get"))
                .GET().build();

        HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: "+response.statusCode());
        System.out.println("Body: "+response.body());
    }
}

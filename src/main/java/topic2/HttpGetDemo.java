package topic2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpGetDemo {
    public static void main(String[] args) throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request=HttpRequest.newBuilder()
                .uri(new java.net.URI("https://jsonplaceholder.typicode.com/users"))
                .build();

        HttpResponse<String> response
                = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Status: " + response.statusCode());
        System.out.println("Raw JSON: " + response.body().substring(0, 200) + "...");

        ObjectMapper mapper = new ObjectMapper();
        List<User> users=mapper.readValue(response.body(), new TypeReference<List<User>>() {
        });
        System.out.println("\n ===User+++");
        for (User user : users) {
            System.out.println(user);
        }
    }
}

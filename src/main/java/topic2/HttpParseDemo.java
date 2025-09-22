package topic2;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpParseDemo {
    public static void main(String[] args) throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        String json = """
                { "name": "John", "city": "Torun", "age": 30 }
                """;

        HttpRequest request=HttpRequest.newBuilder()
                .uri(URI.create("https://httpbin.org/post"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse <String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("Raw response: "+response.body());

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root=mapper.readTree(response.body());
        JsonNode jsonNode=root.get("json");
        Person person=mapper.treeToValue(jsonNode, Person.class);
        System.out.println("Person: "+person);
        System.out.println("City: "+jsonNode.get("city").asText());
    }
}

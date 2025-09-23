package topic2.httpclientapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import topic2.httpclientapp.model.Post;
import topic2.httpclientapp.model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class PostService extends HttpService{
    private final ObjectMapper mapper = new ObjectMapper();

    public void listPostByUser(int userId){
        try {
            var resp=get("https://jsonplaceholder.typicode.com/posts?userId="+userId);
            List<Post> posts=mapper.readValue(resp.body(), new TypeReference<>(){});
            posts.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
    public void createPost(String title, String body, int userId){
        try {
            String json = mapper.writeValueAsString(Map.of(
                    "title", title,
                    "body", body,
                    "userId", userId
            ));
            var resp=post("https://jsonplaceholder.typicode.com/posts", json);
            System.out.println("Created: "+resp.body());
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
    public void printUsersWithPostCount() {
        try {
            var usersF = getAsync("https://jsonplaceholder.typicode.com/users");
            var postsF = getAsync("https://jsonplaceholder.typicode.com/posts");

            // чекаємо обидва запити
            CompletableFuture.allOf(usersF, postsF).join();

            // парсимо
            List<User> users = mapper.readValue(usersF.get().body(), new TypeReference<>() {});
            List<Post> posts = mapper.readValue(postsF.get().body(), new TypeReference<>() {});

            // порахуємо кількість постів по userId
            Map<Integer, Long> postsByUser = posts.stream()
                    .collect(Collectors.groupingBy(p -> p.userId, Collectors.counting()));

            System.out.println("\n=== Users & post count (async) ===");
            for (User u : users) {
                long cnt = postsByUser.getOrDefault(u.id, 0L);
                String city = (u.address != null ? u.address.city : "-");
                System.out.printf("#%-2d %-22s %-22s posts=%-3d city=%s%n",
                        u.id, u.name, u.email, cnt, city);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

package topic2.httpclientapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import topic2.httpclientapp.model.Post;

import java.util.List;
import java.util.Map;

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
}

package topic2.httpclientapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import topic2.httpclientapp.model.User;

import java.util.List;

public class UserService extends HttpService{
    private final ObjectMapper mapper = new ObjectMapper();

    public void listUser(){
        try {
            var resp=get("https://jsonplaceholder.typicode.com/users");
            List<User> users=mapper.readValue(resp.body(), new TypeReference<>(){});
            users.forEach(System.out::println);
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }
    public void findByEmail(String email){
        try {
            var resp = get("https://jsonplaceholder.typicode.com/users");
            List<User> users = mapper.readValue(resp.body(), new TypeReference<>() {});
            users.stream()
                    .filter(u->u.email.equalsIgnoreCase(email))
                    .findFirst()
                    .ifPresent(System.out::println) ;System.out.println("User found");
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }

}

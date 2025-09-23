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
            System.out.println("\n=== Users ===");
            for(User u:users){
                String city=(u.address!=null?u.address.city:"-");
                System.out.printf("#%-2d %-25s %-25s %-15s%n", u.id, u.name, u.email, city);
            }
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
                    .ifPresent(u -> {
                        String city=(u.address!=null?u.address.city:"-");
                        System.out.println("""
                         Found user:
                         id:    %d
                         name:  %s
                         email: %s
                         city:  %s
                         """.formatted(u.id, u.name, u.email, city));
                    }) ;System.out.println("User found");
        }catch (Exception e){
            System.out.println("Error "+e.getMessage());
        }
    }

}

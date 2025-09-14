package topic1.library.service;

import topic1.library.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
 private List<User> users;

   public UserService() {
      this.users = new ArrayList<>();
   }

   public boolean addUser(User user) {
       if(user.getEmail()!= null&&user.getEmail().contains("@")){
          users.add(user);
           return true;
       }else {
           System.out.println("Invalid email: " + user.getEmail());
           return false;
       }

   }
   public boolean removeUserById(int id) {
       for (int i=0;i<users.size();i++){
           if(users.get(i).getId()==id){
               users.remove(i);
               return true;
           }
       }
       return false;
   }
   public User getUserById(int id) {
       for (User user : users) if(user.getId()==id) return user;
       return null;
   }
   public List<User> listUsers() {
       return users;
   }

}

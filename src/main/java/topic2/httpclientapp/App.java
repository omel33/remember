package topic2.httpclientapp;

import topic2.httpclientapp.service.UserService;
import topic2.httpclientapp.service.PostService;

import java.util.Scanner;

public class App {
    private final UserService userService = new UserService();
    private final PostService postService = new PostService();
    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new App().run();
    }

    public void run() {
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - List users");
            System.out.println("2 - Find user by email");
            System.out.println("3 - List posts by userId");
            System.out.println("4 - Create post");
            System.out.println("0 - Exit");
            System.out.print("Choose: ");
            int cmd = Integer.parseInt(sc.nextLine());

            try {


                switch (cmd) {
                    case 1 -> userService.listUser();
                    case 2 -> {
                        String email = readNonEmpty("Email: ");
                        userService.findByEmail(email);

                    }
                    case 3 -> {
                        int userId = readInt("UserId: ");
                        postService.listPostByUser(userId);
                    }
                    case 4 -> {
                        String title = readNonEmpty("Title: ");
                        String body = readNonEmpty("Body: ");
                        int userId = readInt("UserId (default 1 — просто введи 1): ");
                        postService.createPost(title, body, userId);
                    }
                    case 5 -> postService.printUsersWithPostCount();
                    case 0 -> {
                        System.out.println("Bye!");
                        return;
                    }
                    default -> System.out.println("Unknown");
                }
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
    private int readInt(String prompt){
        while ( true){
            System.out.println( prompt);
            String s=sc.nextLine().trim();
            try {
                return Integer.parseInt(s);

            }catch (NumberFormatException e){
                System.out.println("Будь ласка, введи ціле число. Ти ввів: \"" + s + "\"");
            }
        }
    }
    private String readNonEmpty(String prompt){
        while ( true){
            System.out.println( prompt);
            String s=sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Значення не може бути порожнім.");
        }
    }
}

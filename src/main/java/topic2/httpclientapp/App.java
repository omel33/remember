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

            switch (cmd) {
                case 1 -> userService.listUser();
                case 2 -> {
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    userService.findByEmail(email);
                }
                case 3 -> {
                    System.out.print("UserId: ");
                    int userId = Integer.parseInt(sc.nextLine());
                    postService.listPostByUser(userId);
                }
                case 4 -> {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Body: ");
                    String body = sc.nextLine();
                    postService.createPost(title, body, 1);
                }
                case 0 -> { System.out.println("Bye!"); return; }
                default -> System.out.println("Unknown");
            }
        }
    }
}

package topic1.day10;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class ReadFile {

    public static void main(String[] args)
    {
        Path path = Path.of("data","output.txt");
        System.out.println(path.toAbsolutePath());

        try(BufferedReader r = Files.newBufferedReader(path)) {
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }

        }catch (IOException e){
            System.out.println("Error reading file"+e.getMessage());
        }
        try(Scanner sc = new Scanner(path)) {
            while (sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }

        }catch (IOException e){
            System.out.println("Error reading file"+e.getMessage());
        }
        try {
            List<String> lines=Files.readAllLines(path);
            lines.forEach(System.out::println);
        }catch (IOException e){
            System.out.println("Error reading file"+e.getMessage());
        }

    }
}

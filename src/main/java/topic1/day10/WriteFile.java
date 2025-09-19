package topic1.day10;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;

public class WriteFile {

    public static void main(String[] args) {
        Path path = Path.of("data", "output.txt");
        try {
            Files.createDirectories(path.getParent());
            try (BufferedWriter w = Files.newBufferedWriter(path)) {
                w.write("Hello World");
                w.newLine();
                w.write("This is my first file in Java.");

            }
            System.out.println("File written"+path.toAbsolutePath());

        }catch (IOException e){
            System.out.println("Error writing file"+e.getMessage());
        }

    }

}

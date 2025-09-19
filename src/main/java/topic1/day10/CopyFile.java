package topic1.day10;

import javax.imageio.stream.ImageInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class CopyFile {
    public static void main(String[] args)
    {
        Path source = Path.of("data","output.txt");
        Path destination = Path.of("data","copy_output.txt");

        try{
            copyFile(source,destination);
            System.out.println("File copied successfully"+ destination.toAbsolutePath());

        }catch (IOException e){
            System.out.println("Error copying file"+e.getMessage());
        }
    }
    public static void copyFile(Path source, Path destination)throws IOException
    {
        try(InputStream in=Files.newInputStream(source);
            OutputStream out=Files.newOutputStream(destination)) {
            byte[]buffer= new byte[1024];
            int bytesRead;
            while ((bytesRead=in.read(buffer))!=-1){
                out.write(buffer,0,bytesRead);
            }

        }
    }

}

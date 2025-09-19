package topic1.day10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializeDemo {
    public static void main(String[] args) {
        Persone p=new Persone(1,"Mike");

        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("data/person.dat"))) {
            oos.writeObject(p);
            System.out.println("Serialized");


        }catch (IOException e){
            System.out.println("Error writing file"+e.getMessage());
        }
    }
}

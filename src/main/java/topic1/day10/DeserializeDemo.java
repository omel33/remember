package topic1.day10;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeDemo {
    public static void main(String[] args)
    {
        try(ObjectInputStream ois=new ObjectInputStream(new FileInputStream("data/person.dat"))) {
            Persone p=(Persone)ois.readObject();
            System.out.println(p);
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }

}

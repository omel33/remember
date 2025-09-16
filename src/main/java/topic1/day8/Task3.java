package topic1.day8;

import java.util.HashMap;
import java.util.Map;

public class Task3 {
    public static void main(String[] args)
    {
        Map<String, String> phoneBook=new HashMap<>();
        phoneBook.put("Mike", "123456");
        phoneBook.put("Lika", "654321");
        phoneBook.put("Loka", "654321");
        phoneBook.put("Jin", "654687916212");

        System.out.println(phoneBook);
        System.out.println(phoneBook.get("Mike"));
        phoneBook.remove("Loka");
        System.out.println(phoneBook);

    }
}

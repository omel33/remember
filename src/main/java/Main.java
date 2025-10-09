import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Дається List<String> names.
        // Видаліть першу літеру з кожного імені та поверніть відсортований список

        List<String> names=new ArrayList<>();
        names.add("Ivan");
        names.add("Petro");
        names.add("Oleg");

        for (int i=0; i<names.size(); i++){

            names.set(i, names.get(i).substring(1));

        }
        Collections.sort(names);
        System.out.println(names);
    }

}

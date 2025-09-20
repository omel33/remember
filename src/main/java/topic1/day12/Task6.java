package topic1.day12;

import java.lang.reflect.Method;

public class Task6 {
    public static void main(String[] args) throws Exception
    {
        Example ex = new Example();

        for(Method m: ex.getClass().getDeclaredMethods()){
            if(m.isAnnotationPresent(Run.class)){
                System.out.println(m.getName());
                m.invoke(ex);
            }
        }
    }
}

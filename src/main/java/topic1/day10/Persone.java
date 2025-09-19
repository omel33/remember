package topic1.day10;

import java.io.Serializable;

public class Persone implements Serializable {
    private int id;
    private String name;

    public Persone(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public String toString() {
        return "Persone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

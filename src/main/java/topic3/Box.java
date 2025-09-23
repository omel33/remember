package topic3;

import java.util.Objects;

public class Box <T>{
    private T value;

    public Box() {}

    public Box(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    public static <U> Box<U> of(U value) {
        return new Box<>(value);
    }

    @Override
    public String toString() {
        return "Box[" + String.valueOf(value) + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Box<?> box = (Box<?>) o;
        return Objects.equals(value, box.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}

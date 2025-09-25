package topic3.day14;

public class UserG {
    String name;
    String city;
    int age;

    public UserG(String name,String city, int age) {
        this.name = name;
        this.city = city;
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }
    @Override
    public String toString() {
        return "UserG{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}

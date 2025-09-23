package topic2.httpclientapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    public int id;
    public String name;
    public String username;
    public String email;
    public Address address;      // <-- містить city
    public String phone;
    public String website;
    public Company company;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Address {
        public String street;
        public String suite;
        public String city;
        public String zipcode;
        public Geo geo;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Geo {
        public String lat;
        public String lng;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Company {
        public String name;
        public String catchPhrase;
        public String bs;
    }
    @Override
    public String toString() {
        return "User{id=%d, name='%s', email='%s', city='%s'}"
                .formatted(id, name, email, address != null ? address.city : null);
    }
}

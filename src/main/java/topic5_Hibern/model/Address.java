package topic5_Hibern.model;

import jakarta.persistence.*;

@Embeddable
public class Address {
    @Column(name="addr_country", length=64)
    private String country;
    @Column(name="addr_city", length=64)
    private String city;
    @Column(name="addr_street", length=128)
    private String street;

    public Address() {}
    public Address(String country, String city, String street){
        this.country = country; this.city = city; this.street = street;
    }
    public String getCountry() { return country; }
    public void setCountry(String c) { this.country = c; }
    public String getCity() { return city; }
    public void setCity(String c) { this.city = c; }
    public String getStreet() { return street; }
    public void setStreet(String s) { this.street = s; }
}

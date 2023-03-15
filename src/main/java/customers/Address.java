package customers;

import org.springframework.data.mongodb.core.mapping.Document;


public class Address {
private String street;
private String city;
private int zip;



    public Address(String street, String city, int zip) {
        this.street = street;
        this.city = city;
        this.zip = zip;
    }


    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip=" + zip +
                '}';
    }
}

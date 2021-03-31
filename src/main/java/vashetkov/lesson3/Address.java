package vashetkov.lesson3;

public class Address{
    String city;
    String street;
    String house;
    String flat;

    public Address(String city, String street, String house, String flat) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.flat = flat != null ? flat : "";
    }

    @Override
    public String toString(){
        return city + " " + street + " "+house + " " + flat;
    }
}
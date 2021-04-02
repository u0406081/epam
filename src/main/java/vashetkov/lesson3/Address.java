package vashetkov.lesson3;

public class Address{
    private String city;
    private String street;
    private String house;
    private String flat;

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
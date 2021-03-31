package vashetkov.lesson3;

public class Human {
    String fio;
    Integer age;
    Address address;

    public Human() {
    }

    public Human(String fio, int age, Address address) {
        this.fio = fio;
        this.age = age;
        this.address = address;
    }


    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Human human = (Human) obj;
        boolean b = fio.equals(human.fio);
        return b;
    }
}
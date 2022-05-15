package hu.progmatic.models;

import java.util.Objects;

public class Client {

    private final String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Client(String id) {
        this.id = id;
    }

    public Client(String id, String name, String address, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "***********************************\n" +
                "Azonosító: \t" + id + "\n" +
                "Lakcím: \t" + address + "\n" +
                "Név: \t\t" + name + "\n" +
                "Tel: \t\t" + phoneNumber + "\n" +
                "E-mail: \t" + email + "\n" +
                "***********************************";

    }
}

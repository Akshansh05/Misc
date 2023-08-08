package Immutablity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class Employee {

    private final String name;
    private final int age;
    private final List<String> phoneNumbers;

    private final Address address;

    private final HashMap<String, String> metaData;


    public Employee(String name, int age, List<String> phoneNumbers, Address address, HashMap<String, String> metaData) {
        this.name = name;
        this.age = age;
        this.phoneNumbers = phoneNumbers;
        this.address = address;
        this.metaData = metaData;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<String> getPhoneNumbers() {
        return new ArrayList<>(phoneNumbers);
    }

    public HashMap<String, String> getMetaData() {
        return new HashMap<>(metaData);
    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }
}

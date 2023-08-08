package Immutablity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Address address1 = new Address("s1", "c1");
        List<String> phoneNumbers = new ArrayList<>();
        phoneNumbers.add("123345");
        phoneNumbers.add("456789");
        HashMap<String, String> metadata = new HashMap<>();
        metadata.put("hobby", "Watching Movies");

        Employee e = new Employee("John", 23, phoneNumbers, address1, metadata);

        // modifications
        e.getAddress().setCity("c3");
        e.getAddress().setStreet("s3");
        e.getPhoneNumbers().add("1234");
        e.getMetaData().put("skill", "Java");
        e.getMetaData().put("designation", "HR");

        //still Won't change After Modification

        System.out.println(e.getName());
        System.out.println(e.getAge());
        System.out.println(e.getAddress().getCity());
        System.out.println(e.getAddress().getStreet());
        System.out.println(e.getPhoneNumbers());
        System.out.println(e.getMetaData());
        /*
        Output
        John
        23
        c1
        s1
        [123345, 456789]
        {hobby=Watching Movies}
         */

    }
}

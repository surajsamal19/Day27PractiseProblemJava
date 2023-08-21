import java.util.*;
import java.util.stream.Collectors;

class PersonUC8 {
}

public class AddressBook {
    public List<Person> searchPerson(String name) {
        return entries.stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        AddressBook addressBook1 = new AddressBook();
        AddressBook addressBook2 = new AddressBook();

        addressBook1.addPerson(new Person("John Doe", "New York", "New York"));
        addressBook1.addPerson(new Person("Alice Smith", "San Francisco", "California"));
        addressBook2.addPerson(new Person("Bob Johnson", "Los Angeles", "California"));
        addressBook2.addPerson(new Person("Emma White", "New York", "New York"));

        List<AddressBook> addressBooks = new ArrayList<>();
        addressBooks.add(addressBook1);
        addressBooks.add(addressBook2);

        String searchName = "John Doe";

        System.out.println("Searching for " + searchName + " across address books:");

        List<Person> searchResults = addressBooks.stream()
                .flatMap(addressBook -> addressBook.searchPerson(searchName).stream())
                .collect(Collectors.toList());

        if (searchResults.isEmpty()) {
            System.out.println("No matching persons found.");
        } else {
            System.out.println("Matching persons found:");
            searchResults.forEach(System.out::println);
        }
    }
}






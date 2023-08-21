import java.util.*;
import java.util.stream.Collectors;

class PersonUC11{
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class AddressBook {
    private List<Person> entries = new ArrayList<>();

    public void addPerson(Person person) {
        entries.add(person);
    }

    public void sortByPersonName() {
        entries.sort(Comparator.comparing(Person::getName));
    }

    public void printEntries() {
        entries.forEach(System.out::println);
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        addressBook.addPerson(new Person("John Doe", "123-456-7890"));
        addressBook.addPerson(new Person("Alice Smith", "987-654-3210"));
        addressBook.addPerson(new Person("Bob Johnson", "555-123-4567"));

        System.out.println("Unsorted Entries:");
        addressBook.printEntries();

        System.out.println("\nSorted Entries:");
        addressBook.sortByPersonName();
        addressBook.printEntries();
    }
}






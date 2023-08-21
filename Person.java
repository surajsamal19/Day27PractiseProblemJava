import java.util.*;

class Person {
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
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber;
    }
}

public class AddressBook {
    private Set<Person> entries = new HashSet<>();

    public void addPerson(Person person) {
        entries.add(person);
    }

    public boolean containsPersonWithName(String name) {
        for (Person person : entries) {
            if (person.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public void printEntries() {
        for (Person person : entries) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();

        addressBook.addPerson(new Person("John Doe", "123-456-7890"));
        addressBook.addPerson(new Person("Alice Smith", "987-654-3210"));
        addressBook.addPerson(new Person("Bob Johnson", "555-123-4567"));
        addressBook.addPerson(new Person("John Doe", "111-222-3333")); // Duplicate entry

        System.out.println("Entries:");
        addressBook.printEntries();

        System.out.println("\nChecking for Duplicate Entry (John Doe): " + addressBook.containsPersonWithName("John Doe"));
    }
}







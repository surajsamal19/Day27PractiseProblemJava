import java.util.*;
import java.util.stream.Collectors;

class PersonUC7 {
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
    private List<Person> entries = new ArrayList<>();

    public boolean addPerson(Person person) {
        if (!entries.contains(person)) {
            entries.add(person);
            return true;
        }
        return false;
    }

    public List<Person> getPersonsByName(String name) {
        return entries.stream()
                .filter(person -> person.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
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
        addressBook.addPerson(new



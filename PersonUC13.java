import java.io.*;
import java.util.*;
class PersonUC13{
}
public class AddressBook {
public void writeToFile(String fileName) {
 try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
for (Person person : entries) {
writer.println(person.getName() + "," + person.getPhoneNumber());
}
} 
catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    String phoneNumber = parts[1];
                    addPerson(new Person(name, phoneNumber));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        addressBook.addPerson(new Person("John Doe", "123-456-7890"));
        addressBook.addPerson(new Person("Alice Smith", "987-654-3210"));
        addressBook.addPerson(new Person("Bob Johnson", "555-123-4567"))
        addressBook.writeToFile("addressbook.txt");
        addressBook = new AddressBook();
        addressBook.readFromFile("addressbook.txt")
        System.out.println("Entries read from file:");
        addressBook.printEntries();
    }
}


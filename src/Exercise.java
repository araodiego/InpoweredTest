import com.inpowered.model.AddressBook;
import com.inpowered.model.Contact;
import com.inpowered.model.Gender;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Scanner;

public class Exercise {

    public static void main(String[] args) throws Exception{

        AddressBook addressBook = AddressBook.getInstance();

        Scanner input = new Scanner(Paths.get(Exercise.class.getResource("AddressBook.txt").toURI()));
        input.useDelimiter(",|\n");
        while(input.hasNext()){
            String name = input.next();
            String gender = input.next();
            System.out.println(gender);
            String date  = input.next();

            DateTimeFormatter formatter = new DateTimeFormatterBuilder().appendPattern("dd/MM/")
                    .appendValueReduced(ChronoField.YEAR, 2,2,1900)
                    .toFormatter();

            LocalDate date1 = LocalDate.parse(date.trim(), formatter);

            Contact contact = new Contact(name, gender.trim().equalsIgnoreCase("Male") ? Gender.MALE : Gender.FEMALE, date1);
            addressBook.addContact(contact);
        }

        List<Contact> contacts = addressBook.getByName("Bill McKnight");
        Contact bill = null, paul = null;
        if(contacts!= null){
            bill = contacts.get(0);
        }
        contacts = addressBook.getByName("Paul Robinson");
        if(contacts != null){
            paul = contacts.get(0);
        }
        System.out.println("Days between Bill and Paul = " + AddressBook.getDaysBetween(bill, paul));

        System.out.println("Number of Males on the Address Book = " + addressBook.getNumberOfMales());

        System.out.println("Oldest Person: " + addressBook.getOldestPerson().getName());

    }
}

import java.util.Scanner;
import java.util.ArrayList;
public class ContactList {
    private ArrayList<Person> contacts;
    private final String menuOptions = "Menu: \n" +
            "1. Add Contact\n" +
            "2. List All Contacts By First Name\n" +
            "3. List All Contacts By Last Name\n" +
            "4. List All Contacts By Phone Number\n" +
            "5. List All Students\n" +
            "6. Search by First name\n" +
            "7. Search by Last Name\n" +
            "8. Search by Phone Number\n" +
            "0. Exit";
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    public ArrayList<Person> getContacts() {
        return contacts;
    }

    public void addContact(Person contact) {
        contacts.add(contact);
    }

    public void printContacts() {
        for (Person contact : contacts) {
            System.out.println(contact);
        }
    }

    public void sort(int sortBy) {
        if (sortBy == 0) {
            sortByFirstName();
        }
        else if (sortBy == 1) {
            sortByLastName();
        }
        else if (sortBy == 2) {
            sortByPhoneNumber();
        }
    }

    public void sortByFirstName() {
        for (int i = 0; i < contacts.size(); i++) {
            for (int j = 0; j < contacts.size() - 1; j++) {
                if (contacts.get(j).getFirstName().compareTo(contacts.get(j+1).getFirstName()) > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1,temp);
                }
            }
        }
    }

    public void sortByLastName() {
        for (int i = 0; i < contacts.size(); i++) {
            for (int j = 0; j < contacts.size() - 1; j++) {
                if (contacts.get(j).getLastName().compareTo(contacts.get(j+1).getLastName()) > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1,temp);
                }
            }
        }
    }

    public void sortByPhoneNumber() {
        for (int i = 0; i < contacts.size(); i++) {
            for (int j = 0; j < contacts.size() - 1; j++) {
                if (contacts.get(j).getPhoneNumber().compareTo(contacts.get(j+1).getPhoneNumber()) > 0) {
                    Person temp = contacts.get(j);
                    contacts.set(j, contacts.get(j+1));
                    contacts.set(j+1,temp);
                }
            }
        }
    }

    public Person searchByFirstName(String firstName) {
        for (Person contact : contacts) {
            if (firstName.equals(contact.getFirstName())) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByLastName(String lastName) {
        for (Person contact : contacts) {
            if (lastName.equals(contact.getLastName())) {
                return contact;
            }
        }
        return null;
    }

    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person contact : contacts) {
            if (phoneNumber.equals(contact.getPhoneNumber())) {
                return contact;
            }
        }
        return null;
    }

    public void listStudents() {
        for (Person contact : contacts) {
            if (contact instanceof Student) {
                System.out.println(contact);
            }
        }
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        boolean isRunning = true;
        while (isRunning) {
            System.out.println(menuOptions);
            int usrIn = input.nextInt();
            input.nextLine();

            switch (usrIn) {
                case 1:
                    System.out.println("First Name:");
                    String fName = input.nextLine();
                    System.out.println("Last Name:");
                    String lName = input.nextLine();
                    System.out.println("Phone Number:");
                    String pNum = input.nextLine();

                    System.out.println("Is your contact a student? (y/n)");
                    boolean isStudent = input.nextLine().equals("y");

                    if (isStudent) {
                        System.out.println("Grade: " );
                        int grade = input.nextInt();
                        input.nextLine();
                        this.addContact(new Student(fName, lName, pNum, grade));
                    }
                    else {
                        System.out.println("Is your contact an athlete? (y/n)");
                        boolean isAthlete = input.nextLine().equals("y");
                        if (isAthlete) {
                            System.out.println("Skill level: ");
                            String skillLvl = input.nextLine();
                            this.addContact(new Athlete(fName, lName, pNum, skillLvl));
                        }
                        else {
                            this.addContact(new Person(fName, lName, pNum));
                        }
                    }
                    break;
                case 2:
                    this.sortByFirstName();
                    this.printContacts();
                    break;
                case 3:
                    this.sortByLastName();
                    this.printContacts();
                    break;
                case 4:
                    this.sortByPhoneNumber();
                    this.printContacts();
                    break;
                case 5:
                    this.listStudents();
                    break;
                case 6:
                    System.out.println("First name: ");
                    fName = input.nextLine();
                    Person person = this.searchByFirstName(fName);
                    if (person == null) {
                        System.out.println(fName + " is not in the list.");
                    }
                    else {
                        System.out.println(person);
                    }
                    break;
                case 7:
                    System.out.println("Last name: ");
                    lName = input.nextLine();
                    person = this.searchByLastName(lName);
                    if (person == null) {
                        System.out.println(lName + " is not in the list.");
                    }
                    else {
                        System.out.println(person);
                    }
                    break;
                case 8:
                    System.out.println("Phone Number: ");
                    pNum = input.nextLine();
                    person = this.searchByPhoneNumber(pNum);
                    if (person == null) {
                        System.out.println(pNum + " is not in the list.");
                    }
                    else {
                        System.out.println(person);
                    }
                    break;
                case 0:
                    isRunning = false;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        ContactList list = new ContactList();
        list.run();
    }
}

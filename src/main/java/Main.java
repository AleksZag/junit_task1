import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    static PhoneContacts phoneContacts = new PhoneContacts();


    public static void main(String[] args) {


        contactGroupCreator();

        while (true) {

            System.out.println("\nДля создание нового контактка  нажмите 'Enter', для завеошения операции введите 'нет' )?\n");
            String createContactValidation = scanner.nextLine();

            if (createContactValidation.equals("нет")) {
                break;
            }

            Contacts contact = contactsCreator();
            System.out.println("Укажите группы в которые хотите добавить контакт, через пробел");
            String group = scanner.nextLine();
            String[] groups = group.split(" ");
            phoneContacts.addContactToGroups(contact, groups);

        }

        printPhoneContacts();

    }

    static void contactGroupCreator() {
        while (true) {
            System.out.println("\nСоздание новой группы контактов (введите название или введите 'нет' )?");
            String newContactGroup = scanner.nextLine();
            if (newContactGroup.equals("нет")) {
                break;
            }
            phoneContacts.createGroup(newContactGroup);
        }
    }


    static Contacts contactsCreator() {

        System.out.println("\nвведите Имя:");
        String name = scanner.nextLine();
        System.out.println("\nвведите Фамилию");
        String surname = scanner.nextLine();
        System.out.println("\nвведите номер телефона контакта");
        String phoneNumber = scanner.nextLine();

        return new Contacts(name, surname, phoneNumber);

    }

    static void printPhoneContacts () {
        String[] groupsPrint = phoneContacts.getGroups();
        for(String groups: groupsPrint) {
            System.out.println(groups + ":");
            Contacts[] contacts = phoneContacts.getContacts(groups);
            for(Contacts contact : contacts) {
                System.out.println("\t" + contact.toString());
            }

        }
    }


}

public class Contacts implements Comparable <Contacts> {

    private String name;
    private String surname;
    private String phoneNumber;


    public Contacts(String Name, String Surname, String phoneNumber) {
        this.name = Name;
        this.surname = Surname;
        this.phoneNumber = phoneNumber;

    }

    @Override
    public String toString() {
        return surname + " " + name + " " + phoneNumber;
    }

    @Override
    public int compareTo(Contacts Contact) {
        int result = this.surname.compareTo(Contact.surname);
        if(result == 0) {
            result = this.name.compareTo(Contact.name);

        }
        return result;

    }
}






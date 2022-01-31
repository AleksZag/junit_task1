import java.util.*;


public class PhoneContacts {

    private HashMap<String, ArrayList<Contacts>> phoneContacts = new HashMap<>();

    public PhoneContacts() {
    }

    void createGroup(String newContactGroup) {
        this.phoneContacts.put("контакты без группы", new ArrayList<Contacts>());
        if (!phoneContacts.containsKey(newContactGroup)) {
            this.phoneContacts.put(newContactGroup, new ArrayList<Contacts>());
        }
    }

    void addContactToGroups(Contacts contact, String[] groups) {

        for (String currentGroup : groups) {
            if (!phoneContacts.containsKey(currentGroup)) {
                currentGroup = "контакты без группы";
            }

            ArrayList<Contacts> contactOfGroup = phoneContacts.get(currentGroup);
            contactOfGroup.add(contact);
            Collections.sort(contactOfGroup);
            phoneContacts.put(currentGroup, contactOfGroup);
        }
    }

    String[] getGroups() {
        List <String> groupsList = new ArrayList<> (phoneContacts.keySet());
        Collections.sort(groupsList);
        return groupsList.toArray(new String[groupsList.size()]);
    }


    Contacts[] getContacts(String group) {
        ArrayList<Contacts> contactsList = phoneContacts.get(group);
        Contacts[] contacts = contactsList.toArray(new Contacts[contactsList.size()]);
        return contacts;

    }

    void clearPhoneContacts(){
        phoneContacts.clear();
    }



    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        for (Map.Entry<String, ArrayList<Contacts>> entry : this.phoneContacts.entrySet()) {
            strBuilder.append(entry.getKey());
            strBuilder.append(" :\n");

            for (Contacts contact : entry.getValue()) {
                strBuilder.append("\t");
                strBuilder.append(contact);
                strBuilder.append("\n");
            }
        }

        return strBuilder.toString();
    }


}

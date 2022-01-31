import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class PhoneContactsTest {

    private static PhoneContacts testPhoneContacts = new PhoneContacts();

    @BeforeEach
    void initTest() {
        System.out.println("test start");
        testPhoneContacts.clearPhoneContacts();
    }


    @Test
    void testCreateSomeGroup() {

        // given
        String[] groupOfContacts = {"контакты без группы", "тестовая группа",};
        //when
        testPhoneContacts.createGroup("тестовая группа");
        //then
        Assertions.assertArrayEquals(groupOfContacts, testPhoneContacts.getGroups());

    }

    @ParameterizedTest
    @MethodSource("contactsForTest")
    void testAddSomeContactToGroupsParam(Contacts testContact) {

        // given
        Contacts[] contactList = {testContact};
        String[] groups = {"тестовая группа"};
        testPhoneContacts.createGroup("тестовая группа");

        //when
        testPhoneContacts.addContactToGroups(testContact, groups);

        //then
        Assertions.assertArrayEquals(contactList, testPhoneContacts.getContacts("тестовая группа"));

    }

    static Stream<Contacts> contactsForTest() {
        return Stream.of(new Contacts("Иван", "Иванов", "+79485685625"),
                new Contacts("Петр", "Петров", "+79485688526"),
                new Contacts("Сергей", "Сергеев", "+79445687645"));
    }


    @Test
    void testGetContacts() {
        // given
        Contacts contact = new Contacts("Иван", "Иванов", "+79485685625");
        testPhoneContacts.createGroup("тестовая группа");
        testPhoneContacts.addContactToGroups(contact, new String[]{"тестовая группа"});

        //when
        Contacts[] contacts = testPhoneContacts.getContacts("тестовая группа");

        //then
        Assertions.assertNotNull(contacts[0]);
        Assertions.assertEquals(contact, contacts[0]);

    }

    @AfterEach
    void finalizeTest() {
        System.out.println("Test complete");
    }


}
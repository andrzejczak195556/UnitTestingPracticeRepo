/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fax;

import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.*;


/**
 *
 * @author miszel
 */
public class PhoneBookTest {
   private PhoneBook phonebook;
   private final static String INVALID_NUMBER_FORMAT="48-12345675115151";
    private final static String VALID_NUMBER_FORMAT="48-1234567";
    private final static String VALID_CONTACT_NAME = "ValidContactName";
    
    @Before
    public void setUp()
    {
        phonebook = new PhoneBookFromTextFiles();
    }
    
    @Test(expected = InValidNumberFormatException.class)
    public void tryAddingInvalidPhoneNumber() throws InValidNumberFormatException, ContactNotFoundException {
        phonebook.addNewContact("TestName", INVALID_NUMBER_FORMAT);
        
    }
    
    @Test
    public void addNewPhoneNumber() throws InValidNumberFormatException, ContactNotFoundException {
        phonebook = new PhoneBookFromTextFiles(new MyTextFileHandler());
        phonebook.addNewContact("ContactName", VALID_NUMBER_FORMAT);

        assertThat(new File("ContactName.txt").exists()).isTrue();

    }
    @Test
    public void checkIfNewContactNumberWasSavedProperly() throws InValidNumberFormatException, IOException, ContactNotFoundException {
        phonebook = new PhoneBookFromTextFiles(new MyTextFileHandler());
        phonebook.addNewContact(VALID_CONTACT_NAME, VALID_NUMBER_FORMAT);

        assertThat(readContactFileContents(VALID_CONTACT_NAME+".txt")).isEqualTo(VALID_NUMBER_FORMAT);

    }
    private String readContactFileContents(String fileName) throws IOException {
        FileReader reader = null;
        reader= new FileReader(new File(fileName));
        BufferedReader bufferedReader = new BufferedReader(reader);
        String tmp = bufferedReader.readLine();

        return tmp;
    }




    
}

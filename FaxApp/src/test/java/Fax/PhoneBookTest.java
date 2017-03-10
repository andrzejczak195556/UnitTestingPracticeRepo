/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fax;

import org.junit.Before;
import org.junit.Test;



/**
 *
 * @author miszel
 */
public class PhoneBookTest {
   private PhoneBook phonebook;
   private final static String INVALID_NUMBER_FORMAT="48-12345675115151";
    private final static String VALID_NUMBER_FORMAT="48-1234567";
    
    @Before
    public void setUp()
    {
        phonebook = new PhoneBookFromTextFiles();
    }
    
    @Test(expected = InValidNumberFormatException.class)
    public void tryAddingInvalidPhoneNumber() throws InValidNumberFormatException
    {
        phonebook.addNewContact("TestName", INVALID_NUMBER_FORMAT);
        
    }
    
    @Test
    public void addNewPhoneNumber() throws InValidNumberFormatException
    {
        phonebook.addNewContact("TestName", VALID_NUMBER_FORMAT);
    }
    
}

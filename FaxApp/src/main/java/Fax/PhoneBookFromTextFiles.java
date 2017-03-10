/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fax;


public class PhoneBookFromTextFiles implements PhoneBook {

    public String getPhoneNumber(String contactName) {
        return null;
    }

    public void addNewContact(String contactName, String phoneNemuber) throws InValidNumberFormatException {
        if(!validateNumber(phoneNemuber))
        {
            throw new InValidNumberFormatException();
        }
    }
    private boolean validateNumber(String phoneNumber)
    {
       return phoneNumber.matches("\\d{2}-\\d{7}");
    }
    
    
}

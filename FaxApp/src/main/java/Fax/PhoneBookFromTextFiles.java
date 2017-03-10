/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fax;


import java.io.IOException;

public class PhoneBookFromTextFiles implements PhoneBook {

    private MyFileHandler fileWriter;

    public PhoneBookFromTextFiles() {
    }

    public PhoneBookFromTextFiles(MyFileHandler fileWriter) {
        this.fileWriter = fileWriter;
    }

    public String getPhoneNumber(String contactName) throws ContactNotFoundException {
        String number;
        try {
            number = fileWriter.readFile(contactName);
        } catch (IOException e) {
            throw new ContactNotFoundException("Contact wasn't found");
        }
        return number;
    }

    public void addNewContact(String contactName, String phoneNumber) throws InValidNumberFormatException{
        if(!validateNumber(phoneNumber))
        {
            throw new InValidNumberFormatException();
        }
        try {
            fileWriter.writeFile(contactName+".txt",phoneNumber);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    private boolean validateNumber(String phoneNumber)
    {
       return phoneNumber.matches("\\d{2}-\\d{7}");
    }



}

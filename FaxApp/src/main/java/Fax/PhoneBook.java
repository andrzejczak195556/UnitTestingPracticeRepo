/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fax;

/**
 *
 * @author miszel
 */
public interface PhoneBook {
    String getPhoneNumber(String contactName) throws ContactNotFoundException;
    void addNewContact(String contactName, String phoneNemuber) throws InValidNumberFormatException;
    
}

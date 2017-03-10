package Fax;

import javafx.beans.InvalidationListener;

import java.util.Observable;

/**
 * Created by user on 10.03.2017.
 */
public class FaxSenderImpl extends Observable implements FaxSender {
    private PhoneBook phoneBook;


    public FaxSenderImpl(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public void sendFax(String faxContents, String addresseeContactName) throws ContactNotFoundException {

        Message<String> textMessage = new TextMessage(phoneBook.getPhoneNumber(addresseeContactName), faxContents);
        setChanged();
        notifyObservers(textMessage);
    }

}

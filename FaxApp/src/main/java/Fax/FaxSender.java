package Fax;

import javafx.beans.Observable;

/**
 * Created by user on 10.03.2017.
 */
public interface FaxSender {
    void sendFax(String faxContents, String addresseeContactName) throws ContactNotFoundException;
}

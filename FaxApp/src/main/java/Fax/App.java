package Fax;

import java.util.Observable;
import java.util.Observer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        PhoneBook book = new PhoneBookFromTextFiles(new MyTextFileHandler());
        try {
            book.addNewContact("Mr T","12-3214512");
        } catch (InValidNumberFormatException e) {
            e.printStackTrace();
        }
        FaxSenderImpl faxSender = new FaxSenderImpl(book);

        faxSender.addObserver(new Observer() {
            public void update(Observable o, Object arg) {
                System.out.println(arg.toString());
            }
        });

        try {
            faxSender.sendFax("Hello everyone","Mr T");
        } catch (ContactNotFoundException e) {
            e.printStackTrace();
        }
    }
}

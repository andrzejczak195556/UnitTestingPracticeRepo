package Fax;

import org.junit.Before;
import org.junit.Test;


import java.util.Observable;
import java.util.Observer;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by user on 10.03.2017.
 */
public class FaxSenderTests {

    private static final String VALID_CONTACT_NAME ="TestName" ;
    private static final java.lang.String VALID_NUMBER ="11-1234556" ;
    private FaxSender faxSender ;
    private PhoneBook phoneBook = mock(PhoneBookFromTextFiles.class);

    private final static String FAX_SAMPLE_CONTENT = "SampleContent";
    private final static String INVALID_CONTACT_NAME ="wrongName";
    @Before
    public void setUp()
    {
        faxSender = new FaxSenderImpl(phoneBook);
    }

    @Test(expected = ContactNotFoundException.class)
    public void contactWasNotFound() throws ContactNotFoundException {

        when(phoneBook.getPhoneNumber(INVALID_CONTACT_NAME)).thenThrow(ContactNotFoundException.class);

        faxSender.sendFax(FAX_SAMPLE_CONTENT,INVALID_CONTACT_NAME);

    }
    @Test
    public void checkIfMessageWasSent() throws ContactNotFoundException {
        when(phoneBook.getPhoneNumber(VALID_CONTACT_NAME)).thenReturn(VALID_NUMBER);

        faxSender.sendFax(FAX_SAMPLE_CONTENT,VALID_CONTACT_NAME);

    }



}

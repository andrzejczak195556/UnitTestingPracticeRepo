package Fax;

import org.junit.Before;
import org.junit.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by user on 10.03.2017.
 */
public class FaxSenderTests {

    private FaxSender faxSender ;
    private PhoneBook phoneBook = mock(PhoneBook.class);

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



}

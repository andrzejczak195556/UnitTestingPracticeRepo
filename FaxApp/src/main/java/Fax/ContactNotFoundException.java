package Fax;

/**
 * Created by user on 10.03.2017.
 */
public class ContactNotFoundException extends Throwable {
    private String msg;
    public ContactNotFoundException(String message) {
        this.msg = message;
    }
    @Override
    public String getMessage() {
        return msg;
    }
}

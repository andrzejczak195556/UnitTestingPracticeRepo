package Fax;

/**
 * Created by user on 10.03.2017.
 */
public interface Message<T> {
    T setMessageContent();
    T setMessageRecipient();
}

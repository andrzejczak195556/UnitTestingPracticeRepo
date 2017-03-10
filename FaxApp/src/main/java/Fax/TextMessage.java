package Fax;

/**
 * Created by user on 10.03.2017.
 */
public class TextMessage<String> implements Message<String> {
    private String messageRecipient;
    private String messageContent;

    public TextMessage(String messageRecipient, String messageContent) {
        this.messageRecipient = messageRecipient;
        this.messageContent = messageContent;
    }

    public String setMessageContent() {
        return this.messageContent;
    }

    public String setMessageRecipient() {
        return this.messageRecipient;
    }

    @Override
    public java.lang.String toString()
    {
        return ("Message addressed to : "+messageRecipient+"\n"+"Content :"+"\n"+messageContent);
    }

}

package projet.spring3.javaconfig;

public class StandardOutMessageRenderer implements MessageRenderer{
    private MessageProvider messageProv = null;

    public void render() {
        if (messageProv == null) {
            throw new RuntimeException(
                    "You must set the property messageProvider of class:"
                            + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(messageProv.getMessage());
    }

    public void setMessageProv(MessageProvider provider){
        this.messageProv = provider;
    }

    public MessageProvider getMessageProv() {
        return this.messageProv;
    }
}

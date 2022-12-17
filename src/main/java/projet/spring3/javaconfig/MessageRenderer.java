package projet.spring3.javaconfig;

public interface MessageRenderer {
    public void render();

    public void setMessageProv(MessageProvider provider);

    public MessageProvider getMessageProv();
}

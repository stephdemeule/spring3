package projet.spring3;

public interface ArtworkSender {
    public void sendArtwork(String artworkPath, Recipient recipient);

    public String getFriendlyName();

    public String getShortName();

}

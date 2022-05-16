package Model;

public class Notification {
    private StringBuilder stringBuilder;
    
    public Notification() {
        this.stringBuilder = new StringBuilder();
    }

    public void resetNotification() {
        this.stringBuilder = new StringBuilder();
    }

    public String getNotification() {
        return stringBuilder.toString();
    }

    public void updateNotification(String input) {
        this.stringBuilder.append(input + "\n");
    }
}

package osoby;

public class Client {
    private int clientId;
    private String name;

    public Client(int clientId, String name) {
        this.clientId = clientId;
        this.name = name;
    }

    public int getId() {
        return clientId;
    }

    public String getName() {
        return name;
    }
}

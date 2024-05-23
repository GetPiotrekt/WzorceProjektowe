package wzorceProjektowe;

import osoby.Client;
import java.util.HashMap;
import java.util.Map;

public class DatabaseManagerSingleton {
    private static DatabaseManagerSingleton instance;
    private Map<Integer, Client> clientsDatabase;

    private DatabaseManagerSingleton() {
        clientsDatabase = new HashMap<>();
    }
    public static synchronized DatabaseManagerSingleton getInstance() {
        if (instance == null) {
            instance = new DatabaseManagerSingleton();
        }
        return instance;
    }
    public Client getClientData(int clientId) {
        return clientsDatabase.get(clientId);
    }
    public void addOrUpdateClient(Client client) {
        clientsDatabase.put(client.getId(), client);
    }
}

package wzorceProjektowe;

import osoby.Client;

public class GymClientProxy extends Client {
    private DatabaseManagerSingleton databaseManager;
    public GymClientProxy(int clientId, String name) {
        super(clientId, name);
        this.databaseManager = DatabaseManagerSingleton.getInstance();
        databaseManager.addOrUpdateClient(this);
    }

    @Override
    public String getName() {
        return super.getName();
    }
}

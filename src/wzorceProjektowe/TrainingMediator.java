package wzorceProjektowe;

import osoby.Client;
import osoby.Trainer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingMediator {
    private Map<Integer, Client> clients;
    private Map<Integer, Trainer> trainers;

    public TrainingMediator() {
        this.clients = new HashMap<>();
        this.trainers = new HashMap<>();
    }

    public void addClient(Client client) {
        clients.put(client.getId(), client);
    }

    public void addTrainer(Trainer trainer) {
        trainers.put(trainer.getId(), trainer);
    }

    public void scheduleTraining(int clientId, int trainerId, String trainingType) {
        Client client = clients.get(clientId);
        Trainer trainer = trainers.get(trainerId);
        if (client != null && trainer != null) {
            System.out.println("Zaplanowano trening " + trainingType + " dla " + client.getName() + " z trenerem " + trainer.getName());
        } else {
            System.out.println("Nie można zaplanować treningu - niepoprawny klient lub trener.");
        }
    }

    public int getClientsCount() {
        return clients.size();
    }

    public int getTrainersCount() {
        return trainers.size();
    }

    public Client getClient(int clientId) {
        return clients.get(clientId);
    }

    public Trainer getTrainer(int trainerId) {
        return trainers.get(trainerId);
    }

    public List<Client> getClients() {
        return new ArrayList<>(clients.values());
    }

    public List<Trainer> getTrainers() {
        return new ArrayList<>(trainers.values());
    }
}

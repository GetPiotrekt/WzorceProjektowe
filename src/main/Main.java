package main;

import osoby.Client;
import osoby.Trainer;
import rodzajeTreningow.CardioTraining;
import rodzajeTreningow.StrengthTraining;
import wzorceProjektowe.GymClientProxy;
import wzorceProjektowe.TrainingMediator;
import wzorceProjektowe.TrainingTemplate;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrainingMediator mediator = new TrainingMediator();

        mediator.addClient(new GymClientProxy(1, "Jan Kowalski"));
        mediator.addClient(new GymClientProxy(2, "Anna Nowak"));
        mediator.addClient(new GymClientProxy(3, "Adam Wiśniewski"));

        mediator.addTrainer(new Trainer(1, "Maria Nowak"));
        mediator.addTrainer(new Trainer(2, "Piotr Kowalczyk"));
        mediator.addTrainer(new Trainer(3, "Magdalena Wojciechowska"));

        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Dodaj nowego klienta");
            System.out.println("2. Dodaj nowego trenera");
            System.out.println("3. Zaplanuj trening");
            System.out.println("4. Wyświetl listę klientów");
            System.out.println("5. Wyświetl listę trenerów");
            System.out.println("6. Wyjdź");
            System.out.print("Wybierz opcję: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("\nPodaj imię klienta: ");
                    String clientName = scanner.nextLine();
                    int newClientId = mediator.getClientsCount() + 1;
                    Client newClient = new GymClientProxy(newClientId, clientName);
                    mediator.addClient(newClient);
                    System.out.println("\nDodano nowego klienta: " + newClient.getName());
                    break;

                case 2:
                    System.out.print("\nPodaj imię trenera: ");
                    String trainerName = scanner.nextLine();
                    Trainer newTrainer = new Trainer(mediator.getTrainersCount() + 1, trainerName);
                    mediator.addTrainer(newTrainer);
                    System.out.println("\nDodano nowego trenera: " + newTrainer.getName());
                    break;

                case 3:
                    System.out.println("\nWybierz rodzaj treningu:");
                    System.out.println("1. Trening siłowy");
                    System.out.println("2. Trening cardio");
                    System.out.print("Wybierz opcję: ");
                    int trainingChoice = scanner.nextInt();
                    scanner.nextLine();

                    if (trainingChoice != 1 && trainingChoice != 2) {
                        System.out.println("\nNieprawidłowy rodzaj treningu. Spróbuj ponownie.");
                        break;
                    }

                    String trainingType = trainingChoice == 1 ? "siłowy" : "cardio";

                    System.out.println("\nLista klientów:");
                    if (mediator.getClients().isEmpty()) {
                        System.out.println("Lista klientów jest pusta.");
                    } else {
                        for (Client client : mediator.getClients()) {
                            System.out.println(client.getId() + ". " + client.getName());
                        }
                    }

                    System.out.print("Podaj id klienta: ");
                    int clientId = scanner.nextInt();
                    scanner.nextLine();

                    if (mediator.getClient(clientId) == null) {
                        System.out.println("\nKlient o podanym ID nie istnieje. Spróbuj ponownie");
                        break;
                    }

                    System.out.println("\nLista trenerów:");
                    for (Trainer trainer : mediator.getTrainers()) {
                        System.out.println(trainer.getId() + ". " + trainer.getName());
                    }

                    System.out.print("Podaj id trenera: ");
                    int trainerId = scanner.nextInt();
                    scanner.nextLine();

                    if (mediator.getTrainer(trainerId) == null) {
                        System.out.println("\nTrener o podanym ID nie istnieje. Spróbuj ponownie");
                        break;
                    }

                    TrainingTemplate training;
                    if (trainingType.equals("siłowy")) {
                        training = new StrengthTraining();
                    } else {
                        training = new CardioTraining();
                    }
                    mediator.scheduleTraining(clientId, trainerId, trainingType);
                    training.conductTraining(mediator.getClient(clientId), mediator.getTrainer(trainerId));
                    break;

                case 4:
                    System.out.println("\nLista klientów:");
                    if (mediator.getClients().isEmpty()) {
                        System.out.println("Lista klientów jest pusta.");
                    } else {
                        for (Client client : mediator.getClients()) {
                            System.out.println(client.getId() + ". " + client.getName());
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nLista trenerów:");
                    if (mediator.getTrainers().isEmpty()) {
                        System.out.println("Lista trenerów jest pusta.");
                    } else {
                        for (Trainer trainer : mediator.getTrainers()) {
                            System.out.println(trainer.getId() + ". " + trainer.getName());
                        }
                    }
                    break;

                case 6:
                    exit = true;
                    System.out.println("Zamykanie programu...");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór! Wybierz opcję z menu.");
            }
        }
        scanner.close();
    }
}

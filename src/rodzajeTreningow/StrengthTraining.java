package rodzajeTreningow;

import osoby.Client;
import wzorceProjektowe.TrainingTemplate;

public class StrengthTraining extends TrainingTemplate {
    @Override
    protected void greetClient(Client client) {
        System.out.println("Witaj " + client.getName() + ", rozpoczynamy trening siłowy!");
    }

    @Override
    protected void warmUp() {
        System.out.println("Rozgrzewka: Bieżnia + 10 minut roweru stacjonarnego.");
    }

    @Override
    protected void performMainWorkout() {
        System.out.println("Główna część treningu: Seria ćwiczeń na maszynach siłowych.");
    }

    @Override
    protected void coolDown() {
        System.out.println("Schładzanie: Stretching i krótki odpoczynek.");
    }

    @Override
    protected void sayGoodbye(Client client) {
        System.out.println("Do zobaczenia następnym razem, " + client.getName() + "!");
    }
}

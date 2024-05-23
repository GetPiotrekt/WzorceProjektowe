package rodzajeTreningow;

import osoby.Client;
import wzorceProjektowe.TrainingTemplate;

public class CardioTraining extends TrainingTemplate {
    @Override
    protected void greetClient(Client client) {
        System.out.println("Cześć " + client.getName() + ", rozpoczynamy trening cardio!");
    }

    @Override
    protected void warmUp() {
        System.out.println("Rozgrzewka: 20 minut biegu na bieżni.");
    }

    @Override
    protected void performMainWorkout() {
        System.out.println("Główna część treningu: 40 minut jazdy na rowerze.");
    }

    @Override
    protected void coolDown() {
        System.out.println("Schładzanie: Spokojny spacer i rozciąganie.");
    }

    @Override
    protected void sayGoodbye(Client client) {
        System.out.println("Dobrze trenowaliśmy, " + client.getName() + "! Do zobaczenia!");
    }
}

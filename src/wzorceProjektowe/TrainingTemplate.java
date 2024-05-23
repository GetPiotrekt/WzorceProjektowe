package wzorceProjektowe;

import osoby.Client;
import osoby.Trainer;

public abstract class TrainingTemplate {
    public final void conductTraining(Client client, Trainer trainer) {
        greetClient(client);
        warmUp();
        performMainWorkout();
        coolDown();
        sayGoodbye(client);
    }

    protected abstract void greetClient(Client client);
    protected abstract void warmUp();
    protected abstract void performMainWorkout();
    protected abstract void coolDown();
    protected abstract void sayGoodbye(Client client);
}

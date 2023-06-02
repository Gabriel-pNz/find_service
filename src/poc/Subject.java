package poc;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    private List<Observer> observers;

    public void addObserver(Observer observer) {
        if (observers == null) {
            observers = new ArrayList<>();
        }

        observers.add(observer);
    }

    public void notificarAll(boolean disabled) {
        for (Observer observer: observers) {
            observer.notificar(disabled);
        }
    }
}

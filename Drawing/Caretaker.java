package Drawing;

import java.util.*;

public class Caretaker {
    List<Command> mementos;

    //Add a command to the memento list
    public void giveMemento(Command newMemento) {
        mementos.add(newMemento);
    }

    //Retrieve and remove most recent command
    public Command getMemento() {
        Command recentMemento = mementos.get(mementos.size() - 1);
        mementos.remove(mementos.size() - 1);

        return recentMemento;
    }
}

package Drawing;

public class Undo implements Command {
    public final String commandType = "Undo";
    private Caretaker caretaker;
    
    //Get most recent command and call the command's undo function
    public void execute() {
        Command toUndo = caretaker.getMemento();
        toUndo.undo();
    }

    public void undo() {

    }

    public Undo(Caretaker memento) {
        caretaker = memento;
    }
    
}

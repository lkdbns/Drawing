package Drawing;

public class SceneController {
    int selectedShape = -1;

    public void callCommand(Command toDo, Caretaker caretaker) {
        toDo.execute();
        //The commands Undo, Draw, and Draw scene do not get added to the caretaker
        if(!(toDo.commandType.equals("Undo") || toDo.commandType.equals("Draw") || toDo.commandType.equals("DrawScene"))) {
            caretaker.giveMemento(toDo);
        }
    }
}

package Drawing;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Initialize the scene
        Scene scene = new Scene();
        scene.population = new ArrayList<Shape>();
        //Initialize the caretaker
        Caretaker caretaker = new Caretaker();
        caretaker.mementos = new ArrayList<Command>();
        //Fill command list
        CreateCommands setup = new CreateCommands(scene, caretaker);
        List<Command> commands = setup.readInFile("InputSet1.txt");
        SceneController commandOperator = new SceneController();

        //Loop through list of commands and execute
        for (int i = 0; i < commands.size(); i++) {
            commandOperator.callCommand(commands.get(i), caretaker);
        }
    }
}

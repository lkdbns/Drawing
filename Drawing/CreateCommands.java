package Drawing;

import java.io.*;
import java.util.*;

public class CreateCommands {
    private Scene scene;
    private Caretaker caretaker;

    public List<Command> readInFile(String fileName) {
        List<Command> commands = new ArrayList<Command>();

        try {
            File commandFile = new File(fileName);
            Scanner commandScanner = new Scanner(commandFile);
            
            //For each line of input convert it into the correct command
            while(commandScanner.hasNextLine()) {
                commands.add(stringToCommand(commandScanner.nextLine()));
            }
            
            commandScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }


        return commands;
    }

    //Check the type of command then create command based on the type of command
    private Command stringToCommand(String rawCommand) {
        Command newCommand = null;
        //Split raw input into array of strings that can be used in a way similar to arguments
        String tokens[] = rawCommand.split(" ");

        if(tokens[0].equals("CREATE")) {
            if(tokens[1].equals("RECTANGLE")) {
                newCommand = new CreateRectangle(scene, Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]));
            }
            else if(tokens[1].equals("CIRCLE")) {
                newCommand = new CreateCircle(scene, Integer.parseInt(tokens[2]));
            }
        }
        else if(tokens[0].equals("SELECT")) {
            newCommand = new Select(scene, Integer.parseInt(tokens[1]));
        }
        else if(tokens[0].equals("MOVE")) {
            int[] coordinates = {Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2])};
            newCommand = new Move(scene, coordinates);
        }
        else if(tokens[0].equals("COLOR")) {
            newCommand = new Color(scene, tokens[1]);
        }
        else if(tokens[0].equals("DELETE")) {
            newCommand = new Delete(scene);
        }
        else if(tokens[0].equals("DRAW")) {
            newCommand = new Draw(scene);
        }
        else if(tokens[0].equals("DRAWSCENE")) {
            newCommand = new DrawScene(scene);
        }
        else if(tokens[0].equals("UNDO")) {
            newCommand = new Undo(caretaker);
        }

        return newCommand;
    }

    public CreateCommands(Scene scene, Caretaker caretaker) {
        this.scene = scene;
        this.caretaker = caretaker;
    }
}

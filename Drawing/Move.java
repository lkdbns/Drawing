package Drawing;

public class Move implements Command {
    public final String commandType = "Move";
    private Strategy moveShape = new Strategy();
    public Scene scene;
    public int[] coordinates;
    private int[] prevCoord;

    public void execute() {
        prevCoord = moveShape.move(scene, coordinates[0], coordinates[1]);
    }

    public void undo() {
        moveShape.move(scene, prevCoord[0], prevCoord[1]);
    }

    public Move(Scene scene, int[] coordinates) {
        this.scene = scene;
        this.coordinates = coordinates;
    }
}
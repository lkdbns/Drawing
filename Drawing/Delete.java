package Drawing;

public class Delete implements Command {
    public final String commandType = "Delete";
    private Strategy deleteShape = new Strategy();
    public Scene scene;
    private Shape deletedShape;
    private int deletedIndex;

    public void execute() {
        deletedIndex = scene.selectedShape;
        deletedShape = deleteShape.delete(scene);
    }

    public void undo() {
        scene.population.add(deletedIndex, deletedShape);
    }

    public Delete(Scene scene) {
        this.scene = scene;
    }
}
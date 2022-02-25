package Drawing;

public class CreateRectangle implements Command {
    public final String commandType = "CreateRectangle";
    private Strategy rectangle = new Strategy();
    public Scene scene;
    public int width;
    public int height;

    public void execute() {
        rectangle.createRectangle(scene, width, height);
    }

    public void undo() {
        scene.population.remove(scene.population.size() - 1);

    }

    public CreateRectangle(Scene scene, int width, int height) {
        this.scene = scene;
        this.width = width;
        this.height = height;
    }
}

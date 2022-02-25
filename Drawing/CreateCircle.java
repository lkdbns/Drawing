package Drawing;

public class CreateCircle implements Command {
    public final String commandType = "CreateCircle";
    private Strategy circle = new Strategy();
    public Scene scene;
    public int radius;

    public void execute() {
        circle.createCircle(scene, radius);
    }

    public void undo() {
        scene.population.remove(scene.population.size() - 1);
    }

    public CreateCircle(Scene scene, int radius) {
        this.scene = scene;
        this.radius = radius;
    }
}
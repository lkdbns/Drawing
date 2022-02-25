package Drawing;

public class Draw implements Command {
    public final String commandType = "Draw";
    private Strategy drawShape = new Strategy();
    public Scene scene;

    public void execute() {
        drawShape.draw(scene);
    }

    public void undo() {

    }

    public Draw(Scene scene) {
        this.scene = scene;
    }
}
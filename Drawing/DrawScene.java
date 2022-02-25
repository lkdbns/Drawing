package Drawing;

public class DrawScene implements Command {
    public final String commandType = "DrawScene";
    private Strategy drawAll = new Strategy();
    public Scene scene;

    public void execute() {
        drawAll.drawScene(scene);
    }

    public void undo() {

    }

    public DrawScene(Scene scene) {
        this.scene = scene;
    }
}
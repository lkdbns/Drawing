package Drawing;

public class Color implements Command {
    public final String commandType = "Color";
    private Strategy colorShape = new Strategy();
    public Scene scene;
    public String shapeColor;
    private String prevColor;


    public void execute() {
        prevColor = colorShape.color(scene, shapeColor);
    }
    
    public void undo() {
        colorShape.color(scene, prevColor);
    }

    public Color(Scene scene, String shapeColor) {
        this.scene = scene;
        this.shapeColor = shapeColor;
    }
}
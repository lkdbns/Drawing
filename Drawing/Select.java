package Drawing;

public class Select implements Command{
    public final String commandType = "Select";
    private Strategy selectShape = new Strategy();
    public Scene scene;
    public int toSelect;
    private int prevSelected;

    public void execute() {
        prevSelected = selectShape.select(scene, toSelect);
    }

    public void undo() {
        selectShape.select(scene, prevSelected);
    }

    public Select(Scene scene, int toSelect) {
        this.scene = scene;
        this.toSelect = toSelect;
    }
}

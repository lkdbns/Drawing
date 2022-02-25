package Drawing;
public interface Command {
    public String commandType = "";

    public void execute();
    public void undo();
}

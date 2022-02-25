package Drawing;

public class Shape {
    String type;
    String color;
    int xOrigin;
    int yOrigin;
    int width;
    int height;

    public Shape(String type, String color, int x, int y, int width, int height) {
        this.type = type;
        this.color = color;
        xOrigin = x;
        yOrigin = y;
        this.width = width;
        this.height = height;
    }
    public Shape(String type, String color, int x, int y, int radius) {
        this.type = type;
        this.color = color;
        xOrigin = x;
        yOrigin = y;
        width = radius;
    }
}

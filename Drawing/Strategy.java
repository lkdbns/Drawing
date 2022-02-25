package Drawing;

public class Strategy {
    //Create a basic rectangle shape and add it to the scene
    public void createRectangle(Scene scene, int width, int height) {
        Shape newShape = new Shape("Rectangle", "Red", 0, 0, width, height);
        scene.population.add(newShape);
    }

    //Create a basic circle shape and add it to the scene
    public void createCircle(Scene scene, int radius) {
        Shape newShape = new Shape("Circle", "Blue", 0, 0, radius);
        scene.population.add(newShape);
    }

    //If the inputed select is valid change the scene's selected shape and return the previous select value for undo method
    public int select(Scene scene, int toSelect) {
        int prevSelected = scene.selectedShape;

        if(scene.population.size() >= toSelect) {
            scene.selectedShape = toSelect - 1;
        }
        else {
            System.out.println("ERROR: invalid shape for SELECT");
        }

        return prevSelected;
    }

    //Change selected shape coordinate values and return previous position coordinates
    public int[] move(Scene scene, int x, int y) {
        int[] prevCoord = {scene.population.get(scene.selectedShape).xOrigin, scene.population.get(scene.selectedShape).yOrigin};

        scene.population.get(scene.selectedShape).xOrigin = x;
        scene.population.get(scene.selectedShape).yOrigin = y;

        return prevCoord;
    }

    //Change shape color value and return the previous color
    public String color(Scene scene, String shapeColor) {
        String prevColor = scene.population.get(scene.selectedShape).color;

        scene.population.get(scene.selectedShape).color = shapeColor;

        return prevColor;
    }

    //Remove selected shape from scene and return the shape that was deleted
    public Shape delete(Scene scene) {
        Shape deletedShape = scene.population.get(scene.selectedShape);
        scene.population.remove(scene.selectedShape);

        return deletedShape;
    }

    //Print the selected shape's info
    public void draw(Scene scene) {
        Shape shape = scene.population.get(scene.selectedShape);
        if (shape.type == "Rectangle") { 
            System.out.println(shape.type + ", Color: " + shape.color + ", Origin: (" + shape.xOrigin + "," + shape.yOrigin + ") Width: " + shape.width + ", Height: " + shape.height);
        }
        else if (shape.type == "Circle") {
            System.out.println(shape.type + ", Color: " + shape.color + ", Origin: (" + shape.xOrigin + "," + shape.yOrigin + ") Radius: " + shape.width);
        }
    }

    //Print info of all shapes in the scene
    public void drawScene(Scene scene) {
        for (int i = 0; i < scene.population.size(); i++) {
            Shape shape = scene.population.get(i);
            if (shape.type == "Rectangle") { 
                System.out.println(shape.type + ", Color: " + shape.color + ", Origin: (" + shape.xOrigin + "," + shape.yOrigin + ") Width: " + shape.width + ", Height: " + shape.height);
            }
            else if (shape.type == "Circle") {
                System.out.println(shape.type + ", Color: " + shape.color + ", Origin: (" + shape.xOrigin + "," + shape.yOrigin + ") Radius: " + shape.width);
            }
        }
    }
}

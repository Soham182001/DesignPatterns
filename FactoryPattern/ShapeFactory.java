package FactoryPattern;

public class ShapeFactory {
    Shape getShape(String shapeType) {
        switch (shapeType){
            case "CIRCLE":
                return new Circle();
            case "RECTANGLE":
                return new Rectangle();
            default:
                return null;
        }
    }
}

package FactoryPattern;

public class Main {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shapeObj = shapeFactory.getShape("CIRCLE");
        shapeObj.draw();
    }
}

package cz.naentou.patterns.decorator;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class BorderShapeDecorator extends ShapeDecorator {
    public BorderShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw(){
        decoratedShape.draw();
        setBorderColor("blue");
        setBorderSize(15);
    }

    private void setBorderColor(String color) {
        System.out.println("Border color: " + color);
    }

    private void setBorderSize(int size) {
        System.out.println("Border size: " + size);
    }
}

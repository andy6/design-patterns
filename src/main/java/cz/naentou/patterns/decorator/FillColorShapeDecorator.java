package cz.naentou.patterns.decorator;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class FillColorShapeDecorator extends ShapeDecorator {
    public FillColorShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw(){
        decoratedShape.draw();
        setFillColor("red");
    }

    private void setFillColor(String color) {
        System.out.println("Fill color: " + color);
    }
}

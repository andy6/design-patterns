package cz.naentou.patterns.decorator;

import org.junit.jupiter.api.Test;

/**
 * Creating and testing a Decorator Design Pattern.
 *
 * @author Andy <borec(at)naentou.cz>
 */
public class DecoratorTest {

    @Test
    public void givenCircle_whenDrawIt_thenItDrawn() {
        Shape circle = new Circle();
        circle.draw();
    }

    @Test
    public void givenRectangle_whenUseFillColorDecorator_thenItDrawnColoredShape() {
        Shape rectangle = new Rectangle();
        FillColorShapeDecorator coloredRectangle = new FillColorShapeDecorator(rectangle);
        coloredRectangle.draw();
    }

    @Test
    public void givenSquare_whenUseBorderDecorator_thenItDrawnBorderedShape() {
        Shape square = new Square();
        BorderShapeDecorator borderedSquare = new BorderShapeDecorator(square);
        borderedSquare.draw();
    }
}

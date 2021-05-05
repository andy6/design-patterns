package cz.naentou.patterns.decorator;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing rectangle...");
    }
}

package cz.naentou.patterns.decorator;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing circle...");
    }
}

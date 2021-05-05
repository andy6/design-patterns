package cz.naentou.patterns.decorator;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing square...");
    }
}

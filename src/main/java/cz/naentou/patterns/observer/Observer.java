package cz.naentou.patterns.observer;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public abstract class Observer {

    protected Subject subject;

    public abstract void update();
}

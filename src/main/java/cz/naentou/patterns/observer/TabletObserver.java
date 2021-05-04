package cz.naentou.patterns.observer;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class TabletObserver extends Observer {

    public TabletObserver(Subject subject) {
        this.subject = subject;
        this.subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Tablet was updated.");
    }
}

package cz.naentou.patterns.observer;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class ComputerObserver extends Observer {

    public ComputerObserver(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Computer was updated.");
    }
}

package cz.naentou.patterns.observer;

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

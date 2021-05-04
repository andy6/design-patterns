package cz.naentou.patterns.observer;

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

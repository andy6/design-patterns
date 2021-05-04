package cz.naentou.patterns.observer;

public class MobilePhoneObserver extends Observer {

    public MobilePhoneObserver(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void update() {
        System.out.println("Mobile phone was updated.");
    }
}

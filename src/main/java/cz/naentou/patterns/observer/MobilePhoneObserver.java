package cz.naentou.patterns.observer;

/**
 * @author Andy <borec(at)naentou.cz>
 */
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

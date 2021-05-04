package cz.naentou.patterns.observer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Creating and testing an Observer Design Pattern.
 *
 * @author Andy <borec(at)naentou.cz>
 */
public class ObserverTest {

    private Subject subject;
    private Observer computerObserver;
    private Observer mobilePhoneObserver;
    private Observer tabletObserver;

    @BeforeEach
    void setUp() {
        this.subject = new Subject();
        this.computerObserver = new ComputerObserver(subject);
        this.mobilePhoneObserver = new MobilePhoneObserver(subject);
        this.tabletObserver = new TabletObserver(subject);
    }

    @Test
    public void givenObservers_whenNotifyAll_thenAllObserversWereNotified() {
        int messageCount = subject.notifyAllObservers();
        assertEquals(3, messageCount);
    }

    @Test
    public void givenObservers_whenUnregisterOneOfThem_thenUnregistredObserverDoesNotNotified() {
        subject.unregister(mobilePhoneObserver);

        int logoutCount = subject.notifyAllObservers();
        assertEquals(2, logoutCount);
    }
}

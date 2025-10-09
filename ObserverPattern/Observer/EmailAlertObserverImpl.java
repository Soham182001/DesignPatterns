package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservable;

public class EmailAlertObserverImpl  implements NotificationAlertObserver {

    String emailId;
    StocksObservable iphoneObservable;

    public EmailAlertObserverImpl(String emailId, StocksObservable iphoneObservable) {
        this.emailId = emailId;
        this.iphoneObservable = iphoneObservable;
    }

    @Override
    public void update() {
        System.out.println("Email Alert: Item is back in stock! Hurry up to place your order -> "+this.emailId);
    }
    
}

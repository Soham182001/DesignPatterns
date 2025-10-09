package ObserverPattern.Observer;

import ObserverPattern.Observable.StocksObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String userName;
    StocksObservable iphoneObservable;

    public MobileAlertObserverImpl(String userName, StocksObservable iphoneObservable) {
        this.userName = userName;
        this.iphoneObservable = iphoneObservable;
    }

    @Override
    public void update() {
        System.out.println("Mobile Alert: Item is back in stock! Hurry up to place your order -> "+this.userName);
    }
    
}

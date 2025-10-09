package ObserverPattern;

import ObserverPattern.Observable.IphoneObservableImpl;
import ObserverPattern.Observable.StocksObservable;
import ObserverPattern.Observer.EmailAlertObserverImpl;
import ObserverPattern.Observer.MobileAlertObserverImpl;
import ObserverPattern.Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StocksObservable iphoneObservable = new IphoneObservableImpl();
        
        NotificationAlertObserver ob1 = new MobileAlertObserverImpl("Ganesh", iphoneObservable);
        NotificationAlertObserver ob2 = new MobileAlertObserverImpl("Soham", iphoneObservable);
        NotificationAlertObserver ob3 = new EmailAlertObserverImpl("sohammedewar@gmail.com", iphoneObservable);
 

        iphoneObservable.add(ob1);
        iphoneObservable.add(ob2);
        iphoneObservable.add(ob3);

        iphoneObservable.setStockCount(10);

    }    
}

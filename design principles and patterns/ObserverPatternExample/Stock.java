package ObserverPatternExample;
import java.util.*;

// Subject interface
interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers();
}

// Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(); // use class-level field
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(price); // use class-level price
        }
    }
}

// Observer interface
interface Observer {
    void update(double price);
}

// Concrete Observers
class MobileApp implements Observer {
    public void update(double price) {
        System.out.println("MobileApp: Stock price updated to " + price);
    }
}

class WebApp implements Observer {
    public void update(double price) {
        System.out.println("WebApp: Stock price updated to " + price);
    }
}

// Test class
class Test {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile = new MobileApp();
        Observer web = new WebApp();

        market.register(mobile);
        market.register(web);

        market.setPrice(1200.0);
        market.setPrice(1250.0);

        market.deregister(web);
        market.setPrice(1300.0);
    }
}


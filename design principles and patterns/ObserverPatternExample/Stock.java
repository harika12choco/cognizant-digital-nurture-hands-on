package ObserverPatternExample;
import java.util.*;

interface Stock {
    void register(Observer o);
    void deregister(Observer o);
    void notifyObservers(double price);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private double price;

    public void setPrice(double price) {
        this.price = price;
        notifyObservers(price);
    }

    public void register(Observer o) {
        observers.add(o);
    }

    public void deregister(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(double price) {
        for (Observer o : observers) {
            o.update(price);
        }
    }
}

interface Observer {
    void update(double price);
}

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

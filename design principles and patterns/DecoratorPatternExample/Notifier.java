package DecoratorPatternExample;

interface Notifier {
    void send(String message);
}

class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    public void send(String message) {
        wrappee.send(message);
    }
}

class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrappee) {
        super(wrappee);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("SMS sent: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrappee) {
        super(wrappee);
    }

    public void send(String message) {
        super.send(message);
        System.out.println("Slack message sent: " + message);
    }
}

class Test {
    public static void main(String[] args) {
        Notifier notifier = new SlackNotifierDecorator(
                                new SMSNotifierDecorator(
                                    new EmailNotifier()
                                ));
        notifier.send("System Alert: Server Down!");
    }
}


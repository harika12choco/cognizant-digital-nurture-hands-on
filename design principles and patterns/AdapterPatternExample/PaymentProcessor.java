package AdapterPatternExample;
public interface PaymentProcessor {
    void processPayment(double amount);
}

class googlepe {
    public void googlepay(double amount) {
        System.out.println("Paid " + amount + " using Google Pay");
    }
}

class phonepe {
    public void phonepay(double amount) {
        System.out.println("Paid " + amount + " using PhonePe.");
    }
}

class googlepeAdapter implements PaymentProcessor {
    private googlepe gpay;

    public googlepeAdapter(googlepe gpay) {
        this.gpay = gpay;
    }

    public void processPayment(double amount) {
        gpay.googlepay(amount);
    }
}

class phonepeAdapter implements PaymentProcessor {
    private phonepe ppe;

    public phonepeAdapter(phonepe ppe) {
        this.ppe = ppe;
    }

    public void processPayment(double amount) {
        ppe.phonepay(amount);
    }
}

class Test {
    public static void main(String[] args) {
        googlepe gpay = new googlepe();
        phonepe ppe = new phonepe();

        PaymentProcessor googlePayProcessor = new googlepeAdapter(gpay);
        PaymentProcessor phonePeProcessor = new phonepeAdapter(ppe);

        googlePayProcessor.processPayment(1000.0);
        phonePeProcessor.processPayment(2500.0);
    }
}

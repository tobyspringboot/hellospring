package tobyspring.hellospring;

public class PaymentService {
    public Payment prepare() {
        return new Payment();
    }

    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.prepare();
        System.out.println(payment);
    }
}

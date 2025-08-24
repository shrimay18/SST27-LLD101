public class OrderService {
    private final NotificationService notificationService;

    public OrderService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    void checkout(String customerEmail, double subtotal) {
        TotalWithTax totalWithTax = new TotalWithTax(subtotal, 0.18);
        double total = totalWithTax.totalWithTax();
        notificationService.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}
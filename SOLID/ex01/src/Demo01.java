

public class Demo01 {
    public static void main(String[] args) {       
        NotificationService notificationService = new EmailClient();

        OrderService orderService = new OrderService(notificationService);

        orderService.checkout("test@example.com", 100.0);
    }
}

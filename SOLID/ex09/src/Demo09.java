public class Demo09 {
    public static void main(String[] args) {
        OrderRepository sqlRepo = new SqlOrderRepository();
        OrderController controller = new OrderController(sqlRepo);

        controller.create("ORD-1");
    }
}


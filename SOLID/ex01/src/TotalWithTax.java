public class TotalWithTax {
    double taxRate;
    double subtotal;
    public TotalWithTax(double subtotal, double taxRate) {
        this.taxRate = taxRate;
        this.subtotal = subtotal;
    }
    double totalWithTax() {
        return this.subtotal + this.subtotal * this.taxRate;
    }
}

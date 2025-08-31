public class Overnight extends Shipment {
    Overnight(double w){ super(w); }
    double getcost(){ return 100 + 20*weightKg; }    
}

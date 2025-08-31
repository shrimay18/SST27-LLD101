public class Standard extends Shipment {
    Standard(double w){ super(w); }
    double getcost(){ return 20 + 5*weightKg; }
    
}

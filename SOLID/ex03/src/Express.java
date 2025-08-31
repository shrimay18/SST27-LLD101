public class Express extends Shipment {
    Express(double w){ super(w); }
    double getcost(){ return 50 + 10*weightKg; }
    
}

package entity;

public class Bed {
    private int Bed_ID;
    private boolean With_Ventilator;
    
    public Bed(int Bed_ID, boolean With_Ventilator) {
        this.With_Ventilator = With_Ventilator;
        this.Bed_ID = Bed_ID;
    }
    
    public int getBed_ID() {
    return Bed_ID;
}
    public boolean getWith_Ventilator() {
        return With_Ventilator;
    }
    
}

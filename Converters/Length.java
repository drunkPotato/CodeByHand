public class Length {

    private final double meter;

    public Length(double meter){
        this.meter = meter;
    }

    public static Length fromMeter(double meter){
        return new Length(meter);
    }

    public static Length fromCm(double cm){
        return new Length(cm * 0.01);
    }

    public static Length fromMile(double mile){
        return new Length(mile * 1609.34); 
    }

    public static Length fromYard(double yard){
        return new Length(yard * 0.9144);
    }

    public static Length fromFoot(double foot){
        return new Length(foot * 0.3048);
    }

    public static Length fromInch(double inch){
        return new Length(inch * 0.0254);
    }

    public double toMile(){
        return meter / 1609.34;
    }

    public double toYard(){
        return meter / 0.9144;
    }

    public double toFoot(){
        return meter / 0.3048;
    }

    public double toInch(){
        return meter / 0.0254;
    }

    public double toMeter(){
        return meter;
    }

    public double toCm(){
        return meter / 0.01;
    }
}

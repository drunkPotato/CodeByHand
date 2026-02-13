public class Weight {
    private final double kg;

    public Weight(double kg){
        this.kg = kg;
    }

    public static Weight fromKg(double kg){
        return new Weight(kg);
    }

    public static Weight fromTons(double tons){
        return new Weight(tons * 1000);
    }

    public static Weight fromGrams(double grams){
        return new Weight(grams / 1000);
    }

    public static Weight fromOunce(double ounce){
        return new Weight(ounce / 35.2734);
    }

    public static Weight fromPound(double pound){
        return new Weight(pound / 2.2046);
    }

    public static Weight fromStone(double stone){
        return new Weight(stone * 6.35);
    }

    public double toKg(){
        return kg;
    }
    
    public double toTons(){
        return kg / 1000;
    }

    public double toGrams(){
        return kg * 1000;
    }

    public double toOunce(){
        return kg * 35.2734;
    }

    public double toPound(){
        return kg * 2.2046;
    }

    public double toStone(){
        return kg / 6.35;
    }
}

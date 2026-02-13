public class Volume {
    private final double liter;

    public Volume(double liter){
        this.liter = liter;
    }

    public static Volume fromLiter(double liter){
        return new Volume(liter);
    }

    public static Volume fromMilliliter(double milliliter){
        return new Volume(milliliter * 0.001);
    }

    public static Volume fromGallon(double gallon){
        return new Volume(gallon * 4.54609);
    }

    public static Volume fromQuart(double quart){
        return new Volume(quart * 1.13652);
    }

    public static Volume fromPint(double pint){
        return new Volume(pint * 0.568261);
    }

    public static Volume fromCup(double cup){
        return new Volume(cup * 0.284130625);
    }

    public static Volume fromFluidounce(double fluidounce){
        return new Volume(fluidounce * 0.0284130625);
    }

    public double toLiter(){
        return liter;
    }

    public double toMilliliter(){
        return liter / 0.001;
    }

    public double toGallon(){
        return liter /  4.54609;
    }
    
    public double toQuart(){
        return liter / 1.13652;
    }

    public double toPint(){
        return liter / 0.568261;
    }

    public double toCup(){
        return liter / 0.284130625;
    }

    public double toFluidounce(){
        return liter / 0.0284130625;
    }
}

public class Currency{

    public final double USD;

    private Currency(double USD){
        this.USD = USD;
    }
    
    public static Currency fromUSD(double USD){
        return new Currency(USD);
    }

    public static Currency fromEUR(double EUR){
        return new Currency(EUR * 1.18); 
    }

    public static Currency fromGBP(double GBP){
        return new Currency(GBP * 1.36); 
    }

    public static Currency fromJPY(double JPY){
        return new Currency(JPY * 0.0064); 
    }

    public static Currency fromCAD(double CAD){
        return new Currency(CAD * 0.73); 
    }

    public double toEUR(){
        return USD / 1.18; 
    }

    public double toGBP(){
        return USD / 1.36; 
    }
    
    public double toJPY(){
        return USD / 0.0064; 
    }

    public double toCAD(){
        return USD / 0.73;
    }

    public double toUSD(){
        return USD;
    }
}
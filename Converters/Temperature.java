public class Temperature {

    private final double kelvin;

    private Temperature (double kelvin){
        if(kelvin < 0){
            throw new IllegalArgumentException("Temperature below 0 Kelvin not allowed");
        }
        this.kelvin = kelvin;
    }

    public static Temperature fromCelsius(double celsius){
        return new Temperature(celsius + 273.15);
    }

    public static Temperature fromFahreinheit(double fahreinheit){
        return new Temperature((fahreinheit - 32) * 5 / 9 + 273.15);
    }
    public static Temperature fromKelvin(double kelvin){
        return new Temperature(kelvin);
    }

    public double toCelsius(){
        return kelvin - 273.15;
    }

    public double toFahreinheit(){
        return (kelvin - 273.15) * 9 / 5 + 32;
    }

    public double tokelvin(){
        return kelvin;
    }

    @Override 
    public String toString() {
        return kelvin + " K";
    }
}

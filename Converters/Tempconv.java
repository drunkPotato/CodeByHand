import java.util.Scanner;

public class Tempconv{

    public static void main(String[] args){
        Scanner myscanner = new Scanner(System.in);

        /* prompt to get the type of temperature we have now */
        System.out.println("Choose between Celsius, Fahreinheit and Kelvin");
        System.out.println("Enter either C, F or K");
        
        /* get a valid input for temperature type */
        String input = myscanner.nextLine();
        input = input.toLowerCase();

        while(!input.equals("c") && 
                !input.equals("f") && 
                !input.equals("k")){
            System.out.println("Please choose a temperature type by writing either C, F or K");
            input = myscanner.nextLine().toLowerCase();
        }
        
        /* get a valid input for the output temperature type*/
        System.out.println("Chose which type you want to convert to");

        String output = myscanner.nextLine();
        output = output.toLowerCase();
        
        while(!output.equals("c") && 
                !output.equals("f") && 
                !output.equals("k")){
            System.out.println("Please choose a temperature type by writing either C, F or K");
            output = myscanner.nextLine().toLowerCase();
        }

        /* get a valid input for the input value */
        System.out.println("Please enter the value of your input temperature");

        double tempvalue = myscanner.nextDouble();
        
        while((input.equals("c") && tempvalue < -273.15) || 
            (input.equals("k") && tempvalue < 0) || 
            (input.equals("f") && tempvalue < -459.67) || 
            tempvalue > 10000000) {
            System.out.println("Please enter a valid value for your input temperature");
            tempvalue = myscanner.nextDouble();
        }

        /* actually convert now */

        if(input.equals(output)){
            System.out.println("Your converted value is: " + tempvalue); 
            myscanner.close();
            return;
        }

        Temperature mytemp;

        if(input.equals("c")){
            mytemp = Temperature.fromCelsius(tempvalue);
        } else if (input.equals("f")){
            mytemp = Temperature.fromFahreinheit(tempvalue);
        } else {
            mytemp = Temperature.fromKelvin(tempvalue);
        }

        double result;

        if(output.equals("c")){
            result = mytemp.toCelsius();
        } else if (output.equals("f")) {
            result = mytemp.toFahreinheit();
        } else {
            result = mytemp.tokelvin();
        }

        System.out.println("Your converted value is " + result);
        myscanner.close();
    }
}
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CurrencyConverter{

    public static void main(String[] args){
        
        Scanner myscanner = new Scanner(System.in);

        List<String> currencies = new ArrayList<String>();
        currencies.add("usd");
        currencies.add("eur");
        currencies.add("gbp");
        currencies.add("jpy");
        currencies.add("cad");
 
        /* Get input currency type */
        System.out.println("Enter your currency (Options: USD, EUR, GBP, JPY, CAD)");
        String input = myscanner.nextLine().toLowerCase();


        while(!currencies.contains(input)){
            System.out.println("Please enter a valid option (USD, EUR, GBP, JPY, CAD) for your currency");
            input = myscanner.nextLine().toLowerCase();
        }

        /* Get output currency type */
        System.out.println("Enter the currency you want to convert to");
        String output = myscanner.nextLine().toLowerCase();

        while(!currencies.contains(output)){
            System.out.println("Please enter a valid option (USD, EUR, GBP, JPY, CAD) for your currency");
            output = myscanner.nextLine().toLowerCase();
        }
        /* Get amount of input currency */
        System.out.println("Enter the amount of the input currency");
        double amount = myscanner.nextDouble();

        while(amount < 0){
            System.out.println("enter a positive amount");
            amount = myscanner.nextDouble();
        }

        /* Do the calculations and output */

        if(input.equals(output)){
            System.out.println("Your converted value is: " + input); 
            myscanner.close();
            return;
        }
        
        
        Currency curr;

        switch (input) {
            case "usd":
                curr = Currency.fromUSD(amount);
                break;
            case "eur":
                curr = Currency.fromEUR(amount);
                break;
            case "gbp":
                curr = Currency.fromGBP(amount);
                break;
            case "jpy":
                curr = Currency.fromJPY(amount);
                break;
            case "cad":
                curr = Currency.fromCAD(amount);
                break;
            
            default:
                curr = Currency.fromUSD(0);
                break;
        }

        double result;
        switch (output) {
            case "usd":
                result = curr.toUSD();
                break;
            case "eur":
                result = curr.toEUR();
                break;
            case "gbp":
                result = curr.toGBP();
                break;
            case "jpy":
                result = curr.toJPY();
                break;
            case "cad":
                result = curr.toCAD();
                break;
            default:
                result = curr.toUSD();
                break;
        }

        myscanner.close();
        System.out.println("The converted amount is " + result);
    }
}
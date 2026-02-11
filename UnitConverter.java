import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnitConverter {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        List<String> lengths = new ArrayList<String>();
        List<String> weights = new ArrayList<String>();
        List<String> volumes = new ArrayList<String>();


        Collections.addAll(lengths, "meter", "mile", "yard", "foot", "cm", "inch");
        Collections.addAll(weights, "kg", "ton", "gram", "ounce", "pound", "stone");
        Collections.addAll(volumes, "liter", "milliliter", "gallon", "quart", "pint", "cup", "fluidounce");


        System.out.println("To quit enter quit otherwise enter either Length, Volume or Weight");
        String input = myScanner.nextLine().toLowerCase();
        
        while(!input.equals("quit")){
            // Handle Lenghts
            if(input.equals("length")){
                String inputlength = "";
                while(!lengths.contains(inputlength)){
                    System.out.println("please choose the unit you want to convert from in this list");
                    for(int i = 0; i < lengths.size(); i++){
                        System.out.print(lengths.get(i) + ",  ");
                    }
                    System.out.println("");
                    inputlength = myScanner.nextLine().toLowerCase();
                }

                String outputlength = "";
                while(!lengths.contains(outputlength)){
                    System.out.println("please choose the unit you want to convert from in this list");
                    for(int i = 0; i < lengths.size(); i++){
                        System.out.print(lengths.get(i) + ",  ");
                    }
                    System.out.println("");
                    outputlength = myScanner.nextLine().toLowerCase();
                }

                double lengthamount = -1;
                while(lengthamount < 0){
                    System.out.println("please chose a positive amount of input length");
                    lengthamount = myScanner.nextDouble();
                    myScanner.nextLine();
                }

                Length length;
                switch (inputlength) {
                    case "meter":
                        length = Length.fromMeter(lengthamount);
                        break;
                    case "mile":
                        length = Length.fromMile(lengthamount);
                        break;
                    case "yard":
                        length = Length.fromYard(lengthamount);
                        break;
                    case "foot":
                        length = Length.fromFoot(lengthamount);
                        break;
                    case "cm":
                        length = Length.fromCm(lengthamount);
                        break;
                    case "inch":
                        length = Length.fromInch(lengthamount);
                        break;
                    default:
                        length = Length.fromMeter(lengthamount);
                        break;
                }

                double result;
                switch (outputlength) {
                    case "meter":
                        result = length.toMeter();
                        break;
                    case "mile":
                        result = length.toMile();
                        break;
                    case "yard":
                        result = length.toYard();
                        break;
                    case "foot":
                        result = length.toFoot();
                        break;
                    case "cm":
                        result = length.toCm();
                        break;
                    case "inch":
                        result = length.toInch();
                        break;
                    default:
                        result = length.toMeter();
                        break;
                }        
                System.out.println(lengthamount +  " " + inputlength + " is " + result + " " + outputlength);
            }

            // Handle Volumes
            else if(input.equals("volume")){
                String inputvolume = "";
                while(!volumes.contains(inputvolume)){
                    System.out.println("Please enter a volume to convert from in this list");
                    for(int i = 0; i < volumes.size(); i++){
                        System.out.print(volumes.get(i) + ",  ");
                    }
                    System.out.println("");
                    inputvolume = myScanner.nextLine().toLowerCase();
                }

                String outputvolume = "";
                while(!volumes.contains(outputvolume)){
                    System.out.println("Please enter a volume to convert to in this list");
                    for(int i = 0; i < volumes.size(); i++){
                        System.out.print(volumes.get(i) + ",  ");
                    }
                    System.out.println("");
                    outputvolume = myScanner.nextLine();
                }

                double inputamount = -1;
                while(inputamount < 0){
                    System.out.println("Please enter a positive volume amount");
                    inputamount = myScanner.nextDouble();
                    myScanner.nextLine();
                }
                
                Volume volume;
                switch (inputvolume) {
                    case "liter":
                        volume = Volume.fromLiter(inputamount);
                        break;
                    case "milliliter":
                        volume = Volume.fromMilliliter(inputamount);
                        break;
                    case "gallon":
                        volume = Volume.fromGallon(inputamount);
                        break;
                    case "quart":
                        volume = Volume.fromQuart(inputamount);
                        break;
                    case "pint":
                        volume = Volume.fromPint(inputamount);
                        break;
                    case "cup":
                        volume = Volume.fromCup(inputamount);
                        break;
                    case "fluidounce":
                        volume = Volume.fromFluidounce(inputamount);
                        break;
                    default:
                        volume = Volume.fromLiter(inputamount);
                        break;
                }

                double result;

                switch (outputvolume) {
                    case "liter":
                        result = volume.toLiter();
                        break;
                    case "milliliter":
                        result = volume.toMilliliter();
                        break;
                    case "gallon":
                        result = volume.toGallon();
                        break;
                    case "quart":
                        result = volume.toQuart();
                        break;
                    case "pint":
                        result = volume.toPint();
                        break;
                    case "cup":
                        result = volume.toCup();
                        break;
                    case "fluidounce":
                        result = volume.toFluidounce();
                        break;
                    default:
                        result = volume.toLiter();
                        break;
                }

                System.out.println(inputamount +  " " + inputvolume + " is " + result + " " + outputvolume);
            }
            
            // Handle Weights 
            else if(input.equals("weight")){
                String inputweight = "";
                while(!weights.contains(inputweight)){
                    System.out.println("Please enter a weight to convert from in this list");
                    for(int i = 0; i < weights.size(); i++){
                        System.out.print(weights.get(i) + ",  ");
                    }
                    System.out.println("");
                    inputweight = myScanner.nextLine().toLowerCase();
                }

                String outputweight = "";
                while(!weights.contains(outputweight)){
                    System.out.println("Please enter a weight to convert to in this list");
                    for(int i = 0; i < weights.size(); i++){
                        System.out.print(weights.get(i) + ",  ");
                    }
                    System.out.println("");
                    outputweight = myScanner.nextLine().toLowerCase();
                }

                double inputamount = -1;
                while(inputamount < 0){
                    System.out.println("Please enter a positive input amount");
                    inputamount = myScanner.nextDouble();
                    myScanner.nextLine();
                }

                Weight weight;

                switch(inputweight){
                    case "kg":
                        weight = Weight.fromKg(inputamount);
                        break;
                    case "ton":
                        weight = Weight.fromTons(inputamount);
                        break;
                    case "gram":
                        weight = Weight.fromGrams(inputamount);
                        break;
                    case "ounce":
                        weight = Weight.fromOunce(inputamount);
                        break;
                    case "pound":
                        weight = Weight.fromPound(inputamount);
                        break;
                    case "stone":
                        weight = Weight.fromStone(inputamount);
                        break;
                    default:
                        weight = Weight.fromKg(inputamount);
                        break;
                }

                double result;
                switch(outputweight){
                    case "kg":
                        result = weight.toKg();
                        break;
                    case "ton":
                        result = weight.toTons();
                        break;
                    case "gram":
                        result = weight.toGrams();
                        break;
                    case "ounce":
                        result = weight.toOunce();
                        break;
                    case "pound":
                        result = weight.toPound();
                        break;
                    case "stone":
                        result = weight.toStone();
                        break;
                    default:
                        result = weight.toKg();
                        break;                        
                }

                System.out.println(inputamount + " " + inputweight + " is " + result + " " + outputweight);

            }else{System.out.println("please enter a valid input");}

            System.out.println("To quit enter quit otherwise enter either Length, Volume or Weight");
            input = myScanner.nextLine().toLowerCase();
        }

        myScanner.close();
    }
}

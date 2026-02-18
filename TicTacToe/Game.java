import java.util.Scanner;


public class Game{
    public static void main(String[] args) {



        // Current issues: 
        // Build the grid once and that's it.
        // just replace the position int with the input. 
        // Another issue is how I track the victory
        
        Scanner myScanner = new Scanner(System.in);
        boolean won = false;
        String input = "";
        int position = -1;
        String Grid = "";

        System.out.println(outputGrid("", -1, Grid));
        while(!won){
            System.out.println("Enter the position (number)");
            position = myScanner.nextInt();
            myScanner.nextLine();
            System.out.println("Enter the Symbol ( X or O)");
            input = myScanner.nextLine();

            Grid = outputGrid(input, position, Grid);
            System.out.println(outputGrid(input, position, Grid));

        }
    }

    public static String outputGrid(String input, int position, String currentGrid){

        if(!currentGrid.equals("")){
            return currentGrid.replace((char)position, (char)input);
        }
        String Grid = "";

        for(int k = 0; k < 3; k++){
            for(int i = 0; i < 3; i++){
                Grid += " -";
            }
            Grid += "\n";

            for(int j = 0; j < 3; j++){

                if(!input.equals("") && ((k * 3) + (j + 1)) == position){
                    Grid += "|" + input;
                }
                else{
                    Grid += "|" + ((k * 3) + (j + 1));
                }
            }
            Grid += "|\n";

        }
        Grid += " - - -";

        return Grid;
    }
}
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
        String Grid = generateGrid();

        // Idea: 
        // Create a grid with numbers as placeholders
        // Replace these numbers with X or O in a loop

        // how do to the win check?`
        // Store inputs with positions and if either one has then you know 
        

        System.out.println(Grid);

        while(!won){
            System.out.println("Enter the position (number)");
            position = myScanner.nextInt();
            
            myScanner.nextLine();
            System.out.println("Enter the Symbol (X or O)");
            input = myScanner.nextLine();

            Grid = Grid.replace(String.valueOf(position), input);
            System.out.println(Grid);

        }
        myScanner.close();
    }

    public static String generateGrid(){

        String Grid = "";

        for(int k = 0; k < 3; k++){
            for(int i = 0; i < 3; i++){
                Grid += " -";
            }
            Grid += "\n";

            for(int j = 0; j < 3; j++){
                Grid += "|" + ((k * 3) + (j + 1));
            }
            Grid += "|\n";

        }
        Grid += " - - -";

        return Grid;
    }
}
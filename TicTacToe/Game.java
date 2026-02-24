import java.util.Scanner;
import java.util.Arrays;

public class Game{
    public static void main(String[] args) {
        
        // Idea: 
        // Create a grid with numbers as placeholders
        // Replace these numbers with X or O in a loop

        // how do to the win check?`
        // Store inputs with positions and if either one has then you know 

        Scanner myScanner = new Scanner(System.in);

        boolean won = false;
        int position = -1;
        String Grid = generateGrid();
        String player1 = "";
        String player2 = "";
        String currentplayer = "";
        String [] table = new String[9];
        Arrays.fill(table, "");

        System.out.println(Grid);

        while(!won){

            //Choose position
            while(!Grid.contains(String.valueOf(position))){
                System.out.println("Enter a position on the Grid");
                position = myScanner.nextInt();
                myScanner.nextLine();
            }

            //Choose symbol for either player
            if(player1.equals("")  || player2.equals("")){

                System.out.println("Enter a Symbol");
                if(player1.equals("")){
                    player1 = String.valueOf(myScanner.nextLine().charAt(0)).toUpperCase();
                }
                else{
                    player2 = String.valueOf(myScanner.nextLine().charAt(0)).toUpperCase();
                }
            }


            // Update the Grid and player
            if(currentplayer.equals("") || currentplayer.equals(player2)){
                currentplayer = player1;
            }else{
                currentplayer = player2;
            }

            Grid = Grid.replace(String.valueOf(position), currentplayer);

            //Check for wins
            table[position - 1] = currentplayer;
            won = checkwins(table);

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

    public static boolean checkwins(String[] table){
        //rows
        for(int i = 0; i <= 7; i+= 3){
            if(table[i].equals(table[i+1]) && table[i].equals(table[i+2])){
                if(!table[i].equals("")){
                    return true;
                }
            }
        }

        //columns
        for(int j = 0; j < 3; j++){
            if(table[j].equals(table[j+3]) && table[j].equals(table[j+6])){
                if(!table[j].equals("")){
                    return true;
                }
            }
        }

        //diagonal
        if(table[0].equals(table[4]) && table[0].equals(table[8])){
            if(!table[0].equals("")){
                return true;
            }
        }

        //No wins found. Return false to keep playing.
        return false;
    }
}
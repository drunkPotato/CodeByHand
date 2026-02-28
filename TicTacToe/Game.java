import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Game{
    public static void main(String[] args) {
        
        // New Approach:
        // Generate a table (Array with 9 elements)
        // Print Grid due using that table instead of the previous Grid.
        


        //Setup
        Scanner myScanner = new Scanner(System.in);

        boolean gameover = false;
        boolean won = false;
        String [] table = new String[9];

        int position = -1;
        char player1 = '\0'; 
        char player2 = '\0';
        String currentplayer = "";
        Arrays.fill(table, "");

        System.out.println(printGrid(table));

        // Chose Symbols for players
        // They cant choose the same or digits
        while( player1 == '\0' || Character.isDigit(player1)){
            System.out.println("Enter a symbol for player 1");
            String input = myScanner.nextLine();

            if(!input.isEmpty()){
                player1 = Character.toUpperCase(input.charAt(0));
            }
        }

        while(player2 == '\0' || Character.isDigit(player2)){
            System.out.println("Enter a symbol for player 2");
            String input = myScanner.nextLine();

            if(!input.isEmpty()){
                player2 = Character.toUpperCase(input.charAt(0));
            }
        }

        while(!won){

            //Choose position
            while(!Grid.contains(String.valueOf(position))){
                System.out.println("Enter a position on the Grid");
                try {
                    position = myScanner.nextInt();
                    myScanner.nextLine();
                } catch (InputMismatchException e) {
                    myScanner.nextLine(); 
                }
            }

            // Update the Grid and player
            if(currentplayer.equals("") || currentplayer.equals(player2)){
                currentplayer = player1;
            }else{
                currentplayer = player2;
            }

            Grid = Grid.replace(String.valueOf(position), currentplayer);
            System.out.println(Grid);
            table[position - 1] = currentplayer;

            //Game over section
            //no win situation check.
            won = true;
            for(int i = 0; i < table.length; i++){
                if(table[i].equals("")){
                    won = false;
                }
            }

            if(won && !checkwins(table)){
                System.out.println("Game over. No player has won");
            }

            if(!won){
                won = checkwins(table);
            }

            if(checkwins(table)){
                System.out.println("Congratulations! Player " + currentplayer + " has won!");
            }

        }
        myScanner.close();
    }

    public static String printGrid(String[] board){

        String Grid = "";

        for(int k = 0; k < 3; k++){
            for(int i = 0; i < 3; i++){
                Grid += " -";
            }
            Grid += "\n";

            for(int j = 0; j < 3; j++){
                Grid += "|" + (board[(k * 3) + (j + 1) - 1]);
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
        if(table[2].equals(table[4]) && table[2].equals(table[6])){
            if(!table[2].equals("")){
                return true;
            }
        }

        //No wins found. Return false to keep playing.
        return false;
    }
}
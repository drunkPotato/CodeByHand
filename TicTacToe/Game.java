import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

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

            //Make player 1 forbidden symbol for player 2
            //Make 0 forbidden for both players

            //Choose symbol for either player
            if(player1.equals("")  || player2.equals("")){

                while(Grid.contains(player1) || player1.equals("") || player1.equals("0")){
                    System.out.println("Enter a for player 1");
                    player1 = String.valueOf(myScanner.nextLine().charAt(0)).toUpperCase();
                }
                while(Grid.contains(player2) || player2.equals("") || player2.equals(player1) || player2.equals("0")){
                    System.out.println("Enter a symbol for player 2");
                    player2 = String.valueOf(myScanner.nextLine().charAt(0)).toUpperCase();
                }
            }

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
        if(table[2].equals(table[4]) && table[2].equals(table[6])){
            if(!table[2].equals("")){
                return true;
            }
        }

        //No wins found. Return false to keep playing.
        return false;
    }
}
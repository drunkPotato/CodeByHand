import java.util.Scanner;
import java.util.Random;

public class RandomNumber{

    public static void main(String[] args){

        Scanner myScanner = new Scanner(System.in);
        Random myRandom = new Random();

        System.out.println("Enter a random number between 1 and 100");

        int tries = 0;

        int solution = myRandom.nextInt(100) + 1;
        boolean found = false;
        int guess = -1;

        // Check if the first one is good right
        guess = myScanner.nextInt();
        tries++;

        if(guess == solution){
            found = true;
        }

        while (!found){
            if(guess > solution){
                System.out.println("Your guess is too high, try again.");
            }
            else{
                System.out.println("Your guess is too low, try again");
            }

            guess = myScanner.nextInt();
            myScanner.nextLine();
            tries++;

            if(guess == solution){
                found = true;
            }
        }

        System.out.println("Correct! You have found the solution: " + solution + ". It took you " + tries + " guesses.");
        myScanner.close();
    }
}

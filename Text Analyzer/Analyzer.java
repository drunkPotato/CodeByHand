import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("please enter a word, sentance or short text");

        String text = myScanner.nextLine();
        System.out.println("Characters in the text: "+ countCharacters(text));


        myScanner.close();
    }

    public static int countCharacters(String text){
        
        // Enter the logic for counting characters in a string here.
        // I am not sure how this was done ^^ lets look it up later 

        int counter = 0;
        for(int i = 0; i < text.toCharArray().length; i ++){
            counter ++;
        }
        
        return counter;
    }
}

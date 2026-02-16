import java.util.Scanner;

public class Analyzer {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("please enter a word, sentance or short text");

        String text = myScanner.nextLine();
        System.out.println("Characters in the text: "+ countCharacters(text));
        System.out.println("Words in the text: " + countWords(text));
        System.out.println("Sentences in the text: " + countSentences(text));
        System.out.println("Reversed input: " + reverseText(text));


        myScanner.close();
    }

    public static int countCharacters(String text){
        int counter = 0;
        for(int i = 0; i < text.toCharArray().length; i ++){
            counter ++;
        }
        
        return counter;
    }

    public static int countWords(String text){
        return text.split(" ").length;
    }

    public static int countSentences(String text){
        int counter = 0;
        for(int i = 0; i < countCharacters(text); i++){
            if(Character.compare(text.charAt(i), '.') == 0 || Character.compare(text.charAt(i), '!') == 0 || 
                Character.compare(text.charAt(i) , '?') == 0){
                counter ++;
            }
        }
        return counter;
    }

    public static String reverseText(String text){
        String reversed = "";
        for(int i = text.length() - 1; i >= 0; i--){
            reversed += text.charAt(i);
        }
        return reversed;
    }
}

import java.util.Scanner;
import java.util.Arrays;

public class Analyzer {
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("please enter a word, sentance or short text");

        String text = myScanner.nextLine();
        System.out.println("Characters in the text: "+ countCharacters(text));
        System.out.println("Words in the text: " + countWords(text));
        System.out.println("Sentences in the text: " + countSentences(text));
        System.out.println("Reversed input: " + reverseText(text));
        System.out.println("Highes occurences words: " + wordCount(text));


        myScanner.close();
    }

    public static int countCharacters(String text){
        return text.length();
    }

    public static int countWords(String text){
        return text.split(" ").length;
    }

    public static int countSentences(String text){
        int counter = 0;
        for(int i = 0; i < countCharacters(text); i++){
            if(text.charAt(i) == '.' || text.charAt(i) == '!' ||  text.charAt(i) == '?'){
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

    public static String wordCount(String text){

        String maxWords = "";
        text = text.replace(".", "");
        String[] words = text.toLowerCase().split(" ");
        int[] count = new int[words.length];

        Arrays.fill(count, 1);

        for(int i = 1; i < words.length; i++){
            for(int j = 0; j < i; j++){
                if(words[i].equals(words[j])){
                    count[i] = count[j] + 1;
                }
            }
        }

        int max = count[0];
        for(int k = 0; k < count.length; k++){
            if(count[k] > max){
                max = count[k];
            }
        }

        for(int l = 0; l < count.length; l++){
            if(count[l] == max){
                maxWords += words[l] + " ";
            }
        }

        return "[ " + maxWords + "] occured " + max + " times.";
    }
}

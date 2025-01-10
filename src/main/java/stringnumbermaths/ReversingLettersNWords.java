package stringnumbermaths;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ReversingLettersNWords {

    private AuthorSolutions authorSolutions = new AuthorSolutions(); ;

    public static void main(String[] args) {

//        String reversedString = new ReversingLettersNWords().reverseLetters(UserInputHelper.getUserInputString());
//        System.out.println(reversedString);

         //new ReversingLettersNWords().callAuthorSol(new AuthorSolutions() , UserInputHelper.getUserInputString());

        //Using Functional style
        String reversedLetters = new ReversingLettersNWords().authorSolutions.reversedWordFuncStyle(UserInputHelper.getUserInputString());
        //System.out.println(new StringBuilder(UserInputHelper.getUserInputString()).reverse());
        System.out.println(StringUtils.reverse(UserInputHelper.getUserInputString()));

    }

    public String reverseWords(String sentence)  {
        String[] words = sentence.split(" ");
        StringBuilder finalReversedLetterNWord = new StringBuilder();

        for( int idx = words.length -1 ; idx >= 0 ; idx--){
            finalReversedLetterNWord.append(reverseWords(words[idx]));
            finalReversedLetterNWord.append(" ");
        }
        return finalReversedLetterNWord.toString();
    }

    public String reverseLetters(String word){

        StringBuilder reversedLetter = new StringBuilder();
        for (int i = word.length() -1 ; i >=  0; i--) {
            reversedLetter.append(word.charAt(i));
        }

        return reversedLetter.toString();
    }

    public void callAuthorSol(AuthorSolutions solutions, String str){
        String reversedWords = solutions.reverseWords(str);
        System.out.println(reversedWords);
    }

    static class AuthorSolutions{
        private static final String WHITESPACE = " ";

        public String reverseWords(String str) {

            String[] words = str.split(WHITESPACE);
            StringBuilder reversedString = new StringBuilder();

            for (String word: words) {
                StringBuilder reverseWord = new StringBuilder();

                for (int i = word.length() - 1; i >= 0; i--) {
                    reverseWord.append(word.charAt(i));
                }

                reversedString.append(reverseWord).append(WHITESPACE);
            }

            return reversedString.toString();
        }

        // Using Java 8 Functional style
        private static final Pattern PATTERN = Pattern.compile(" +");
        public String reversedWordFuncStyle(String line){
            return PATTERN.splitAsStream(line).map(w -> new StringBuilder(w).reverse()).collect(Collectors.joining(" "));

        }
    }
}

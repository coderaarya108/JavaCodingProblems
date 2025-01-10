package stringnumbermaths;

import org.apache.commons.lang3.tuple.Pair;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class CountVowelsNConsonents {
    private static String str = UserInputHelper.getUserInputString();
    public static void main(String[] args) {
        //CountVowelsNConsonents.cntVowelsNConsonantsUsingFnctionalStyle();

        CountVowelsNConsonents.cntVowelsNConsonantsUsingParitioningBy();
    }

    public void cntVowelsNConsonants(){
        int vowelCnt = 0;
        int consonantCnt = 0;
        for(char ch : str.toCharArray()){
            if(isVowel(ch)){
                vowelCnt++;
            } else {
                consonantCnt++;
            }
        }
        System.out.println("Vowel Cnt : " + vowelCnt + "\nConsonent cnt: " + consonantCnt);
    }

    public static void cntVowelsNConsonantsUsingFnctionalStyle(){

        final Set<Character> allVowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        String string = str.toLowerCase();

        long vowelCnt = string.chars().filter(ch -> allVowels.contains((char) ch)).count();
        long consonantCnt = string.chars().filter(ch -> !allVowels.contains((char) ch) && ch >= 'a' && ch <= 'z').count();

        System.out.println(Pair.of(vowelCnt , consonantCnt));

    }

    public static void cntVowelsNConsonantsUsingParitioningBy(){
        final Set<Character> allVowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        String string = str.toLowerCase();
        Map<Boolean, Long> result = string.chars()
                                        .mapToObj(c -> (char) c)
                                        .filter( ch -> (ch >= 'a' && ch <= 'z'))
                                        .collect(Collectors.partitioningBy(c -> allVowels.contains(c) , counting()));
        System.out.println(Pair.of( result.get(true) , result.get(false)));
    }

    public static boolean isVowel(Character ch){
        String string = String.valueOf(ch);
        return string.matches("[aeiouAEIOU]");
    }
}

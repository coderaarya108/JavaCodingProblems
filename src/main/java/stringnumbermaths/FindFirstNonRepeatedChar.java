package stringnumbermaths;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FindFirstNonRepeatedChar {
    public static void main(String[] args) {

        System.out.println("Enter your string");
        //System.out.println(new FindFirstNonRepeatedChar().firstNonRepChar(UserInputHelper.getUserInputString()));

       // System.out.println(new FindFirstNonRepeatedChar().firstNonRepCharOneTraversal("gjzghhjkjjliokoilc"));
        //System.out.println(new FindFirstNonRepeatedChar().firstNonRepChar("gjzghhjkjjliokoilc"));

        System.out.println(LinkedHasMapImplemenationForNonRepChar.firstNonRepLinkedHM("gjzghhjkjjliokoilc") );
    }


    // Below is my implementation of code using HashMap , but Author has better approach to use LinkedHashMap
    // which maintains the insertion order
    public char firstNonRepChar(String str){
        Map<Character, Long> resMap = new HashMap<>();
        for (char c : str.toCharArray()){
            resMap.compute(c , (k,v) -> v == null ? 1 : ++v);
        }

        for (char c : str.toCharArray()){
            if(resMap.get(c) == 1){
                return c;
            }
        }

        return '0';
    }

    //Single Traversal method
    public char firstNonRepCharOneTraversal(String str){

        final int EXTENDED_ASCII_CODES = 256;
        int[] flags = new int[EXTENDED_ASCII_CODES];

        for( int idx = 0; idx < flags.length ; idx++){
            flags[idx] = -1;
        }

        for (int idx = 0; idx < str.length(); idx++) {
            char ch = str.charAt(idx);
            if( flags[ch] == -1){
                flags[ch] = idx;
            } else {
                flags[ch] = -2;
            }
        }

        int position = Integer.MAX_VALUE;

        for (int idx = 0; idx < flags.length; idx++) {
            if( flags[idx] > 0){
                position = Math.min(position , flags[idx] );
            }
        }

        return position == Integer.MAX_VALUE ? Character.MIN_VALUE : str.charAt(position);
    }

    static class LinkedHasMapImplemenationForNonRepChar{
        public static char firstNonRepLinkedHM(String str){
            Map<Character, Long> resMap = new LinkedHashMap<>();
            for (char c : str.toCharArray()){
                resMap.compute(c , (k,v) -> v == null ? 1 : ++v);
            }

            for (Map.Entry<Character, Long> key : resMap.entrySet()){
                if(key.getValue() == 1){
                    return key.getKey();
                }
            }
            return Character.MIN_VALUE;
        }
    }
}

package stringnumbermaths;

import java.util.*;
import java.util.stream.Collectors;

public class JoinMultipleStringsWithDelimiter {

    private static List<String> strings = new ArrayList<>();

    public static void main(String[] args) {
        initSetup();
        joinStringWithDelim( strings, "^");

        //joinStringWithDelimWithStringjoiner(',' , "Hey", "how" , "is" , "it" , "going");

        //joinStringWithDelimWithFunctional('$', "All", "I" , "think" , "about", "is" , "money" , "dollara" ,"dollara" , "dollara" );
    }

    public static void joinStringWithDelim(List<String> strings , String delimiter){
        StringBuilder finalString = new StringBuilder();

        strings.forEach(str -> finalString.append(str).append(delimiter));
        System.out.println(finalString.toString().substring(0, finalString.length() -1));
    }

    public static void joinStringWithDelimWithStringjoiner(Character delimiter, String... strings){
        StringJoiner joiner = new StringJoiner(String.valueOf(delimiter));

        for(String str : strings){
            joiner.add(str);
        }

        System.out.println(joiner.toString());
    }

    public static void joinStringWithDelimWithFunctional(Character delimiter, String... strings){

        String finalStr =  Arrays.stream(strings).collect(Collectors.joining(String.valueOf(delimiter)));
        System.out.println(finalStr);
    }

    public static List<String> initSetup(){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many strings to join ? ");
        int listLen = sc.nextInt();

        System.out.println("Alright ! , please enter your " + listLen + " strings");
        while(listLen > 0){
            strings.add(sc.next());
            listLen--;
        }

        return strings;
    }
}

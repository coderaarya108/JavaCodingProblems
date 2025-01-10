package stringnumbermaths;

import org.apache.commons.lang3.StringUtils;

public class CountCharOccurence {
    public static void main(String[] args) {
        //countCharOccur(UserInputHelper.getUserInputString() , 'a');
        //countCodePointOccur(UserInputHelper.getUserInputString(), "ᴁ");
        countCharOccStringUtils(UserInputHelper.getUserInputString() , "ᴁ");
    }

    public static void countCharOccur(String str , char ch){

        System.out.println(str.chars().mapToObj(c -> (char)c).filter(c -> c == ch ).count());
    }

    //Surrogate pairs
    public static void countCodePointOccur(String str , String ch){
        int codePoint = ch.codePointAt(0);
        System.out.println(str.codePoints().filter(c -> c == codePoint).count());
    }

    //Using Apache commons lang - StringUtils
    public static void countCharOccStringUtils(String str , String ch){
        // Apache Commons StringUtils
        System.out.println(StringUtils.countMatches(str , ch));

        //Spring Framework StringUtils
        System.out.println(org.springframework.util.StringUtils.countOccurrencesOf(str, String.valueOf(ch)));
    }
}

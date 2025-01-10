package stringnumbermaths;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CountDuplicateCharsInString {

    public static void main(String[] args) {

        System.out.println("Please enter string : ");
        String inputString = UserInputHelper.getUserInputString();

        //new CountDuplicateCharsInString().countDuplicateChar_Mine(inputString);

        System.out.println(new CountDuplicateCharsInString().countDupChar_Streams_Author(inputString));
    }

    //My solution
    public void countDuplicateCharMine(String str){
        Map<Character , Integer> charCntMap = new HashMap<>();
        int dupCharCnt = 0;
        for(char ch : str.toCharArray()){
            if(charCntMap.containsKey(ch)){
                charCntMap.put(ch, charCntMap.get(ch) + 1);
            } else {
                charCntMap.put(ch , 1);
            }
        }

        for( char ch : str.toCharArray()){
            if(charCntMap.get(ch) > 1){
                dupCharCnt++;
                charCntMap.put(ch , 0);
            }
        }
        System.out.println("Duplicate char count : " + dupCharCnt);
    }

    //This method by author on how to use compute method in Map
    public Map<Character , Integer> countDuplicateChar_Author(String str){
        Map<Character , Integer> resultCntMap = new HashMap<>();

        for(char ch : str.toCharArray()){
            resultCntMap.compute(ch , (k,v) -> v==null ? 1 : ++v);
        }
        return resultCntMap;
    }

    //This method by author to use Streams to do the job
    public Map<Character , Long> countDupChar_Streams_Author(String str){
        Map<Character, Long> resMap = str.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> c , Collectors.counting()));
        return resMap;
    }

}

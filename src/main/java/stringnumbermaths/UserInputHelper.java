package stringnumbermaths;

import java.util.Scanner;

public class UserInputHelper {

    private UserInputHelper(){
        throw new IllegalStateException("Utility class, not to be instantiated");
    }
    private static final String ASK_USER_INPUT = "Please enter string";

    public static String getUserInputString(){
        System.out.println(ASK_USER_INPUT);
        return new Scanner(System.in).nextLine();
    }

    public static int getUserInputInteger(){
        System.out.println(ASK_USER_INPUT);
        return new Scanner(System.in).nextInt();
    }

    public static double getUserInputDouble(){
        System.out.println(ASK_USER_INPUT);
        return new Scanner(System.in).nextDouble();
    }

}

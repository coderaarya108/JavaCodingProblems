package stringnumbermaths;

public class ConvertStringToNumericType {
    public static final String TO_INT = "2345";
    public static final String TO_LONG = "934545435344545";
    public static final String TO_FLOAT = "2345.565";
    public static final String TO_DOUBLE = "-45634343.2342343345D";

    public static void main(String[] args) {

        //String to primitive
        int toInt = Integer.parseInt(TO_INT);
        long toLong = Long.parseLong(TO_LONG);
        float toFloat = Float.parseFloat(TO_FLOAT);
        double toDouble = Double.parseDouble(TO_DOUBLE);

        //String to Wrapper classes
        Integer toInteger = Integer.valueOf(TO_INT);
        Double toDoubleWc = Double.valueOf(TO_DOUBLE);

        System.out.println(String.format("int : %d  long : %d  float : %f double : %.10f" , toInt , toLong , toFloat , toDouble));
        System.out.println(toDoubleWc);
        System.out.println(String.format("Integer : %d  Double : %f  " , toInteger ,  toDoubleWc));
    }
}

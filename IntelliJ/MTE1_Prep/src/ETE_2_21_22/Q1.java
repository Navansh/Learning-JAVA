package ETE_2_21_22;
public class Q1 {
    public static String convertTo(int decimalNumber, int baseValue) {
        // Use a string builder to build the result
        StringBuilder result = new StringBuilder();

        // Continue while the decimal number is greater than 0
        while (decimalNumber > 0) {
            // Append the remainder when the decimal number is divided by the base value
            result.append(decimalNumber % baseValue);
            // Divide the decimal number by the base value
            decimalNumber /= baseValue;
        }

        // Reverse the string builder and return the result as a string
        return result.reverse().toString();
    }
}
class Driiver{
    public static void main(String[] args) {
        Q1 q = new Q1();
        String ss = Q1.convertTo(42,8);
        System.out.println(ss);
    }
}
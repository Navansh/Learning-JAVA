import java.util.Scanner;
import java.util.zip.ZipFile;

public class Upper_or_Lower_case {
    public static void main(String[] args) {
        //Program to find if the input variable is upper case or lower case
        Scanner in = new Scanner(System.in);
        char ch = in.next().trim().charAt(0);
        if (ch >= 'a' && ch<='z')
        {
            System.out.println("The input character is Lower Case");
        }
        else {
            System.out.println("The input character is Upper Case");
        }
//        System.out.println(in.next().trim());
    }
}

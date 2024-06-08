import java.util.Scanner;
import java.util.zip.ZipFile;

//program used to count the number of occurances of a specific digit in a number here we take 3
public class No_of_occurances {
    public static void main(String[] args) {
        int count = 0;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        int num = in.nextInt();

        while(num>0)
        {
            if (num%10 ==3 )
            {
                count++;
            }
            num = num/10;
        }

        System.out.println(count);

    }
}

import java.util.*;

public class Sum_0f_digits {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner in = new Scanner(System.in);
        int rev_num = 0;
        int num = in.nextInt();
        while(num>0)
        {
            int rem = num%10;
            rev_num=rev_num+ rem;
            num=num/10;
        }
        System.out.println(rev_num);
    }
}

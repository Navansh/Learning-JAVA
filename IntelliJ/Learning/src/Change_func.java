import java.util.Arrays;

public class Change_func
{
    public static void main(String[] args)
    {
        int [] arr={1,3,5,7};
        change(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void change(int[] arr)
    {
        arr[0]=9;
    }


}

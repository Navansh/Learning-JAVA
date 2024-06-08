import java.util.ArrayList;

public class Operators
{
    public static void main(String[] args) {
        System.out.println('a'+'b');
        //both converted to their unicode value and then adding
        System.out.println("a"+"b");
        //now it concatenated the string
        System.out.println('a'+3);
        //a converted to unicode
        System.out.println((char)('a'+3));
        //now we are just typecasting
        System.out.println("a"+1);
        //string + integer = will convert the complete to string and print it

//        NOTE
        //When an integer is concatenated with a string it is converted to its wrapper class int
        //now that int will call toString() method and then print itself as string
        System.out.println("Navansh " + new ArrayList<>());
        //which means the initial array is empty and hence it prints just brackets using toString()
        System.out.println("Navansh "+new Integer(56));
        //56 is considered an object and hence toString() is called

//        System.out.println(new Integer(56) + new ArrayList<>());
        //>>>here it gives error<<<<<
        // as we cannot concatenated the above two objects
        //reason -> in JAVA the +(concatenate) operator is defined for primitives or when any one of these values is
        //string

//       **** hence this will work ****
        System.out.println(new Integer(56) +""+ new ArrayList<>());
        String ans = new Integer(56) + "" + new ArrayList<>();

        //if one of the type is string the answer will be string
        System.out.println(ans);
    }
}

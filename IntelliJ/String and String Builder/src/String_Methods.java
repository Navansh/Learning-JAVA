import java.util.Arrays;

public class String_Methods
{
    public static void main(String[] args) {
        String name = "Navansh";
        System.out.println(Arrays.toString(name.toCharArray()));
        //coverts it to char array
        System.out.println(name.toLowerCase());
        //this creates a new object and does not alter the OG one
//        hence
        System.out.println(name);

        System.out.println(name.indexOf('a'));

        String dance = "       uedf      e        ";
        System.out.println(dance.trim());
        //all leading and trailing spaces removed

        System.out.println(dance.strip());
        //does the same as the trim
//        but********
      /*  strip() is "Unicode-aware" evolution of trim().
               Meaning trim() removes only characters <= U+0020 (space);
        strip() removes all Unicode whitespace characters (but not all control characters, such as \0)*/


        System.out.println(Arrays.toString(name.split("a")));
        //it will split it wherever it finds the 'a'
        //we can use space also instead of 'a'

        //we needed to use Arrays.toString as it returns an String Array and we need String as an O/P



    }

}

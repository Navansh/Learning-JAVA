package MTE_2.java;

import java.util.StringTokenizer;

public class Strings {
    public static void main(String[] args) {
//        String str2 ="abc";
//        // str2:“object"
//        String str = "abc";
//        System.out.println(str==str2);
//        String str3 = new String("chs",2,4);
        // start-index=1, number-of-characters=4,index range: 2 to 5 (“ject”);
//        how ?
    //String str4 = new String(chs,3,4); // start-index=3, number-of-characters=4,index range: 3 to 6
//        char A = str.charAt(0);
//        System.out.println(A);
//        StringBuilder strb1;
//        strb1 = new StringBuilder("Dance");
//        System.out.println(strb1);

        String str5 = "CS 1304, 1683, Object-Oriented Programming, Lecture-Section CC 3C,; MWF, 9, 311, AB-1";

        StringTokenizer strZ = new StringTokenizer(str5,",;",true); // Default Delimiter is white space

        System.out.println("Number of Tokens:" + strZ.countTokens());

        while(strZ.hasMoreTokens())
            System.out.println(strZ.nextToken());

//        and check how ranges are calculated for the same arrays wala data type like for Sort
    }
}

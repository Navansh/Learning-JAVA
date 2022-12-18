package MTE_2.java;
public class Misc {
    public static void main(String[] args) {
//        System.out.println("Hello");
        StringBuffer strb3 = new StringBuffer("Java");
        System.out.println(strb3.length());
        System.out.print("\n");
        System.out.println(strb3.capacity());

        //why 20 in capacity ?????

        StringBuffer strB3 = new StringBuffer();
        System.out.println(strB3.length());	// Length 	=  0
        System.out.println(strB3.capacity());	// Capacity = 16
        strB3.ensureCapacity(10);	// 10 < 16
        System.out.println(strB3.length());	// Length	= 0
        System.out.println(strB3.capacity());	// Capacity	= 16


    }


}

public class Comparison
{
    public static void main(String[] args) {
//        String a = "Navansh";
//        String b = "Navansh";
//
//        //to check if a and b point to the same string object
////        we use '=='
//        System.out.println(a==b);
        String name1 = new String("Navansh");
        String name2 = new String("Navansh");
        System.out.println(name1 == name2);
        System.out.println(name1.charAt(1));
    }

}

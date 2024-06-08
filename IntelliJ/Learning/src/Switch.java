import java.util.Scanner;

public class Switch {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        String fruit = in.next();

//        System.out.println(fruit);
//        switch (fruit)
//        {
//            case "Mango" -> {
//                System.out.println("King of Fruits");
//                break;
//            }
//            case "Apple" -> {
//                System.out.println("sweet");
//                break;
//            }
//            case "Orange" -> {
//                System.out.println("Dance");
//                break;
//            }
//            default -> {
//                System.out.println("please neter a valid fruit");
//            }
//        }

        //to print weekday or not
        int day =1;
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Weekday");
                break;
            case 6:
            case 7:
                System.out.println("weekend");
                break;
        }

        //This or this: Two types of switch statements doing exactly the same thing

        switch (day) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println("Weekday");
                break;
            }
            case 6, 7 -> {
                System.out.println("weekend");
                break;
            }
        }






















    }

}

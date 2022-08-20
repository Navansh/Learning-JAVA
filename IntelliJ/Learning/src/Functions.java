public class Functions
{
    public static void main(String[] args)
    {
        //Q : take input of 2 numbers and print the sum
//        String p = greet();
//        int result = sum3(34,45);
//        System.out.println(result);
        String pvt = gorilla("navansh");
        System.out.println(pvt);
    }

    static String gorilla(String name)
    {
        String message = "Hello " + name;
        return message;
    }



    static int sum3(int a,int b)
    {
        int sum = a+b;
        return sum;
    }
    static String greet()
    {
        String greeting = "How are you";
        return greeting;
    }











}

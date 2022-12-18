public class PrettyPrinting
{
    public static void main(String[] args) {
        float a = 12.45645f;
        //Say you want to print it till 2 or n decimal values only then
        //we use % - > which means placeholder
        //and this is not going to be println but printf(formatted string)
        int ab = 55;
        System.out.printf("Formatted number is %.2f\n",a);
        System.out.printf("The value is dance %d\n",ab);

        System.out.println(Math.PI);
        System.out.printf("Pie is %.3f\n",Math.PI);
        //as you can see it rounds it off

        System.out.printf("Hello my Name is %s and you should %s\n","Navansh", "Pikachi");
        System.out.println(Math.E);

    }
}

public class Scope
{
    public static void main(String[] args) {
        int a =10;
        int b = 20;

        {
//            int b =45;  cannot reinitialize it again
            int c = 1;
            System.out.println(c);
        }
        int c =45;// can reinitialize it again
        System.out.println(c);
    }
}

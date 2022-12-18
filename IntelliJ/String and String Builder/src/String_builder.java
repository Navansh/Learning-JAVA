public class String_builder
{
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            char ch = (char) ('a' + i);
            builder.append(ch);
            //doesn't create new object everytime
        }
        System.out.println(builder);
        //.toString() is not required here as builder calls that automatically internally
    }

}

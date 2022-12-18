public class Performance
    //very important topic for coding rounds
{
    public static void main(String[] args)
    {
        String series = "";
        for (int i = 0; i < 2565; i++) {
            char ch = (char) ('a' + i);
            series = series + ch; //series +=ch;
            //here we concatenate using for loop
            //as series is of String type
        }
        System.out.println(series);
    }
}

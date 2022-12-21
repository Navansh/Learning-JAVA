package Pattern;

public class Triangle {
    public static void main(String[] args) {
//        Trianggle(4,0);
        TriangleNormal(4,0);
    }

    public static void Trianggle(int row, int col)
    {
        if (row==0)
        {
            return;
        }
        if (col<row) {
            System.out.print("* ");
            Trianggle(row, col + 1);
        }
        else {
            System.out.println();
            Trianggle(row-1,0);
        }
    }
    public static void TriangleNormal(int row, int col)
    {
        if (row==0)
        {
            return;
        }
        if (col<row) {
            TriangleNormal(row, col + 1);
            System.out.print("* ");
        }
        else {
            TriangleNormal(row-1,0);
            System.out.println();
        }
    }
}

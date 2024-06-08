package ETE_21_22;

//Example-1:
//        10 20 30 40 50
//        3 6 9 12 15 18 21 24 5 10 15
//        2 4 6 8 10 12
//        1
public class Q2 {
    public static void main(String[] args) {
//        int[][] ir_array = new int[4][];
//        ir_array[0] = new int[5];
//        ir_array[1] = new int[12];
//        ir_array[2] = new int[6];
//        ir_array[3] = new int[1];
//        ir_array[0][1] = 45;

//        or

        int[][] ir_array = new int[][]{
                {10, 20, 30, 40, 50},
                {3, 6, 9, 12, 15, 18, 21, 24, 5, 10, 15},
                {2, 4, 6, 8, 10, 12},
                {1}
        };

        System.out.println("Iterating Through the Irregular Array");
        for (int[] ints : ir_array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println(" ");
        }

        int rowSum = 0;
        int col = 0;

        for (int i = 0; i < ir_array.length; i++) 
        {
            rowSum = 0;
            for (int j = 0; j < ir_array[i].length; j++) {
                rowSum += ir_array[i][j];
                col = ir_array[i].length;
            }
//           ir_array[i][col] = new int[i][col];

        }

        for (int i = 0; i < ir_array.length; i++) {
            for (int j = 0; j < ir_array[i].length; j++) {
                System.out.print(ir_array[i][j] + " ");
            }
            System.out.println();
        }






    }
}
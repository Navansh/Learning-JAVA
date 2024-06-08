package Array_Questions.Spiral_Printing;

public class Print_boundary {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        printBoundary(arr);
    }

    public static void printBoundary(int[][] arr) {
        int i = 0;
        int j = 0;

        for (int k = 0; k < arr.length - 1; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j]+ " ");
            j++;
        }

        System.out.println();

        for (int k = 0; k < arr.length - 1; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j]+ " ");
            i++;
        }

        System.out.println();

        for (int k = 0; k < arr.length - 1; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j] + " ");
            j--;
        }

        System.out.println();

        for (int k = 0; k < arr.length - 1; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j]+ " ");
            i--;
        }
    }
}

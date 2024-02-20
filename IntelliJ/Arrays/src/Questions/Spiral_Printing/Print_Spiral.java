package Questions.Spiral_Printing;

public class Print_Spiral {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };
        printSpiralRectangle(arr);
    }

    public static void printSpiralRectangle(int[][] arr) {
        //this we are doing for N*M matrix
        int i = 0;
        int j = 0;
        int rSteps = arr.length - 1;
        int cSteps = arr[0].length - 1;

        while (rSteps >= 1 && cSteps >= 1) {
            for (int k = 0; k < cSteps; k++) {
                //Ex : for length 5, we go from 0 to 3
                System.out.print(arr[i][j]+ " ");
                j++;
            }

            System.out.println();

            for (int k = 0; k < rSteps; k++) {
                //Ex : for length 5, we go from 0 to 3
                System.out.print(arr[i][j]+ " ");
                i++;
            }

            System.out.println();

            for (int k = 0; k < cSteps; k++) {
                //Ex : for length 5, we go from 0 to 3
                System.out.print(arr[i][j] + " ");
                j--;
            }

            System.out.println();

            for (int k = 0; k < rSteps; k++) {
                //Ex : for length 5, we go from 0 to 3
                System.out.print(arr[i][j]+ " ");
                i--;
            }
            //we shift i and j diagonally
            i++;
            j++;
            rSteps -= 2;
            cSteps -= 2;
        }

        if(rSteps == 0) {
            //this case occurs when the spiral is of odd length
            for (int k = 0; k < cSteps + 1; k++) {
                System.out.println(arr[i][j]);
                j++;
            }
            //hence, in this we additionally print the center element
        } else if (cSteps == 0) {
            for (int k = 0; k < rSteps + 1; k++) {
                System.out.println(arr[i][j]);
                i++;
            }
        }
    }

    public static void printSpiral(int[][] arr) {
        //this we are doing for N*N matrix
        int i = 0;
        int j = 0;
        int steps = arr.length - 1;

        while (steps >= 1) {
            printBoundary(arr, i, j , steps);
            //we shift i and j diagonally
            i++;
            j++;
            steps -= 2;
        }

        if(steps == 0) {
            //this case occurs when the spiral is of odd length
            System.out.println(arr[i][j]);
            //hence, in this we additionally print the center element
        }
    }

    private static void printBoundary(int[][] arr, int i, int j, int steps) {

        for (int k = 0; k < steps; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j]+ " ");
            j++;
        }

        System.out.println();

        for (int k = 0; k < steps; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j]+ " ");
            i++;
        }

        System.out.println();

        for (int k = 0; k < steps; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j] + " ");
            j--;
        }

        System.out.println();

        for (int k = 0; k < steps; k++) {
            //Ex : for length 5, we go from 0 to 3
            System.out.print(arr[i][j]+ " ");
            i--;
        }
    }

}

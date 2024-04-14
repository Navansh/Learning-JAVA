package Stack_Questions.Matrix;

public class Search_in_Matrix {
    public static void main(String[] args) {
        //given :
        //each row is sorted in non-decreasing order
        //first integer of each row is greater than the last integer of prev row

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //well use the concept of Binary Search here
        int n = matrix.length;
        //these are the no of rows
        int m = matrix[0].length;

        int lo = 0;
        int hi = n*m - 1;
        //hence we converted from Matrix to a 1D Array
        //just for the calculation purposes

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            //check the conditions on mid
            int rindex = mid/m;
            int cindex = mid % m;

            if(matrix[rindex][cindex] == target) {
                return true;
            } else if(matrix[rindex][cindex] < target) {
                //go to right
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }
}

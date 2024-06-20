package BS_Questions.Unsorted_Array.Pattern_1;

public class Allocate_minimum_number_of_pages {
    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/
        int[] A = {15,10,19,10,5,18,7};
        System.out.println(findPages(A,A.length,5));
    }

    public static int findPages(int[] A,int N,int M) {
        if(M > N) {
            return -1;
        }
        int max_ele = Integer.MIN_VALUE;
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            max_ele = Math.max(max_ele, A[i]);
            max += A[i];
        }

        int low = max_ele;
        int high = max;

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            //mid represents the min number of pages you need to allot/student

            int students_given = studentCalculator(A, mid);

            if(students_given <= M) {
                //means each student got too much pages, hence reduce the no pages
                //that's why we weren't able to allocate this many pages to n students
                //per student


                ans = mid;
                high = mid - 1;

            } else {
                //we got more students as we allocated very less pages to each student
                low = mid + 1;
            }
        }

        return ans;

    }

    private static int studentCalculator(int[] a, int mid) {
        //given the max value of no of pages to allocate to a student
        //return the no of students that will possibly get the book

        int students = 0;
        int bucket = 0;

        for (int i = 0; i < a.length; i++) {
            if(bucket + a[i] <= mid) {
                //then add these pages to the bucket
                bucket += a[i];
            } else {
                bucket = a[i];
                students++;
            }
        }

        return students + 1;

    }


}

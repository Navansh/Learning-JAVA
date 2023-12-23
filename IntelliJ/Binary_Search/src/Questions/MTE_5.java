package Questions;

public class MTE_5 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,4,5,6};
        System.out.println(findMissing(arr));
    }

    public static int BinarySearch(int num, int[] arr) {
        int start = 0;
        int end = arr.length -1 ;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == num) {
                return mid;
            } else if(arr[mid] > num) {
                end = mid -1;

            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int findMissing(int[] nums) {
        //first find the max element
        int max = -999999;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > max) {
                max = nums[i];
            }
        }

        for (int i = 0; i < max; i++) {
            int ans = BinarySearch(i, nums);
            if(ans == -1) {
                return i;
            }
        }

        return -1;
    }
}

package Stack_Questions.Two_Pointers;

public class Container_with_Most_Water {
    public static void main(String[] args) {
        //https://leetcode.com/problems/container-with-most-water/description/

    }

    public static int maxArea(int[] height) {
        int max_area = Integer.MIN_VALUE;

        int i = 0;
        int j = height.length - 1;

        while (i < j) {
            //calculate the water storage for this set of str of i and j
            int length = j - i;
            int actual_height = Math.min(height[i], height[j]);

            int water_stored = length * actual_height;

            max_area = Math.max(max_area, water_stored);

            //now do the further steps to move ahead
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max_area;
    }

}

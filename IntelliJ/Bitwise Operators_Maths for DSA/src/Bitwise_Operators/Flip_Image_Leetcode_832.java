package Bitwise_Operators;

public class Flip_Image_Leetcode_832
{
    public static void main(String[] args) {
        
    }
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] row : image) {
            //reverse this array
            //then take complement simultaneously
            for (int i = 0; i < (image[0].length + 1)/2; i++) {
                //hence this loop runs for every column
                //swap
                int temp = row[i] ^ 1;
                row[i] = row[image[0].length - i-1] ^ 1;
                row[image[0].length - i-1] = temp;
            }
        }
        return image;
    }
}

package Maths;

public class Power_Of_Two_Integers {
    public static void main(String[] args) {
        System.out.println(isPower(19));
    }

    public static int isPower(int A) {
        //check till i*i that if any log base gives an intger value
        for (int i = 2; i*i <= A; i++) {
            //check if base i return an int value
            float ans = checkLog(i, A);
            float ans2 = (int) ans;

            if(ans == ans2) {
                return 1;
            }
        }

        return 0;
    }

    private static float checkLog(int i, int a) {
        //a to the base i
        return (float) (Math.log(a) / Math.log(i));
    }
}

package Questions;

public class Leetcode_202_happy_number {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(isHappy(n));
    }
    public static boolean isHappy(int n){
        int slow = n;
        int fast = n;

        //now we have to move slow 1 step ahead and fast 2 steps ahead
        //1 step-> finding the square of the number's digit(individually squared and added)
        // and then checking whether it is equal to 1
        do {
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while (slow!=fast);
        //this is the slow and fast pointer which is used to check cyclicity
        //there will be 2 cases when slow and fast will becoem equal,
        //1st case -> they both have taken value 1 respectively and doing sqaure doesn't change that ->happy number
        //they are in cycle and then they become equal -> unhappy no
        if (slow==1){
            return true;
        }
        return false;

    }
    private static int findSquare(int number){
        int ans = 0;
        while (number>0){
            int rem = number%10;
            ans = ans + rem*rem;
            number = number/10;
        }
        return ans;
    }
}

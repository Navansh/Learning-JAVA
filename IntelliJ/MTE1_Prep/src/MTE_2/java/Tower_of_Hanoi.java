package MTE_2.java;

public class Tower_of_Hanoi
{
    public static void main(String[] args) {
        int n = 6;
        towerOfHanoi(n,"S","H","D");
    }
    public static void towerOfHanoi(int n,String src, String helper, String destination)
    {
        //n=>no of disks
        //base case:
        if (n==1)
        {
            System.out.println("Transfer disk "+n+" from "+src+" to "+destination);
            return;
        }
        towerOfHanoi(n-1,src,destination,helper);
        System.out.println("Transfer disk "+n+" from "+src+" to "+destination);
        towerOfHanoi(n-1,helper,src,destination);
    }
}

package ETE_final;

import java.util.Scanner;

public class Circle
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float radius;
        System.out.println("Enter the radius for the given circle");
        radius = sc.nextFloat();
        float area = (float) (3.14*radius*radius);
        float circumference = (float) (2*3.14*radius);
        System.out.println("The area is "+area+" and the circumference is "+circumference);
    }
}

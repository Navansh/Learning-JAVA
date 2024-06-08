package MTE_2.java;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class Student
{
    private String name;
    private int age;
    private int[][] marks = new int[3][3];

    Student(String name,int age, int[][] marks){
        this.name = name;
        this.age = age;
        this.marks = marks;
        System.out.println("The masti Student");
    }
    public int compareStudent(Student other){
        int total_marks_s1 = this.marks[0][0]+this.marks[0][1]+this.marks[0][2];
        int total_marks_s2 = other.marks[0][0]+other.marks[0][1]+other.marks[0][2];

        if (total_marks_s1>total_marks_s2)
        {
            return 1;
        }
        if (total_marks_s1==total_marks_s2)
        {
            return 0;
        }
        return -1;
    }
    public void updateScores(int courseNo, int examNo, int updated_marks)
    {
        if (courseNo<0||courseNo>2)
        {
            return;
        }
        if (examNo<0||examNo>2)
        {
            return;
        }
        this.marks[courseNo][examNo] = updated_marks;
    }
    public static boolean equals(Student s1, Student s2)
    {
        if (Objects.equals(s1.name, s2.name))
        {
            if (s1.age == s2.age)
            {
                if (Arrays.deepEquals(s1.marks, s2.marks))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
class Bc extends Student{

    Bc(String name, int age, int[][] marks) {
        super(name, age, marks);
        System.out.println("The masti is real in BC");
    }
    String str = null;
}
class Driver1{
    public static void main(String[] args) {
        int[][] marks1 = new int[3][3];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < marks1.length; i++) {
            for (int j = 0; j < marks1[i].length; j++) {
                System.out.println("Enter the marks");
                marks1[i][j] = sc.nextInt();
            }
        }
        int[][] marks2 = new int[3][3];
        for (int i = 0; i < marks2.length; i++) {
            for (int j = 0; j < marks2[i].length; j++) {
                System.out.println("Enter the marks of"+i+" and"+j);
                marks2[i][j] = sc.nextInt();
            }
        }
//        for (int[] i : marks1)
//        {
//            for (int j : i) {
//                System.out.println("Enter the marks of "+i+" and "+j);
//                marks1[i][j] = sc.nextInt();
//            }
//        }


        Student s1 = new Student("Rahul",18,marks1);
//        Student s2 = new Student("Rahul",18,marks2);
        Student s2 = new Bc("Rahukl",18,marks2);

//        System.out.println(Arrays.toString(marks1[1]));

    }
}

//class localmasti{
//
//
//}
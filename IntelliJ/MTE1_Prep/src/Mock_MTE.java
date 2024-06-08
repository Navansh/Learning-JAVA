import java.util.Scanner;

class Student
{
        private String name;
        private int age;
        private int[][] marks = new int[3][3];

        public String getName(){
            return this.name;
}

        Student(String name, int age )
        {
            this.name = name;
            this.age = age;
        }

//        public int compareStudent(Student other)
//        {
//
//        }







}
class BigO
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Student s1 = new Student("Jainam",42 );
        System.out.println(s1.getName());
    }
}
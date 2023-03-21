package Class_6.Comparing_Objects;

import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student> {
    int roll_no;
    int marks;

    public Student(int roll_no, int marks) {
        this.roll_no = roll_no;
        this.marks = marks;
    }


    @Override
    public int compareTo(Student other) {
        System.out.println("In compareTo");
        int difference = this.marks - other.marks;
        //hence if diff == 0 -> both are equal
        //if diff<0 : means other is bigger
        //if diff>0 : means other is smaller

        return difference;
    }

    @Override
    public String toString() {
        return marks + "";
    }

    public static void main(String[] args) {
        Student kunal = new Student(12,89);
        Student rahul = new Student(11,39);
        Student rahul1 = new Student(14,49);
        Student rahul2 = new Student(15,99);
        Student rahul3 = new Student(17,39);

        Student[] list = {kunal,rahul1,rahul,rahul3,rahul2};
        System.out.println(Arrays.toString(list));
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        //hence it sorted it here based on the marks, because we have done that in the compareTo function,
//        which the sort function uses internally

        //we can also specify how it should compare for this sort by specifically defining a compareTo function for it
        Arrays.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -(o1.marks - o2.marks);
                //added (-) sign to make it sort descending
            }
        });
        //can do the same with Lambda Expressions 👇
        Arrays.sort(list, (o1, o2) -> {
            return -(o1.marks - o2.marks);
            //added (-) sign to make it sort descending
        });


        if (kunal.compareTo(rahul) < 0 ){
            //so as to compare these objects we need to implement the Comparable Interface
            System.out.println("Kunal masti");
        }
        else {
            System.out.println("Dance masti");
        }
    }
}

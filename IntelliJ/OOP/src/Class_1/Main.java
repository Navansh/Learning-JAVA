package Class_1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Student[] students = new Student[5];
        //because we haven't initialized this object so if we try to print this array it will give null
//        System.out.println(Arrays.toString(students));

        Student heromasti = new Student();
        //this constructor calls another constructor
//        System.out.println(heromasti.name);

        Student one = new Student();
        Student two = one;
        //now both one and two(the ref vars) are pointing to the same object, so if I make any change using the
        //"two" reference variable object it would also reflect the same for the "one" ref var object

    }

    static class Student {
        int rno;
        String name;
        float marks;

        //a constructor can also call another constructor like
        Student(){
            this(13,"constructor calling constructor",100f);
            //this calls the other Student constructor
            //internally :new Student(13,"constructor calling constructor",100f);

        }
        Student(int rno,String name, float marks){
            this.rno = rno;
            this.name = name;
            this.marks = marks;

        }
    }
}
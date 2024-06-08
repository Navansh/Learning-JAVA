package Class_2;
//the outermost class cannot be static, only "inner" classes can be static
public class InnerClasses {
    static class Test{
        //if we make this non static then its dependent on the instance of the InnerClasses to create
        //an object for it, hence writing this "Test a = new Test("D");" will give an error in psvm
        static String name;
        public Test(String name) {
            this.name = name;
        }
    }
    public static void main(String[] args) {
        Test a = new Test("D");
        Test b = new Test("E");
        System.out.println(a.name);
        //when in constructow we wrote static String name, then it doesn't make anymore sense to call it using individual
        //reference variable as it is anyways same and single for the class, hence it will print Test.name
        //whether you call it by using a.name or b.name
        System.out.println(b.name);
        //and that's why when b updates it to E, so now when printing either a.name or b.name gives the same result
        //as it is anyways going to call Test.name on both times


    }
}


class Doitnow {
    //this cannot be static as it is the outermost class
}

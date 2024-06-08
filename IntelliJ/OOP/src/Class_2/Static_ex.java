package Class_2;

public class Static_ex {
    public static void main(String[] args) {
        Dance();

    }
    //this 👇 is not dependent on object and this doesn't belong to an instance
    static void doit(){
        System.out.println("Done");
    }

    //we know that something which is not static, belongs to an object, hence it 👇 is dependent on object
    //also means that, this 👇(Greet()) belongs to an instance, so without specifiying which instance does it belong to, We
    //cannot directly use it in a static method(psvm), as the function you are going to put this(Greet function) in
    //does not depend on instances
    void Greet(){
        doit();
        System.out.println("Hello");
    }
    //but to make it work inside a static function you can create an object for it and then through that object,
    //call the non-static function inside a static function, EX :->
    static void Dance(){
        //you cannot access non-static stuff w/o referencing their instances in a static context
        Static_ex ex1 = new Static_ex();
        ex1.Greet();
    }
}

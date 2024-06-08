package Class_6.Exception_Handling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
//            divide(a,b);
//            throw new Exception("Just for fun");
            //mimicking the exception
            String name = "Pikachu";
            if (name.equals("Pikachu")){
                throw new MyException("Beta tum pikachu ho");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }catch (ArithmeticException f){
            //more stricter exceptions are to be placed first than their generalized super classes
            //like here Arithmetic Exception and Exception
            System.out.println(f.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            System.out.println("No matter what happens but this will always execute");
        }
    }

     static int divide(int a, int b) throws ArithmeticException{
        if (b==0){
            throw new ArithmeticException("Bhai mat kara kar aise divide");
        }

        return a/b;
    }
}

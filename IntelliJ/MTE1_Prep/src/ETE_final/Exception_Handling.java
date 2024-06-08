package ETE_final;
public class Exception_Handling
{
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
//             divide(a,b);

            //mimicking an exception
            String name = "Navanshh";
            if (name.equals("Navansh")){
                throw new MyException("The name is Navansh");
            }

        } catch (MyException e){
            System.out.println(e.getMessage());
        }
        catch (ArithmeticException e)
        {
            System.out.println(e.getMessage());
            //hence when the new exception just for fun is executed the arithmetic expression is not
            //trigered as it not as Arithmetic Exception
        }
        catch (Exception e){
            System.out.println("A normal Exception");
        }
        //this cannot be placed above as then it will give error as more stricter catches are placed
        //above more general exception catches....
        finally
        {
            System.out.println("No matter what happens this will always execute");
        }



    }
    static int divide(int a,int b) throws ArithmeticException
    {
        if (b==0)
        {
            throw new ArithmeticException("Bhai 0 se divide mat kara kar");
        }
        return a/b;
    }
}

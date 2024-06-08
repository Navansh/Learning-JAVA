package ETE_final;
import java.util.Scanner;
class Salary{
    int salary;

    Salary(int salary) {
        this.salary = salary;
    }
    void show(){
        System.out.println("The salary of the person is"+salary);
    }
}
class TaxOnSalary extends Salary{
    int tax;
    TaxOnSalary(int salary) {
        super(salary);
    }
    int CalculateTax(){
        if (salary<=10000)
        {
            tax = (int) (salary*(0.1));
        } else if (salary < 100000 ) {
            tax = (int) (salary*(0.2));
        } else {
            tax = (int) (salary*(0.3));
        }
        return tax;
    }
    void show(){
        System.out.println("The tax added salary for the person is "+(CalculateTax()+salary));
    }

}
class Driver{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your salary");
        int salary = sc.nextInt();
        TaxOnSalary t1 = new TaxOnSalary(salary);
        t1.show();
    }
}


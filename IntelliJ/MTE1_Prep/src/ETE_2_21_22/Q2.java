package ETE_2_21_22;
abstract class Employee{
    private String empID;
    private String name;
    private double Salary;
    Employee(String empID,String name){
        this.empID = empID;
        this.name = name;
    }
    public abstract double ComputeSalary();

//    public <T> Comparable<T> getCity() {
//    }

    public double getSalary() {
        return 0;
    }
}
class SalariedEmployee extends Employee{

    double Salary;
    SalariedEmployee(String empID,String name,double Salary)
    {
        super(empID,name);
        this.Salary = Salary;
    }
    @Override
    public double ComputeSalary() {

        return Salary;
    }
}
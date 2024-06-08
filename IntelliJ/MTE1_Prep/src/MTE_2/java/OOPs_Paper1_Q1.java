package MTE_2.java;

import java.util.Objects;
import java.util.Scanner;

class BankAcct{
    int balance;
    int rate_of_interest;

    //constructor method
    BankAcct( int balance,int rate_of_interest){
        this.balance = balance;
        this.rate_of_interest = rate_of_interest;
    }

    protected static int Calculate_Interest(BankAcct other)
    {
        int interest = other.rate_of_interest* other.balance;
        other.balance = other.balance + interest;
        return other.balance;
    }
}
class Driver{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pass = sc.next();
        if (pass=="dance"){
            System.out.println("mas");
        }
        else return;
        BankAcct b1 = new BankAcct(4500,6);
        System.out.println(BankAcct.Calculate_Interest(b1));
    }
}
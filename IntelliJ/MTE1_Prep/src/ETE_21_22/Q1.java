package ETE_21_22;

import java.io.*;
class Exceptiondemo {
    public static void main(String args[]) throws ArithmeticException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        System.out.println("Sum is :"+(a+b));

//        int[] arr = new int[5];
//
//        arr[0] = 1;
//        arr[1] = 1;
//        System.out.println(arr.length);

    }
}
package Class_6;

import java.util.ArrayList;
import java.util.function.Consumer;

public class Lambda_Functions {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            arr.add(i+1);
        }

//        arr.forEach((item)->{
//            System.out.print(item*2);
//        });
        //Lambda Function

        Consumer<Integer> fun = (item) -> System.out.println(item*2);
        arr.forEach(fun);
        //because the forEach loop accepts a consumer type, so we first made one explicitly and then passed it

        //Lambda expressions are assigned to the variables that are of type interfaces because implementation is
        //provided in the lambda function body

        Operation sum = (a,b) -> a+b;
        Operation product = (a,b) -> a*b;
        Operation subtract = (a,b) -> a-b;
        Operation divide = (a,b) -> a/b;
        //we are storing this in a interface type(Operation) cz

    }

    int sum(int a,int b){
        return a+b;
    }
}

interface Operation {
    int operation(int a,int b);
}

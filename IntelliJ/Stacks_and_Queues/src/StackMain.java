public class StackMain {
    public static void main(String[] args) throws StackException {
        StackCustImple stack = new StackCustImple();
        StackCustImple custStack = new StackCustImple(45);

        stack.push(45);
        stack.push(45);
        stack.push(45);
        stack.push(45);
        stack.push(44);

//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());

        StackCustImple stackop = new DynamicStack();
        //using parent as the type

        stackop.push(44);
        stackop.push(43);
        stackop.push(42);
        stackop.push(41);
        stackop.push(45);
        stackop.push(46);
        stackop.push(47);
        stackop.push(48);
        stackop.push(49);
        stackop.push(41);
        stackop.push(42);
        stackop.push(43);


        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());
//        System.out.println(stackop.pop());


    }
}

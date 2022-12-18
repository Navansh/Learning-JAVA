package ETE_21_22;

public class Q4 {
    public static void main(String[] args) {
        // The first three arguments are the order number, customer name, and location
        String orderNumber = args[0];
        String customerName = args[1];
        String location = args[2];

        // The remaining arguments are the product number and price
        double totalPrice = 0;
        for (int i = 3; i < args.length; i += 2) {
            String productNumber = args[i];
            double productPrice = Double.parseDouble(args[i + 1]);
            totalPrice += productPrice;

            // Print the product details
            System.out.println("Product number: " + productNumber);
            System.out.println("Product price: " + productPrice);
        }

        // Print the order details
        System.out.println("Order number: " + orderNumber);
        System.out.println("Customer name: " + customerName);
        System.out.println("Location: " + location);
        System.out.println("Total price: " + totalPrice);
    }
}


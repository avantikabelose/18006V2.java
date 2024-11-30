import java.util.Scanner;
import java.util.Vector;

class IceCream 
{
    private Vector<String> flavors;
    private Vector<Double> flavorPrices;
    private Vector<String> toppings;
    private Vector<Double> toppingPrices;
    private int numScoops;
    private int numCups;
    private int numCones;
    private int numWaffles;

    private static final double SCOOP_PRICE = 20.0;
    private static final double CUP_PRICE = 30.0;
    private static final double CONE_PRICE = 40.0;
    private static final double WAFFLE_PRICE = 50.0;

    public IceCream()
    {
        this.flavors = new Vector<>();
        this.flavorPrices = new Vector<>();
        this.toppings = new Vector<>();
        this.toppingPrices = new Vector<>();
        this.numScoops = 0;
        this.numCups = 0;
        this.numCones = 0;
        this.numWaffles = 0;
    }

    public void addFlavor(String flavor, double price) 
    {
        flavors.add(flavor);
        flavorPrices.add(price);
    }

    public void addTopping(String topping, double price) 
    {
        toppings.add(topping);
        toppingPrices.add(price);
    }

    public void setNumScoops(int num) 
    {
        this.numScoops = num;
    }

    public void setNumCups(int num) 
    {
        this.numCups = num;
    }

    public void setNumCones(int num) 
    {
        this.numCones = num;
    }

    public void setNumWaffles(int num) 
    {
        this.numWaffles = num;
    }

    public double calculateTotal()
    {
        double total = 0;
        for (double price : flavorPrices) 
        {
            total += price;
        }
        total += (numScoops * SCOOP_PRICE);
        total += (numCups * CUP_PRICE);
        total += (numCones * CONE_PRICE);
        total += (numWaffles * WAFFLE_PRICE);
        for (double price : toppingPrices) 
        {
            total += price;
        }
        return total;
    }

    private void printItem(String name, int quantity, double pricePerUnit)
    {
        if (quantity > 0) 
        {
            System.out.printf("%s: %d (%.2f Rs.)\n", name, quantity, quantity * pricePerUnit);
        }
    }

    public void printReceipt() 
    {
        System.out.println("----- Receipt -----");
        System.out.println("Flavors:");
        for (int i = 0; i < flavors.size(); i++)
        {
            System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, flavors.get(i), flavorPrices.get(i));
        }

        printItem("Scoops", numScoops, SCOOP_PRICE);
        printItem("Cups", numCups, CUP_PRICE);
        printItem("Cones", numCones, CONE_PRICE);
        printItem("Waffles", numWaffles, WAFFLE_PRICE);

        System.out.println("Toppings:");
        for (int i = 0; i < toppings.size(); i++) 
        {
            System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, toppings.get(i), toppingPrices.get(i));
        }

        System.out.printf("Total Cost: %.2f Rs.\n", calculateTotal());
        System.out.println("-------------------");
    }
}

class IceCreamClientV 
{
    private static int customerCount = 0;
    private static final int MAX_CUSTOMERS = 100;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        Vector<String> flavors = new Vector<>();
        Vector<Double> flavorPrices = new Vector<>();
        flavors.add("Vanilla");
        flavors.add("Chocolate");
        flavors.add("Strawberry");
        flavors.add("Butterscotch");
        flavors.add("Mint");
        flavors.add("Mango");
        flavors.add("Coffee");
        flavors.add("Black Currant");
        flavors.add("Bubble Gum");
        flavors.add("Cookies & Cream");

        flavorPrices.add(100.0);
        flavorPrices.add(200.0);
        flavorPrices.add(150.0);
        flavorPrices.add(200.0);
        flavorPrices.add(120.0);
        flavorPrices.add(180.0);
        flavorPrices.add(160.0);
        flavorPrices.add(220.0);
        flavorPrices.add(190.0);
        flavorPrices.add(250.0);

        Vector<String> toppings = new Vector<>();
        Vector<Double> toppingPrices = new Vector<>();
        toppings.add("Nuts");
        toppings.add("Sprinkles");
        toppings.add("Chocolate Chips");
        toppings.add("Caramel");
        toppings.add("Whipped Cream");
        toppings.add("Cherry Crush");
        toppings.add("Oreo Crumbles");
        toppings.add("Jelly");
        toppings.add("Fruits");
        toppings.add("Coconut Flakes");

        toppingPrices.add(75.0);
        toppingPrices.add(55.0);
        toppingPrices.add(60.0);
        toppingPrices.add(45.0);
        toppingPrices.add(70.0);
        toppingPrices.add(75.0);
        toppingPrices.add(65.0);
        toppingPrices.add(50.0);
        toppingPrices.add(70.0);
        toppingPrices.add(55.0);

        while (customerCount < MAX_CUSTOMERS) 
        {
            System.out.println("\nCustomer " + (customerCount + 1) + " - Welcome to the Ice Cream Parlour!");
            IceCream iceCream = new IceCream();

            
            System.out.println("Choose flavors (0 to stop):");
            for (int i = 0; i < flavors.size(); i++)
            {
                System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, flavors.get(i), flavorPrices.get(i));
            }
            while (true) 
            {
                int flavorChoice = scanner.nextInt();
                if (flavorChoice == 0) break;
                if (flavorChoice > 0 && flavorChoice <= flavors.size())
                {
                    iceCream.addFlavor(flavors.get(flavorChoice - 1), flavorPrices.get(flavorChoice - 1));
                } 
                    else 
                    {
                    System.out.println("Invalid choice. Please select again.");
                }
            }

            
            System.out.println("How many scoops? (20 Rs. per scoop):");
            iceCream.setNumScoops(scanner.nextInt());

            System.out.println("How many cups? (30 Rs. per cup):");
            iceCream.setNumCups(scanner.nextInt());

            System.out.println("How many cones? (40 Rs. per cone):");
            iceCream.setNumCones(scanner.nextInt());

            System.out.println("How many waffles? (50 Rs. per waffle):");
            iceCream.setNumWaffles(scanner.nextInt());

           
            System.out.println("Choose toppings (0 to stop):");
            for (int i = 0; i < toppings.size(); i++)
            {
                System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, toppings.get(i), toppingPrices.get(i));
            }
            while (true)
           {
                int toppingChoice = scanner.nextInt();
                if (toppingChoice == 0) break;
                if (toppingChoice > 0 && toppingChoice <= toppings.size()) 
                {
                    iceCream.addTopping(toppings.get(toppingChoice - 1), toppingPrices.get(toppingChoice - 1));
                } 
                    else
                    {
                    System.out.println("Invalid choice. Please select a valid topping.");
                    }
            }

           
            iceCream.printReceipt();
            System.out.println("Thank you for your purchase!");
            customerCount++;
        }

        System.out.println("Maximum customer limit reached. Thank you for visiting!");
        scanner.close();
    }
}

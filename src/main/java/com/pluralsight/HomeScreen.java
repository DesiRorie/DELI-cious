package com.pluralsight;
import java.io.IOException;
import java.util.*;

//Import necessary functions - Only up to 179 is actual HomeScreen.
public class HomeScreen {
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        System.out.println("Welcome to the best possible iteration of Deli-Cious!");
        //Project strong confidence in the business.
        while (true) {
            System.out.println("1. New Order");
            System.out.println("2. Quit");
            System.out.println("What'll it be, hotshot?");
            String choice = keyboard.nextLine();
            //Switches get stitches, am I right??????
            switch (choice) {
                case "1":
                    OrderMenu orderMenu = new OrderMenu();
                    orderMenu.run();
                    break;
                //This will lead to the order menu, obviously.
                case "2":
                    System.out.println("Okay, bye, get out now please.");
                    System.exit(0);
                default:
                    System.out.println("WRONG!");
                    break;
                //Just in case someone gets reaaaaaal funny and puts the wrong input
            }}}}
class OrderMenu {
    public static Order customerOrder = new Order();
    private ArrayList<String> customSandwich;
    private ArrayList<String> drinks;
    private ArrayList<String> chips;
    private double totalPrice;

    public OrderMenu() {
        this.customSandwich = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.totalPrice = 0.00;
    }

    public void run() throws IOException {
        System.out.println("What'll be your order?:");
        while (true) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("1. Add sandwich.");
            System.out.println("2. Add drink.");
            System.out.println("3. Add chips.");
            System.out.println("4. Checkout.");
            System.out.println("0. Cancel ");
            String choice = keyboard.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Do you want a custom sandwich or order one of our signature sandwiches?");
                    System.out.println("1. Signature.");
                    System.out.println("2. Custom.");
                    int order = keyboard.nextInt();
                    int counter = 1;
                    if (order == 1) {
                        SignatureSandwich signatureSandwich = new SignatureSandwich();
                        //Display signature sandwiches
                        for (Sandwich sandwich : signatureSandwich.signatureSandwiches) {

                            System.out.println(counter + "." + sandwich.getDescription());
                            System.out.println();
                            counter++;
                        }
                        //ask user for what sandwich they want
                        System.out.println("What'll it be, hotshot?");
                        int userChoice = keyboard.nextInt();
                        keyboard.nextLine();

                        switch (userChoice) {
                            case 1:
                                customerOrder.addSandwich(signatureSandwich.signatureSandwiches.get(0));
                                System.out.println("Sandwich added to order!");
                                customerOrder.setSandwichPrices();
                                break;
                            case 2:
                                customerOrder.addSandwich(signatureSandwich.signatureSandwiches.get(1));
                                System.out.println("Sandwich added to order!");
                                customerOrder.setSandwichPrices();
                                break;
                            case 3:
                                customerOrder.addSandwich(signatureSandwich.signatureSandwiches.get(2));
                                System.out.println("Sandwich added to order!");
                                customerOrder.setSandwichPrices();
                                break;
                            case 4:
                                customerOrder.addSandwich(signatureSandwich.signatureSandwiches.get(3));
                                System.out.println("Sandwich added to order!");
                                customerOrder.setSandwichPrices();
                                break;
                            case 5:
                                customerOrder.addSandwich(signatureSandwich.signatureSandwiches.get(4));
                                System.out.println("Sandwich added to order!");
                                customerOrder.setSandwichPrices();
                                break;
                            case 6:
                                customerOrder.addSandwich(signatureSandwich.signatureSandwiches.get(5));
                                System.out.println("Sandwich added to order!");
                                customerOrder.setSandwichPrices();
                            default:
                                System.out.println("Pick a sandwich BOZO");
                        }


                    } else {

                        //this is the logic for buying and customizing sammiches
                        System.out.println("What size sandwich would you like?");

                        System.out.println("We have a 4 inch, 8 Inch, and 12 Inch.");
                        int size = keyboard.nextInt();
                        keyboard.nextLine();

                        System.out.println("Which bread would you like?");
                        System.out.println("We have White, Wheat, Rye, and Wraps.");
                        String bread = keyboard.nextLine().trim();
                        System.out.println("Would you like that toasted?");
                        String yn = keyboard.nextLine().trim();
                        boolean bool;
                        if (yn.equalsIgnoreCase("Yes")) {
                            bool = true;
                        } else {
                            bool = false;
                        }
                        boolean extraMeat;
                        boolean extraCheese;

                        List<String> meatToppings = Arrays.asList("Steak", "Ham", "Salami", "Roast Beef", "Chicken", "Herring", "Bacon", "Continue to cheese");
                        List<String> cheeseToppings = Arrays.asList("American", "Provolone", "Cheddar", "Swiss", "PepperJack", "Continue to vegetables");
                        List<String> vegToppings = Arrays.asList("Lettuce", "Peppers", "Onions", "Tomatoes", "Jalapenos", "Cucumbers", "Pickles", "Guacamole", "Mushrooms", "Continue to sauces");
                        List<String> sauceToppings = Arrays.asList("Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette", "Continue to sides");
                        List<String> sideToppings = Arrays.asList("Au Jus", "A1", "DELICIOUS RED 40" , "No more sides");
                        //D
                        Sandwich sandwich = new Sandwich(size, bread, bool);
                        //Meat Choice
                        int userChoice = 0;
                        System.out.println("Would like meat on your sandwich?");
                        System.out.println("1: Yes");
                        System.out.println("2: No");
                        userChoice = keyboard.nextInt();
                        keyboard.nextLine();

                        userMeat(userChoice, meatToppings, keyboard, sandwich);
                        userCheese(keyboard, cheeseToppings, sandwich);
                        userToppings(keyboard, vegToppings, sandwich);
                        userSauces(keyboard, sauceToppings, sandwich);
                        userSide(keyboard, sideToppings, sandwich);

                        addAndDisplaySandwich(sandwich);
                    }

                    break;
                case "2":
                    addDrink();
                    break;
                case "3":
                    addChips();
                    break;
                case "4":
                    checkout();
                    break;
                case "0":
                    System.out.println("Returning to main. You couldn't even handle our sandwiches anyways.");
                    return;
                default:
                    System.out.println("WRONG! STOP IT!");
                    break;

            }
        }
    }
//Methods for the HomeScreen and Arraylist

    private static void userMeat(int userChoice, List<String> meatToppings, Scanner keyboard, Sandwich sandwich) {
        if (userChoice == 1) {
            int moreMeatToppings = 1;

            while (moreMeatToppings != 8) {
                if (moreMeatToppings <= 7) {
                    System.out.println("These are our meat toppings");
                    for (int i = 1; i < meatToppings.size() + 1; i++) {
                        System.out.println(i + ":" + meatToppings.get(i - 1));
                    }
                    moreMeatToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    if (sandwich.meatToppings.size() > 1) {
                        sandwich.extraMeat();
                    }
                    sandwich.meatToppings.add(meatToppings.get(moreMeatToppings - 1));
                }
                if (sandwich.meatToppings.contains("Continue to cheese")) {
                    sandwich.meatToppings.remove(sandwich.meatToppings.size() - 1);
                }
                if (sandwich.meatToppings.isEmpty()) {

                    sandwich.meatToppings.add("No meat");
                } else {
                    System.out.println(sandwich.meatToppings);

                }
            }
        }
    }

    private static void userSide(Scanner keyboard, List<String> sideToppings, Sandwich sandwich) {
        int userChoice5 = 0;
        System.out.println("Would you like any sides with your sandwich?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        userChoice5 = keyboard.nextInt();
        keyboard.nextLine();
        if (userChoice5 == 1) {
            int moreSideToppings = 1;

            while (moreSideToppings != 4) {
                if (moreSideToppings <= 3) {
                    System.out.println("These are our sides");
                    for (int i = 1; i < sideToppings.size() + 1; i++) {
                        System.out.println(i + ":" + sideToppings.get(i - 1));
                    }

                    moreSideToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    sandwich.sideToppings.add(sideToppings.get(moreSideToppings - 1));
                }
                if (sandwich.sideToppings.isEmpty()) {

                    sandwich.sideToppings.add("No sides");
                } else {
                    System.out.println(sandwich.sideToppings);
                }
            }
        }

        if (sandwich.sideToppings.contains("No more sides")) {
            sandwich.sideToppings.remove(sandwich.sideToppings.size() - 1);
        }
    }

    private static void userCheese(Scanner keyboard, List<String> cheeseToppings, Sandwich sandwich) {
        int userChoice2 = 0;
        System.out.println("Would like cheese on your sandwich?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        userChoice2 = keyboard.nextInt();
        keyboard.nextLine();
        if (userChoice2 == 1) {
            int moreCheeseToppings = 1;

            while (moreCheeseToppings != 6) {
                if (moreCheeseToppings <= 5) {
                    System.out.println("These be the cheeses toppings");
                    for (int i = 1; i < cheeseToppings.size() + 1; i++) {
                        System.out.println(i + ":" + cheeseToppings.get(i - 1));
                    }

                    moreCheeseToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    if (sandwich.cheeseToppings.size() > 1) {
                        sandwich.extraCheese();
                    }
                    sandwich.cheeseToppings.add(cheeseToppings.get(moreCheeseToppings - 1));
                }
                if (sandwich.cheeseToppings.contains("Continue to vegetables")) {
                    sandwich.cheeseToppings.remove(sandwich.cheeseToppings.size() - 1);
                }
                if (sandwich.cheeseToppings.isEmpty()) {
                    sandwich.cheeseToppings.add("No cheese");
                } else {

                    System.out.println(sandwich.cheeseToppings);
                }
            }
        }
    }

    private static void userSauces(Scanner keyboard, List<String> sauceToppings, Sandwich sandwich) {
        int userChoice4 = 0;
        System.out.println("Would you like any sauces on your sandwich?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        userChoice4 = keyboard.nextInt();
        keyboard.nextLine();
        if (userChoice4 == 1) {
            int moreSauceToppings = 1;

            while (moreSauceToppings != 7) {
                if (moreSauceToppings <= 6) {
                    System.out.println("These are our sauces");
                    for (int i = 1; i < sauceToppings.size() + 1; i++) {
                        System.out.println(i + ":" + sauceToppings.get(i - 1));
                    }

                    moreSauceToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    sandwich.sauceToppings.add(sauceToppings.get(moreSauceToppings - 1));
                }
                if (sandwich.sauceToppings.contains("Continue to sides")) {
                    sandwich.sauceToppings.remove(sandwich.sauceToppings.size() - 1);
                }
                if (sandwich.sauceToppings.size() < 1) {
                    sandwich.sauceToppings.add("No sauces");
                } else {

                    System.out.println(sandwich.sauceToppings);
                }
            }
        }
    }

    private static void userToppings(Scanner keyboard, List<String> vegToppings, Sandwich sandwich) {
        int userChoice3 = 0;
        System.out.println("Would you like vegetables on your sandwich?");
        System.out.println("1: Yes");
        System.out.println("2: No");
        userChoice3 = keyboard.nextInt();
        keyboard.nextLine();
        if (userChoice3 == 1) {
            int moreVegetableToppings = 1;

            while (moreVegetableToppings != 10) {
                if (moreVegetableToppings <= 9) {
                    System.out.println("These are our vegetables");
                    for (int i = 1; i < vegToppings.size() + 1; i++) {
                        System.out.println(i + ":" + vegToppings.get(i - 1));
                    }
                    moreVegetableToppings = keyboard.nextInt();
                    keyboard.nextLine();
                    sandwich.vegetableToppings.add(vegToppings.get(moreVegetableToppings - 1));
                }
                if (sandwich.vegetableToppings.contains("Continue to sauces")) {
                    sandwich.vegetableToppings.remove(sandwich.vegetableToppings.size() - 1);
                }
                if (sandwich.vegetableToppings.isEmpty()) {
                    sandwich.vegetableToppings.add("No veggies");
                } else {

                    System.out.println(sandwich.vegetableToppings);
                }
            }
        }
    }

    private void addDrink() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Select your size:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.print("Enter your choice: ");
        //Drink options
        String sizeChoice = keyboard.nextLine();
        Map<String, Double> drinkPrices = new HashMap<>();
        //Logic for prices.
        drinkPrices.put("1", 2.0);
        drinkPrices.put("2", 2.5);
        drinkPrices.put("3", 3.0);
        //Your options, monsieur.
        if (drinkPrices.containsKey(sizeChoice)) {
            System.out.println("Select a drink:");
            System.out.println("1. Coke.");
            System.out.println("2. Pepsi.");
            System.out.println("3. Fanta.");
            System.out.println("4. CheerWine.");
            System.out.println("5. Diet Dr. Kelp");
            System.out.println("6. Bleach.");
            System.out.print("What'll it be?: ");
            int drinkChoice = keyboard.nextInt();
            List<String> drinks = Arrays.asList("Coke", "Pepsi", "Fanta", "CheerWine", "Diet Dr. Kelp", "Bleach");
            customerOrder.drinks.add(drinks.get(drinkChoice - 1));//Add To Array For Display Later

            //Calculate the drank price.

            double drinkPrice = drinkPrices.get(sizeChoice);
            customerOrder.setDrinkorChipTotal(drinkPrice);


        } else {
            System.out.println("You're embarrassing yourself, KNOCK IT OFF BOZO!");
        }
    }

    private void addChips() {
        Scanner keyboard = new Scanner(System.in);
        //Present the options
        System.out.println("Your chip selection:");
        System.out.println("1. Doritos.");
        System.out.println("2. Sun Chips.");
        System.out.println("3. Fun-Yuns.");
        System.out.println("4. Cheetos.");
        System.out.println("5. Lays.");
        System.out.println("6. Organic kind that nobody buys.");
        System.out.print("What'll it be?: ");
        int chipChoice = keyboard.nextInt();
        //Logic below for adding chips

        double chipPrice = 1.50;
        customerOrder.setDrinkorChipTotal(chipPrice);
        System.out.println("Chips added.");
        List<String> chip = Arrays.asList("Doritos", "Sun Chips", "Fun-Yuns", "Cheetos", "Lays", "Organic kind that nobody buys");
        customerOrder.chips.add(chip.get(chipChoice - 1));

    }
//Checkout Method
// This method adds the user created sandwich to the order and then displays the details of every sandwich that the order has.

 private static void addAndDisplaySandwich(Sandwich sandwich) {
        customerOrder.sandwiches.add(sandwich);
        for (Sandwich sandwiches : customerOrder.sandwiches) {
            System.out.println(sandwiches.getBread() + " " + sandwiches.getSize() + sandwiches.meatToppings + sandwiches.cheeseToppings + sandwiches.sauceToppings + sandwiches.vegetableToppings + sandwiches.sideToppings);
            //test price output
            for (Sandwich sandwichess : customerOrder.sandwiches) {
                sandwichess.getTotalPrice();
            }
        }
        customerOrder.setSandwichPrices();
    }
    private void checkout() throws IOException {
        System.out.println("Order Details: ");
        //This is where the details will go
        System.out.print("Drinks: ");
        for (String drinks : customerOrder.drinks) {
            if (customerOrder.drinks.isEmpty()) {
                System.out.print("No Drink");
            } else {
                System.out.println(drinks);
            }
        }

        System.out.print("Chips: ");
        for (String chips : customerOrder.chips) {
            if (customerOrder.chips.isEmpty()) {
                System.out.print("No Chips");
            } else {
                System.out.println(chips);
            }
        }
            //Output Custom Sandwich
            System.out.print("Sandwich: ");
            for (Sandwich sandwiches : customerOrder.sandwiches) {
                System.out.print("Bread: " + sandwiches.getBread() + " Size: " + sandwiches.getSize() + " ");


                if(!sandwiches.meatToppings.isEmpty()){
                    System.out.print(sandwiches.meatToppings + " ");
                }
                if(!sandwiches.cheeseToppings.isEmpty()){
                    System.out.print(sandwiches.cheeseToppings + " ");
                }
                if(!sandwiches.sauceToppings.isEmpty()){
                    System.out.print(sandwiches.sauceToppings + " ");
                }
                if(!sandwiches.vegetableToppings.isEmpty()){
                    System.out.print(sandwiches.vegetableToppings + " ");
                }
                if(!sandwiches.sideToppings.isEmpty()){
                    System.out.print(sandwiches.sideToppings + " ");
                }

                for (Sandwich sandwichess : customerOrder.sandwiches) {
                    sandwichess.getTotalPrice();
                }
            }

            System.out.printf("Total Price: $ %.2f", customerOrder.getTotal());
            System.out.println();
            //Here's where the total price will be displayed
            System.out.println("Thank you for coming in! Now get out. There's a fee if you stand around.");
            Receipt receipt = new Receipt();
            receipt.write(customerOrder);
            System.exit(0);

    }
}
//Since you got to the bottom of the code, here's some fun facts!
//There's more stars in the observable universe than grains of sand on every beach on Earth.
// The seeds of apples have natural cyanide in them.
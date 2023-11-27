package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
//Import necessary functions.
public class HomeScreen {
    private static final Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Welcome to the best possible iteration of Deli-Cious!");
        //Project strong confidence in the business.
        while (true) {
            System.out.println("1. New Order");
            System.out.println("2. Quit");
            System.out.println("What'll it be, hotshot?");
            String choice = keyboard.nextLine();
            //Switches get stitches, am i right??????
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
    private ArrayList<String> customSandwich;
    private ArrayList<String> drinks;
    private ArrayList<String> chips;
    private double totalPrice;
    public OrderMenu() {
        this.customSandwich = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
        this.totalPrice = 0.0;
    }
    public void run() {
        while (true) {
            Scanner order = new Scanner(System.in);
            System.out.println("What'll be your order?:");
            System.out.println("1. Add sandwich.");
            System.out.println("2. Add drink.");
            System.out.println("3. Add chips.");
            System.out.println("4. Checkout.");
            System.out.println("0. Cancel order");
            String choice = order.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Redirecting to customize sandwich screen.");
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
            }}}
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
        drinkPrices.put("1", 2.00);
        drinkPrices.put("2", 2.50);
        drinkPrices.put("3", 3.00);
//Your options, monsieur.
        if (drinkPrices.containsKey(sizeChoice)) {
            System.out.println("Select a drink:");
            System.out.println("1. Coke.");
            System.out.println("2. Pepsi.");
            System.out.println("3. Fanta.");
            System.out.println("4. Cheerwine.");
            System.out.println("5. A&W.");
            System.out.println("6. Bleach.");
            System.out.print("What'll it be?: ");
            String drinkChoice = keyboard.nextLine();
            //Calculate the drank price.
            drinks.add(drinkChoice);
            double drinkPrice = drinkPrices.get(sizeChoice);
            totalPrice += drinkPrice;
            System.out.println("Added. Size: " + sizeChoice + ", Price: $" + drinkPrice);
        } else {
            System.out.println("You're embarassing yourself, KNOCK IT OFF BOZO!");
        }}
    private void addChips() {
        Scanner keyboard = new Scanner(System.in);
        //Present the options
        System.out.println("Your chip selection:");
        System.out.println("1. Doritos.");
        System.out.println("2. Sun Chips.");
        System.out.println("3. Funyuns.");
        System.out.println("4. Cheetos.");
        System.out.println("5. Lays.");
        System.out.println("6. Organic kind that nobody buys.");
        System.out.print("What'll it be?: ");
        //Logic below for adding chips
        String chipsChoice = keyboard.nextLine();
        chips.add(chipsChoice);
        totalPrice += 1.50;
        System.out.println("Chips added.");
    }
    private void checkout() {
        System.out.println("Order Details:");
        //This is where the details will go
        System.out.println("Drinks: " + drinks);
        System.out.println("Chips: " + chips);
        System.out.println("Total Price: $" + totalPrice);
        //Here's where the total price will be displayed
        System.out.println("Thank you for coming in! Now get out. There's a fee if you stand around.");
        System.exit(0);
    }
}

//Since you got to the bottom of the code, here's a fun fact
//There's more stars in the observable universe than grains of sand on every beach on Earth.



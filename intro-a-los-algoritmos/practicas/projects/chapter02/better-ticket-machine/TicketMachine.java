/**
 * TicketMachine models a ticket machine that issues
 * flat-fare tickets.
 * The price of a ticket is specified via the constructor.
 * Instances will check to ensure that a user only enters
 * sensible amounts of money, and will only print a ticket
 * if enough money has been input.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29
 */
public class TicketMachine {
    // The price of a ticket from this machine.
    private int price;
    // The amount of money entered by a customer so far.
    private int balance;
    // The total amount of money collected by this machine.
    private int total;
    // The indicator for when a custmer selects the price with discount.
    private boolean isDiscounted;
    // The discount percentage.
    private int discountPercentage;
    // The discount price
    private int originalDiscount;

    /**
     * Create a machine that issues tickets of the given price.
     *
     * Precondición:  cost > 0
     * Postcondición: cost >= 0 && balance == 0&& total == 0 && repOK()
     */
    public TicketMachine(int cost, int discountPercentage) {
        assert cost >= 0 : "You can't add a cost less then 0.";
        assert discountPercentage > 0 : "You can't add a discount percentage less than 1";
        price = cost;
        balance = 0;
        total = 0;
        isDiscounted = false;
        this.discountPercentage = discountPercentage;
        assert repOK();
    }

    // Class invariant
    public boolean repOK(){
        boolean isValid = true;
        if(price < 0 || balance < 0 || total < 0){
            isValid = false;
        }
        return isValid;
    }

    // Select if a client wants the discount or not
    public void switchDiscount() {
        if (!isDiscounted) {
            this.originalDiscount = (int) Math.round(price * (discountPercentage / 100.0));
            price = price - this.originalDiscount;
            System.out.println("You have selected the discount: " + price);
            isDiscounted = true;
        } else {
            price = price + originalDiscount;
            System.out.println("You have selected the normal price: " + price);
            isDiscounted = false;
        }
        assert repOK();
    }

    /**
     * @Return The price of a ticket.
     */
    public int getPrice() {
        return price;
    }

    /**
     * Return The amount of money already inserted for the
     * next ticket.
     */
    public int getBalance() {
        return balance;
    }

    /**
     * Receive an amount of money from a customer.
     * Check that the amount is sensible.
     */
    public void insertMoney(int amount) {
        assert amount >= 0 : "Use a positive amount rather than: " + amount;
        int prevBalance = balance;
        balance = balance + amount;

        assert balance == prevBalance + amount : "Error";
    }

    /**
     * Print a ticket if enough money has been inserted, and
     * reduce the current balance by the ticket price. Print
     * an error message if more money is required.
     */
    public void printTicket() {
        int amountLeftToPay = price - balance;
        if (balance >= price) {
            // Simulate the printing of a ticket.
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println("# Ticket");
            System.out.println("# " + price + " cents.");
            System.out.println("##################");
            System.out.println();

            // Update the total collected with the price.
            total = total + price;
            // Reduce the balance by the price.
            balance = balance - price;
        } else {
            System.out.println("You must insert at least: " +
                    (amountLeftToPay) + " more cents.");

        }
    }

    /**
     * Return the money in the balance.
     * The balance is cleared.
     */
    public int refundBalance() {
        int amountToRefund;
        amountToRefund = balance;
        balance = 0;
        return amountToRefund;
    }

    // Ejercicio 2.61
    public int emptyMachine() {
        int oldTotal = this.total;
        total = 0;
        return oldTotal;
    }
}

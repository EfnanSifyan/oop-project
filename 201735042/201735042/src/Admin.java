import java.util.Scanner;

public class Admin {

    public String username;
    public String password;
    public final int SELL = 1;
    public final int STOCK = 2;
    public Stock<Item> stock;

    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
        stock = new Stock<Item>();
    }

    public void choose(int choice, Item item, String type, int count, String itemName){

        if(choice != SELL && choice != STOCK){
            System.out.println("Invalid choice.");
            return;
        }

        if(choice == STOCK){


                System.out.println("Enter 0 to log out");
                System.out.println(" --- OPTIONS ---");
                System.out.println("1- Add Item to stock");
                System.out.println("2- Print stock operation history");
                System.out.println("3- Print stock by its category");

                Scanner scanner = new Scanner(System.in);
                int choiceForStock = scanner.nextInt();

                while(choiceForStock < 0 || choiceForStock > 3){
                    System.out.println("Invalid choice. Enter again: ");
                    choiceForStock = scanner.nextInt();
                }

                if(choiceForStock == 0){
                    return;
                }

                if(choiceForStock == 1){
                    stock.addItem(item);
                }

                if(choiceForStock == 2){
                    System.out.println("\n\n" + stock.stockLog);
                }

                if(choiceForStock == 3){
                    stock.findByType(type);
                }


        }

        if(choice == SELL){
            System.out.println("A customer just bought " + count + " amounts of " + itemName);
            stock.sellItem(itemName, count);
        }

    }

}

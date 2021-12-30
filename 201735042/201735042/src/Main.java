import java.util.*;


public class Main {

    public static void main(String[] args) {
        Admin admin = new Admin("efnansifyan" , "349243");

        Item wearing1 = new Wearing(WearingType.Pants, "Levi's", 100, 350);
        Item wearing2 = new Wearing(WearingType.Sweater, "Nike Sweater", 100, 450);
        Item shoes1 = new Shoes(ShoeType.Boots, "Lumberjack", 100, 500);
        Item shoes2 = new Shoes(ShoeType.Boots, "Nike Boot", 100, 750);



        int count = 0;


        ArrayList<Item> list = new ArrayList<>();
        list.add(wearing1);
        list.add(wearing2);
        list.add(shoes1);
        list.add(shoes2);
        count = list.size();


        Scanner scanner = new Scanner(System.in);
        String username;
        String password;
        while(true){

            System.out.println("Write quit to quit.");
            System.out.println("     - LOGIN -");
            System.out.println(" Username: ");
            username = scanner.next();
            System.out.println(" Password: ");
            password = scanner.next();

            if(username == "quit" || password == "quit"){
                return;
            }



            if(!username.equals(admin.username)){
                System.out.println("Account does not exist, try again");
                continue;
            } else if(!password.equals(admin.password)) {
                System.out.println("Incorrect password, try again");
                continue;
            }

            while(true){
                System.out.println("Enter 0 to log off");
                System.out.println("Welcome " + username + ", Which operation do you want to do:\n 1-Sell \n2-Stock");
                int choice = scanner.nextInt();
                if(choice == 0){
                    return;
                }

                Item item;
                if(list.isEmpty()){
                    item = null;
                } else {
                    item = list.remove(count - 1);
                    count--;
                }

                if(choice == 1){

                }

                admin.choose(choice, item, ShoeType.Boots.toString(), 10, "Nike Boot");


            }



        }

    }
}

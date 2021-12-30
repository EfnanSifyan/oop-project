import java.util.*;


// Generic class is used.

public class Stock<T>{

    public ItemPrinter printer;
    // Generic collection is used.
    public ArrayList<T> stockItems;
    public String stockLog;

    public<T> Stock(){
        stockItems = new ArrayList<>();
        stockLog = "";
        // Lambda is used.
        printer = item -> System.out.println(item);
    }


    public void addItem(T item){
        boolean doesExist = false;
        if(item instanceof Item){
            for(int i = 0; i < stockItems.size(); i++){
                Item itemOnList = (Item) stockItems.get(i);
                if(itemOnList.name.equals(((Item) item).name)){
                    System.out.println("This item already exists");
                    doesExist = true;
                    break;
                }

            }
            if(doesExist){
                return;
            } else {
                stockItems.add(item);
                stockLog += ((Item) item).name + " is added to the stock\n";
            }

        } else {
            System.out.println("ERROR --> You cannot add this class to the list.");
        }
    }

    public int getStockCount(T item){
        if(item instanceof Item){
            for(int i = 0; i < stockItems.size(); i++){
                Item itemOnList = (Item) stockItems.get(i);
                if(itemOnList.name == ((Item) item).name){
                    stockLog += itemOnList.countInStock + " is returned from the stock\n";
                    return itemOnList.countInStock;
                }

            }
        }
        return -1;
    }

    public void sellItem(String itemName, int count){
        for(int i = 0; i < stockItems.size(); i++){
            Item itemOnList = (Item) stockItems.get(i);
            if(itemOnList.name == itemName){

                if(count == ((Item) stockItems.get(i)).countInStock){
                    stockItems.remove(i);

                } else {
                    ((Item) stockItems.get(i)).countInStock -= count;
                }
                stockLog += itemOnList.countInStock + " is sold\n";
            }

        }
    }


    public void findByType(String type){
        if(isWearing(type)){
            System.out.println("Enter a wearing type:\n1-Tshirt\n" +
                    "2-Pants\n" +
                    "3-Underwear\n" +
                    "4-Sweater\n" +
                    "5-Jacket");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            while(choice < 1 || choice > 5){
                System.out.println("Enter choice again");
                choice = scanner.nextInt();
            }
            WearingType typeEnum = null;

            switch(choice){
                case 1:
                    typeEnum = WearingType.Tshirt;
                    break;
                case 2:
                    typeEnum = WearingType.Pants;
                    break;
                case 3:
                    typeEnum = WearingType.Underwear;
                    break;
                case 4:
                    typeEnum = WearingType.Sweater;
                    break;
                case 5:
                    typeEnum = WearingType.Jacket;
                    break;

            }

            Item itemOnList;

            for(int i = 0; i < stockItems.size(); i++){
                itemOnList = ((Item) stockItems.get(i));
                if(itemOnList instanceof Wearing){
                    if(((Wearing) itemOnList).wearingType == typeEnum){
                        System.out.println(i + "-");
                        printer.printItem(itemOnList);
                        stockLog += itemOnList.name + " is searched\n";
                    }

                }

            }


        } else if(isShoe(type)){

            System.out.println("Enter a shoe type:\n 1-Sports\n" +
                    "2-Sneaker\n" +
                    "3-Boots");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            while(choice < 1 || choice > 3){
                System.out.println("Enter choice again");
                choice = scanner.nextInt();
            }
            ShoeType typeEnum = null;

            switch(choice){
                case 1:
                    typeEnum = ShoeType.Sports;
                    break;
                case 2:
                    typeEnum = ShoeType.Sneaker;
                    break;
                case 3:
                    typeEnum = ShoeType.Boots;
                    break;

            }

            Item itemOnList;


            for(int i = 0; i < stockItems.size(); i++){
                itemOnList = ((Item) stockItems.get(i));
                if(itemOnList instanceof Shoes){
                    if(((Shoes) itemOnList).shoeType == typeEnum){
                        System.out.println(i + "-");
                        printer.printItem(itemOnList);
                        stockLog += itemOnList.name + " is searched\n";
                    }

                }

            }
        }
    }

    public boolean isWearing(String type){
        return (type.equals(WearingType.Tshirt.toString()) || type.equals(WearingType.Pants.toString()) ||
                type.equals(WearingType.Underwear.toString()) || type.equals(WearingType.Sweater.toString()) ||
                type.equals(WearingType.Sweater.toString()) || type.equals(WearingType.Jacket.toString()));
    }

    public boolean isShoe(String type){
        return (type.equals(ShoeType.Sports.toString()) ||
                type.equals(ShoeType.Sneaker.toString()) ||
                type.equals(ShoeType.Boots.toString()));

    }


}

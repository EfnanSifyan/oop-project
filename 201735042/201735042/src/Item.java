public abstract class Item {

    // Abstract Item class for Inheritence

    public String name;
    public int countInStock;
    public double price;

    public Item(String name, int countInStock, double price) {
        this.name = name;
        this.countInStock = countInStock;
        this.price = price;
    }

    @Override
    public String toString() {
        return "\t\t" + name + " ---- " + price + " ---- " + countInStock;
    }
}

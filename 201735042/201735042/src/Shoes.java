public class Shoes extends Item{


    public ShoeType shoeType;

    public Shoes(ShoeType shoeType, String name, int countInStock, double price) {
        super(name, countInStock, price);
        this.shoeType = shoeType;
    }

    @Override
    public String toString() {
        return "\t\t" + shoeType + "--> " + name + " ---- " + countInStock;
    }
}

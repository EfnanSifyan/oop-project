
public class Wearing extends Item{


    public WearingType wearingType;

    public Wearing(WearingType wearingType, String name, int countInStock, double price) {
        super(name, countInStock, price);
        this.wearingType = wearingType;
    }

    // Polymorphism is Used. Because when this object will be printed. The inherited object's to_String will execute.
    @Override
    public String toString() {
        return "\t\t" + wearingType + "--> " + name + " ---- " + countInStock + " ---- " + price;
    }
}

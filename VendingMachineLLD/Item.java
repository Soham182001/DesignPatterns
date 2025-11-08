package VendingMachineLLD;

public class Item {

    ItemType type;
    int price;

    public Item(){

    }

    public ItemType getType(){
        return this.type;
    }

    public void setType(ItemType type){
        this.type = type;
    }

    public int getPrice(){
        return this.price;
    }

    public void setPrice(int price){
        this.price = price;
    }
    
}

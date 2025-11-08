package VendingMachineLLD;

public class Inventory {
    ItemShelf [] inventory = null;

    public Inventory (int itemCount){
        this.inventory = new ItemShelf[itemCount];
        this.initialEmptyInventory();
    }

    public ItemShelf[] getInventory(){
        return this.inventory;
    }

    public void setInventory(ItemShelf[] inventory){
        this.inventory = inventory;
    }


    public void initialEmptyInventory() {
        int startCode = 101;

        for(int i=0; i<inventory.length; i++){
            ItemShelf space = new ItemShelf();
            space.setCode(startCode);
            space.setSoldOut(true);
            this.inventory[i] = space;
            ++startCode;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception{
        ItemShelf[] var3 = this.inventory;
        int var4 = var3.length;
        for(int var5 = 0; var5<var4; var5++){
            ItemShelf itemShelf = var3[var5];
            if(itemShelf.code == codeNumber){
                if(!itemShelf.soldOut){
                    throw new Exception("Item already present in Machine");
                }
                itemShelf.item = item;
                itemShelf.setSoldOut(false);
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {
        ItemShelf[] var2 = this.inventory;
        int var3 = var2.length;

        for(int var4=0; var4<var3; ++var4){
            ItemShelf itemShelf = var2[var4];
            if(itemShelf.code == codeNumber){
                if(itemShelf.isSoldOut()){
                    throw new Exception("Item already sold out");
                }
            }
            return itemShelf.item;
        }

        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        ItemShelf[] var2 = this.inventory;
        int var3 = var2.length;

        for(int var4 = 0; var4<var3; ++var4){
            ItemShelf itemShelf = var2[var4];
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }
}

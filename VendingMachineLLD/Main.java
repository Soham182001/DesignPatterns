package VendingMachineLLD;

import java.io.PrintStream;

import VendingMachineLLD.States.State;
import VendingMachineLLD.VendingMachine.VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        try{
            System.out.println("|");
            System.out.println("filling up inventory");
            System.out.println("|");

            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");

            State vendingState = vendingMachine.getVendingMachineState();
            vendingState.clickOnInsertCoinButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);
            vendingState = vendingMachine.getVendingMachineState();
            vendingState.chooseProduct(vendingMachine, 102);
            displayInventory(vendingMachine);
        } catch (Exception e) {
            displayInventory(vendingMachine);
        }

    }
    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();

        for(int i=0; i<slots.length; i++){
            Item newItem = new Item();
            if(i>=0 && i<3){
                newItem.setPrice(12);
                newItem.setType(ItemType.COKE);
            }
            else if(i>=3 && i<5){
                newItem.setPrice(14);
                newItem.setType(ItemType.JUICE);
            }
            else if(i>=5 && i<7){
                newItem.setPrice(17);
                newItem.setType(ItemType.PEPSI);
            }
            else if(i>=7 && i<10){
                newItem.setPrice(10);
                newItem.setType(ItemType.SODA);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for(int i=0; i<slots.length; i++){
            PrintStream var1000 = System.out;
            int var10001 = slots[i].getCode();
            var1000.println("CodeNumber: " + var10001 + " Item: " + slots[i].getItem().getType().name() + " Price: " + slots[i].getItem().getPrice() + " isAvailable: " + !slots[i].isSoldOut());
        }
    }
}

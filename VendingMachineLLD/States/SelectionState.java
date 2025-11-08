package VendingMachineLLD.States;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;

import VendingMachineLLD.Coin;
import VendingMachineLLD.Item;
import VendingMachineLLD.VendingMachine.VendingMachine;

public class SelectionState implements State{

    public SelectionState(){
        System.out.println("Currently machine is in Selection State");
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot click this button in SelectionState");
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("You cannot insert coin in SelectionState");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        int paidByUser = 0;

        Coin coin;
        for(Iterator var5 = vendingMachine.getCoinList().iterator(); var5.hasNext(); paidByUser += coin.value) {
            coin = (Coin)var5.next();
        }

        if(paidByUser < item.getPrice()){
            PrintStream var1000 = System.out;
            int var1001 = item.getPrice();
            var1000.println("Insufficient Amount, Product you selected is for price: " + var1001 + " and you paid: " + paidByUser);
            this.refundFullMoney(vendingMachine);
            throw new Exception("Insufficient Amount");
        } else {
            if(paidByUser >= item.getPrice()){
                if(paidByUser > item.getPrice()){
                    this.getChange(paidByUser - item.getPrice());
                }

                vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, codeNumber));
            }
        }

    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        System.out.println("Returned the change in the Coin Dispense Tray: " + returnChangeMoney);
        return returnChangeMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseProduct'");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount back in the Coin Dispense Tray");
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return vendingMachine.getCoinList();
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateInventory'");
    }

    
}

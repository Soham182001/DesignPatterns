package VendingMachineLLD.States;

import java.util.ArrayList;
import java.util.List;

import VendingMachineLLD.Coin;
import VendingMachineLLD.Item;
import VendingMachineLLD.VendingMachine.VendingMachine;

public class IdleState implements State {

    public IdleState(){
        System.out.println("Currently vending machine is in Idle State");
    }

    public IdleState(VendingMachine vendingMachine){
        System.out.println("Currently vending machine is in IdleState");
        vendingMachine.setCoinList(new ArrayList());
    }

    @Override
    public void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("First you need to click on insert coin button");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("Cannot insert coin in Idle State'");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Cannot choose product in Idle state");
    }

    @Override
    public int getChange(int returnChangeMoney) throws Exception {
        throw new Exception("Cannot get change in Idle State");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new Exception("Cannot dispense product in Idle State");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("Cannot get refunded in Idle State");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception {
        throw new Exception("Unimplemented method 'updateInventory'");
    }
    
}

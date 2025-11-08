package VendingMachineLLD.States;

import VendingMachineLLD.VendingMachine.VendingMachine;

import java.util.List;

import VendingMachineLLD.Coin;
import VendingMachineLLD.Item;

public interface State {

    void clickOnInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    void clickOnStartProductSelectionButton(VendingMachine vendingMachine) throws Exception;
    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    void chooseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    int getChange(int returnChangeMoney) throws Exception;
    Item dispenseProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;
    void updateInventory(VendingMachine vendingMachine, Item item, int codeNumber) throws Exception;

}

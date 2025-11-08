package VendingMachineLLD.VendingMachine;

import java.util.ArrayList;
import java.util.List;

import VendingMachineLLD.Coin;
import VendingMachineLLD.Inventory;
import VendingMachineLLD.States.IdleState;
import VendingMachineLLD.States.State;

public class VendingMachine {

    private State vendingMachineState;
    private List<Coin> coinList = new ArrayList<>();
    private Inventory inventory = new Inventory(10);


    public VendingMachine(){
        vendingMachineState = new IdleState();
    }

    public State getVendingMachineState(){
        return this.vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState){
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory(){
        return this.inventory;
    }

    public void setInventory(Inventory inventory){
        this.inventory = inventory;
    }

    public List<Coin> getCoinList(){
        return this.coinList;
    }

    public void setCoinList(List<Coin> coinList){
        this.coinList = coinList;
    }

}

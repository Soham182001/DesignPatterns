package VendingMachineLLD;

public enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    public int value;

    private Coin(int value) {
        this.value = value;
    }
}

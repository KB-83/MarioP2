package logic.modelstructure.backgroundobject.block;

public class FullCoinBlock extends Block{
    private int numOfCoins;
    public FullCoinBlock() {
        numOfCoins = 5;
    }

    public int getNumOfCoins() {
        return numOfCoins;
    }

    public void setNumOfCoins(int numOfCoins) {
        this.numOfCoins = numOfCoins;
    }
}

public class CoinPurse {

    private int amount;
    public void addTo(Coin c){
	amount = amount + c.getValue();
    }
    public void removeFrom(Coin c) {
	amount = amount - c.getValue();
    }
}



public class CoinPurse{
    private int amount;

    public CoinPurse(){
	amount = 0;
    }
    public void addTo(Coin.c){
	amount = amount + c.getValue();
    }
    public void removeFrom(Coin.c){
	if (amount > c.getValue())
	    { amount = amount - c.getvalue();}
    }	
    public int getAmount(){
	return amount;
    }
 
}



public class GumballMachine {
 
	State soldOutState;
	State notEnoughCoins;
	State enoughCoins;
	State soldState;
 
	State state = soldOutState;
	int numGumballs;
	int coinsReceived;
	int cost;
	boolean quarterOnly;
	int lastCoin;
 
	public GumballMachine(int numberGumballs, boolean quarterOnly, int cost) {
		soldOutState = new SoldOutState(this);
		notEnoughCoinsState = new notEnoughCoinsState(this);
		enoughCoinsState = new enoughCoinsState(this);
		soldState = new SoldState(this);

		this.numGumballs = numberGumballs;
		this.cost = cost;
		this.quarterOnly = quarterOnly;
 		if (numberGumballs > 0) {
			state = notEnoughCoinsState;
		} 
	}
 
	public void insertCoins() { state.insertcoins(int coins); }
 
	public void ejectCoins() {
		state.ejectcoins();
	}
 
	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	void setState(State state) {
		this.state = state;
	}
 
	void releaseBall() {
		System.out.println("A gumball comes rolling out the slot...");
		if (numGumballs != 0) {
			numGumballs = numGumballs - 1;
		}
	}
 
	public int getNumGumballs() {
		return numGumballs;
	}

	public int getCoinsReceived() {return coinsReceived;}

	public int getCost() {return cost;}

	public void setcoins(int coins) {this.coins = coins; }

	boolean isQuarterOnly() {return quarterOnly;}
 
	void refill(int numGumballs) {
		this.numGumballs = numGumballs;
		state = notEnoughCoinsState;
	}

    public State getState() {
        return state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getnotEnoughCoinsState() {
        return notEnoughCoinsState;
    }

	public State getenoughCoinsState() {
		return enoughCoinsState;
	}

    public State getSoldState() {
        return soldState;
    }
 
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\nMighty Gumball, Inc.");
		result.append("\nJava-enabled Standing Gumball Model #2004");
		result.append("\nInventory: " + count + " gumball");
		if (count != 1) {
			result.append("s");
		}
		result.append("\n");
		result.append("Machine is " + state + "\n");
		return result.toString();
	}
}

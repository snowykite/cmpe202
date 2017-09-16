public class NotEnoughCoinsState implements State {
    GumballMachine gumballMachine;

    public NotEnoughCoinsState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

	public void insertCoins(int coins) {
		System.out.println("You inserted coins");
		if (coins != 25 && gumballMachine.isQuarterOnly){
			System.out.println("You need to insert a quarter");
		}
		else{
			int currentCoins = gumballMachine.getCoinsReceived() + coins;
			if( (currentCoins > gumballMachine.getCost())){
				System.out.println("That's too much!");
			}
			else if(currentCoins < gumballMachine.getCost()){
				gumballMachine.setCoins(currentCoins);
			}
			else {
				gumballMachine.setState(gumballMachine.getEnoughCoinsState());
			}

		}
	}

	public void ejectQuarter() {
		System.out.println("You haven't inserted a coin");
	}

	public void turnCrank() {
		System.out.println("You turned, but there's no coins");
	 }

	public void dispense() {
		System.out.println("You need to pay first");
	}

	public String toString() {
		return "waiting for quarter";
	}
}

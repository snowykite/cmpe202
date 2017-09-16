import java.util.Random;

public class EnoughCoinsState implements State {
    GumballMachine gumballMachine;

    public EnoughCoinsState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    public void insertCoins(int coins) { System.out.println("You can't insert other Coins"); }

    public void ejectCoins() {
        System.out.println("Coins returned");
        gumballMachine.setcoins();
        gumballMachine.setState(gumballMachine.getNotEnoughCoinsState());
    }

    public void turnCrank() {
        System.out.println("You turned...");
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    public void dispense() {
        System.out.println("No gumball dispensed");
    }

    public String toString() {
        return "waiting for turn of crank";
    }
}

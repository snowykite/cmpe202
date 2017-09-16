
public class GumballMachine
{

    private int num_gumballs;
    private int coins_received;
    private int cost;
    private boolean quarter_only;

    public GumballMachine( int size, int cost, boolean quarter_only )
    {
        // initialise instance variables
        this.num_gumballs = size;
        this.cost = cost;
        this.quarter_only = quarter_only;
        this.coins_received = 0;
    }

    public void insertCoins(int coin)
    {
        if ( coin != 25 && this.quarter_only)
        {
            System.out.println("Sorry, this Gumball machine only accepts quarters.")
        }
        else
            this.coins_received += coins;
    }
    
    public void turnCrank()
    {
    	if ( coins_received >= cost)
    	{
    		if ( this.num_gumballs > 0 )
    		{
    			this.num_gumballs-- ;
    			this.coins_received = 0;
    			System.out.println( "Thanks for your coins.  Gumball Ejected!" ) ;
    		}
    		else
    		{
    			System.out.println( "No More Gumballs!  Sorry, can't return your coins." ) ;
    		}
    	}
    	else 
    	{
    		System.out.println( "Please insert coins" ) ;
    	}        
    }
}


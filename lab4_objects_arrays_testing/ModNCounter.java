public class ModNCounter 
{

    private int myCount;
    private int myMod;

    public ModNCounter (int myN) 
    {
        myCount = 0;
        myMod = myN;
    }

    public void increment ( ) 
    {
    	if(myCount == myMod-1)
    	{
    		myCount = 0;
    	}
    	else
    	{
    		myCount++;
    	}
    }

    public void reset ( ) 
    {
        myCount = 0;
    }
    
    public int value ( ) 
    {
        return myCount;
    }
}

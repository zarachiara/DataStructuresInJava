public class JugContents {

    public int jugs[];	// contents of the three jugs.
    
    public JugContents (int amt0, int amt1, int amt2) {
        jugs = new int [3];
        jugs[0] = amt0;
        jugs[1] = amt1;
        jugs[2] = amt2;
    }
    
    public JugContents (JugContents b) {
        jugs = new int [3];
        jugs[0] = b.jugs[0];
        jugs[1] = b.jugs[1];
        jugs[2] = b.jugs[2];
    }
    
    public String toString() {
        return "Configuration = (" + jugs[0] + "," 
            + jugs[1] + "," + jugs[2] + ")";
    }
    
    // added isEqual to monitor configurations and prevent an infinite loop 
    // in JugSolver
    public boolean isEqual(Object jugsObject)
    {
    	if (jugsObject instanceof JugContents)
    	{	
    		for (int i = 0; i<jugs.length; i++)
        	{
        		if(this.jugs[i] != ((JugContents)jugsObject).jugs[i])
        		{
        			return false;
        		}
        	}
        	return true;
    	}
    	return false; 	
    }
}
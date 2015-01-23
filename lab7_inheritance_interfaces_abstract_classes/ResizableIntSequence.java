public class ResizableIntSequence extends IntSequence {
	
    public ResizableIntSequence(int capacity) {
    	super(capacity);
    }

    @Override
    public void add(int toBeAdded) {
        if (myCount == myValues.length) {
        	int[] newValues = new int[2*myValues.length];
        	for (int i = 0; i<myValues.length; i++) {
        		newValues[i] = myValues[i];
        	}
        	this.myValues = newValues;
        	add(toBeAdded);
        } else {
            myValues[myCount] = toBeAdded;
            myCount++;
        }
    }
    
    @Override
    public void insert(int toInsert, int insertPos) {
        
        if (myCount == myValues.length) {
        	int[] newValues = new int[2*myValues.length];
        	for (int i = 0; i<myValues.length; i++) {
        		newValues[i] = myValues[i];
        	}
        	this.myValues = newValues;
        	insert(toInsert, insertPos);	
        } else {
        	super.insert(toInsert, insertPos); 
        }
	}
    
    @Override
    public void remove(int pos) {
        if (pos < 0 || pos >= myCount) {
            return;
        }
        
        if (size() - 1 <= myValues.length / 2){
        	super.remove(pos);
        	int[] newValues = new int[myValues.length/2];
        	for (int i = 0; i<size(); i++) {
        		newValues[i] = myValues[i];
        	}        	
        	this.myValues = newValues;
        } else {
        	super.remove(pos);
    	
        }
    }
}

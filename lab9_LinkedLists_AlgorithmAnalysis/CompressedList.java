import java.util.ArrayList;
import java.util.Iterator;

public class CompressedList<T>  implements Iterable<T> {

    private ArrayList<CompressedObject> myValues;


    @Override
    public Iterator<T> iterator() {
        
        Iterator<T> iter = new Iterator<T>() {
            private int currIndex = 0;
            private int subIndex = 0;

            @Override
            public boolean hasNext() {
                return currIndex < myValues.size() && subIndex < myValues.get(currIndex).myCount;
            }

            @Override
            public T next() {
                T myThing = myValues.get(currIndex).myItem;
                subIndex++;
                if (subIndex >= myValues.get(currIndex).myCount) {
                    subIndex = 0;
                    currIndex++;
                }
                return myThing;
            }

            @Override
            public void remove() {
                return;
            }

        };

        return iter;
    } 

    public CompressedList() {
        myValues = new ArrayList<CompressedObject>();
    }

    public void addItem(T item) {
        if (myValues.size() == 0) {
    		myValues.add(new CompressedObject(item, 1));
    		return;
    	}
        CompressedObject lastRun = myValues.get(myValues.size() - 1);
        if (lastRun.getItem().equals(item)) {
            lastRun.incrementCount();
        } else {
            myValues.add(new CompressedObject(item, 1));
        }
    }

    private class CompressedObject {

        private T myItem;
        private int myCount;

        public CompressedObject(T item, int count) {
            myItem = item;
            myCount = count;
        }

        public T getItem() {
            return myItem;
        }

        public void incrementCount() {
            myCount++;
        }

        public int getCount() {
            return myCount;
        }

        public void setCount(int count) {
            myCount = count;
        }

    }

}


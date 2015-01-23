
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
	//constructor 
	
	public boolean contains(T key)
	{
		
		return contains(myRoot, key);
	}
	
	public boolean contains(TreeNode t, T key)
	{
		if (t == null)
		{
			return false; 
		}
		else if(t.myItem.equals(key))
		{
			return true; 
		}
		else if(key.compareTo(t.myItem) < 0)
		{
			return contains(t.myLeft, key);
		}
		else
		{
			return contains(t.myRight, key);
		}
	}
	
	public void add(T key) 
	{
		if (myRoot == null)
		{
			myRoot = new TreeNode(key);
		}
		else if(!this.contains(key))
		{
			this.add(myRoot,key);
		}
		else
		{
			throw new IllegalArgumentException("Tree already contains item");
		}
		
	}
	
	
	private TreeNode add(TreeNode t, T key) 
	{
		if (t == null) {
			return new TreeNode(key);
		} 
		else if (!contains(t,key))
		{
			if (key.compareTo(t.myItem) < 0) 
			{
				t.myLeft = add(t.myLeft, key);
				return t;
			
			} 
			else 
			{
				t.myRight = add(t.myRight, key);
				return t; 
			}
			
		}
		else
		{
			throw new IllegalArgumentException("key already exists in the tree");
		}	
	}
	
}

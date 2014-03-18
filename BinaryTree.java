import java.util.Iterator;
import java.util.Stack;
import java.util.NoSuchElementException;

public class BinaryTree {
	private BTNode root;	
	
	BinaryTree() {
		root = null;
	}
	
	public boolean isEmpty() { return root == null; }
	public void clear() { root = null; }
	public boolean hasLeft( BTNode node ) { return node.getLeft() != null; }
	public boolean hasRight( BTNode node ) { return node.getRight() != null; }
	public void insert( BTNode node ) {
		if( root == null ) { root = node; return; }
		root.insert(node);
	}
	
	public void remove( int val ) {
		if( root != null ) { //only worry about doing anything if the tree is non-empty
			if( root.getValue() == val ) {
				BTNode temp = new BTNode(); //temporary handle
				temp.setLeft( root );
				root.remove( val, temp );
				root = temp.getLeft();
			}
			else { root.remove( val, null); } //root doesn't have a parent, but we know the recursion will go down one level (or more)		
		}
	}
	
	public void print() {
		if( root == null ) { System.out.println( "Empty tree!" ); return; }
		root.print();
		System.out.println();
	}
	
	public int numEntries() {
		//returns the number of entries in this binary tree
		return root.numEntries();
	}
	
	public boolean contains( int val ) {
		//returns whether the binary tree contains "val"
		return root.contains(val);
	}
	
	public int height() {
		//complete this method
		return root.height();
	}
	
	public int numLeaves() {
		//complete this method
		return root.numLeaves();
	}
	
	public void verticalFlip() {
		//complete this method
		root.verticalFlip();
	}
	
	public PreOrderIterator  pre_iterator() {
		//return a instance of a PreOrderIterator
		return new PreOrderIterator();
	}
	
	public InOrderIterator in_iterator() {
		//return an instance of an InOrderIterator\
		return new InOrderIterator();
	}
	
	public PostOrderIterator post_iterator() {
		//return an instance of a PostOrderIterator
		return new PostOrderIterator();
	}
	
	private class PreOrderIterator implements Iterator<Integer> {

	    private Stack<BTNode> st;

	    public PreOrderIterator() {
	    	st = new Stack<BTNode>();
	    	// Since PreOrderIterator is an inner class of BinaryTree,
	    	// we have to access the root node the following way (as we have done before) 
	        if (BinaryTree.this.root != null) {
	            st.push (BinaryTree.this.root);
	        }
	    }

	    public boolean hasNext() {
	        return !st.empty();
	    }

	    public Integer next() {
	        if (!hasNext()) {
	            throw new NoSuchElementException ("tree ran out of elements");
	        }	        
	        BTNode node = st.pop();
	        if (node.getRight() != null) {
	            st.push (node.getRight());}
	        if ( node.getLeft() != null ) {
	        	st.push(node.getLeft());
	        }
	        //what else should you push on the stack so that the next pop is the correct node?
	        //COMPLETE this portion of the the method
	        return new Integer(node.getValue());
	    }

	    //We are not going to worry about having an iterator remove an element from the tree
	    public void remove () {
	        throw new UnsupportedOperationException();
	    }
	}
	
	private class InOrderIterator implements Iterator<Integer> {

	    private Stack<BTNode> st;
	    public InOrderIterator() {
	    	//Complete this constructor.  You must put the stack in a state
	    	// where the first call to "next" has the proper node at the top of the
	    	// stack from which to return its value
	    	st = new Stack<BTNode>();
	    	BTNode n = root;
	    	left_push(n);
	    	/*for ( int i = 0; i < st.size(); i++){
	    		System.out.println(st.pop().getValue());}*/
	    }
	    
	    public void left_push(BTNode node){
	    	while ( node != null ){
	        	
	    		st.push(node);
	        	node = node.getLeft();
	        	//System.out.println(st.peek().getValue());
	    	}
	    }
	    
	    public boolean hasNext() {
	        return !st.empty();
	    }

	    public Integer next() {
	    	BTNode curr = st.pop();
	    	BTNode val = curr;
	    	curr = curr.getRight();
	    	left_push(curr);
	    	return new Integer(val.getValue());
	    }

	    public void remove() {
	        throw new UnsupportedOperationException();
	    }
	}
	
	
	private class PostOrderIterator implements Iterator<Integer> {

	    private Stack<BTNode> st;
	    
	    public PostOrderIterator() {
	    	//Complete this constructor as above
	    	BTNode n = root;
	    	left_push(n);
	    }
	    
	    public void left_push(BTNode node){
	    	while ( node != null && node.isTouched() ){
	        	
	    		node.setTouched();
	    		st.push(node);
	        	node = node.getLeft();
	        	//System.out.println(st.peek().getValue());
	    	}
	    }
	    public boolean hasNext() {
	        return !st.empty();
	    }

	    public Integer next() {
	        //Complete this method
	    	BTNode curr = st.peek();
	    	BTNode val;
	    	curr = curr.getRight();
	    	left_push(curr);
	    	val = st.pop();
	    	return new Integer(val.getValue());
	    	
	    }

	    public void remove() {
	        throw new UnsupportedOperationException();
	    }
	}


}

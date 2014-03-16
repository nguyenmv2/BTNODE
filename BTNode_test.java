public class BTNode_test {
	private int value;
	private BTNode_test left;
	private BTNode_test right;
	
	BTNode_test() {
		value = 0;
		left = right = null;
	}
	
	BTNode_test( int val ) {
		value = val;
		left = right = null;
	}
	
	public void setValue( int val ) { value = val; }
	public int getValue() { return value; }
	public void setLeft( BTNode_test n ) { left = n; }
	public void setRight( BTNode_test n ) { right = n; }
	public BTNode_test getLeft() { return left; }
	public BTNode_test getRight() { return right; }
	public void insert( BTNode_test n ) {
		if( n != null ) { //don't insert a null BTNode
			if( n.getValue() < this.value ) {
				if( left == null ) { setLeft( n ); }
				else{ getLeft().insert(n); }
			}
			else { //assume that the values to be added are all different
				if( right == null ) { setRight( n ); }
				else{ getRight().insert(n); }
			}
		}
	}
	
	public void remove( int value, BTNode_test parent ) {
		if( value < this.value ) {
			if( left != null ) left.remove( value, this );  //"this" refers to the reference of this BTNode that we are talking to
		}
		else if( value > this.value ) {
			if( right != null ) right.remove( value, this );
		}
		else { //this is the node we need to remove
			if( (left != null) && (right != null) ) { //if this node has two children
				this.value = right.minValue();
				right.remove( this.value, this ); //we have removed the initial value, now remove the duplicate!!
			}
			else if( parent.left == this ) {
				parent.left = ( left != null )? left : right;
			}
			else if( parent.right == this ) {
				parent.right = ( left != null )? left : right;
			}
		}
	}
	
	public int minValue() {
		//returns the minimum value of the subtree having this node as its root
		if ( left == null ) return value;
		return left.minValue();
	}
	
	public void print() { 
		//prints the values in the subtree having this node as its root in order
		if( getLeft() != null ) { getLeft().print(); }
		System.out.print( Integer.toString( getValue() ) + " " );
		if( getRight() != null ) { getRight().print(); }
	}
	
	public int numEntries() {
		int count = 1;
		if( getLeft() != null ) { count+= getLeft().numEntries(); }
		if( getRight() != null ) { count+= getRight().numEntries(); }
		return count;
	}
	
	public boolean contains( int val ) {
		
		if ( val == value ) { return true; }
		
		if ( val < value && left != null ){				//If smaller then look left
			
			return left.contains(val);
	
		} else if ( val > value && right != null ) {						//If larger then look right
			
			return right.contains(val);
		}
		return false;
	}
	public boolean isLeaf() {
		
		if ( left == null & right == null ) return true;
		else return false;
	}
	
	public int height() {
		//return the height of the subtree defined by this node
		if (this == null) return 0;
		else {
			int lt = left.height();
			int rt = right.height();
			return Math.max(lt,rt) +1;
		}
			
	}
	
	public int numLeaves() {
		//return the number of leaves (leaf nodes, those nodes with NO children)
		if (this == null) {; return 0;}
		else if ( left != null && right != null ) {
			return left.numLeaves() + right.numLeaves();
		} else {
			return 1;
		}
	}
	
	
	public void verticalFlip() {
		//does a vertical flip on the subtree defined by this node
		//vertical flip means that all of the left children are now 
		//right children of their parents and vice versa.
		BTNode_test temp;
		
		if ( this == null ) return;
		else { 
			
			left.verticalFlip();
			right.verticalFlip();
			temp = left;
			left = right;
			right= temp;
		}
	}
	
	public static void main( String [] argv) {
		
		BTNode_test test = new BTNode_test(100);
		BTNode_test test_left = new BTNode_test(90);
		BTNode_test test_right = new BTNode_test(110);
		
		test.setLeft(test_left);
		test_left.setLeft(new BTNode_test(80));
		test_left.getLeft().setLeft(new BTNode_test(70));
		
		test.setRight(test_right);
		test_right.setRight(new BTNode_test(120));
		test_right.getRight().setRight(new BTNode_test(130));
		
		test.print();
		
		/*System.out.println( test.contains(60) + " 1" ); 
		System.out.println( test.contains(70) + " 2" );
		System.out.println( test.contains(100) + " 3" );
		System.out.println( test.contains(120) + " 4");
		-System.out.println( test.contains(10000) + " 5" );*/
		
		test.verticalFlip();
		test.print();
		
		
							
		
		
	}

}



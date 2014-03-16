import java.util.Iterator;

public class BinaryTreeIterator {

	public static void main( String [] argv) {
		//The following is a PARTIAL template for code to test
		// your implementation of BinaryTree.java and BTNode.java
		//It does not include testing code for all of the methods
		//you are requested to implement.
		BinaryTree b_tree = new BinaryTree();
		b_tree.insert( new BTNode( 5 ) );
		b_tree.print();
        System.out.println( "5 is the root node" );
		b_tree.insert( new BTNode( 2 ) );
		b_tree.print();
		System.out.println( "2 is 5's left child" );
		b_tree.insert( new BTNode( 10 ) );
		b_tree.print();
		System.out.println( "10 is 5's right child" );
		b_tree.insert( new BTNode( 3 ) );
		b_tree.print();
		System.out.println( "3 is 2's right child" );
		b_tree.insert( new BTNode( 9 ) );
		b_tree.print();
		System.out.println( "9 is 10's left child" );
		b_tree.insert( new BTNode( 4 ) );
		b_tree.print();
		System.out.println( "4 is 3's right child" );
		b_tree.insert( new BTNode( 12 ) );
		b_tree.print();
		System.out.println( "12 is 10's right child" );
		b_tree.insert( new BTNode( 8 ) );
		b_tree.print();
		System.out.println( "8 is 9's left child" );
		
		System.out.println(b_tree.numEntries());
		System.out.println(b_tree.numLeaves());
		System.out.println(b_tree.height());
		//b_tree.verticalFlip();
		b_tree.print();
		System.out.println( "A pre-order traversal of this tree gives the following list:" );
		Iterator<Integer> pre = b_tree.pre_iterator();
		while( pre.hasNext() ) {
			System.out.print( pre.next() + " " );
		}
		System.out.println();
		
		System.out.println( "An in-order traversal of this tree gives the following list:" );
		Iterator<Integer> in = b_tree.in_iterator();
		while( in.hasNext() ) {
			System.out.print( in.next() + " " );
		}
		System.out.println();
		
//		System.out.println( "A post-order traversal of this tree gives the following list:" );
//		Iterator<Integer> post = b_tree.post_iterator();
//		while( post.hasNext() ) {
//			System.out.print( post.next() + " " );
//		}
//		System.out.println();
	}

}

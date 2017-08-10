package struc;

public interface BinaryTreeADT <T>{

	T getRoot();
	
	boolean isEmpty();
	
	int size();
	
	boolean contains();
	
	T find(T target);
	
	String toString();
	
	Iterator<T> iterator();
	/*
	 * In Order Traversal - accomplished by visiting the left child of the node, then the node, and then
	 * any remaining nodes, starting with the root. So, starting with the root:
	 *  
	 * Traverse(left child)
	 * Visit node
	 * Traverse(right child)
	 */
	
	Iterator<T> iteratorInOrder();
	
	/*
	 * Pre-Order Traversal - accomplished by visiting each node, followed by its children, starting with
	 * the root.
	 * 
	 * Visit node
	 * Traverse(left child)
	 * Traverse(right child)
	 */
	
	Iterator<T> iteratorPreOrder();
	
	/*
	 * Post Order Traversal - accomplished by visiting the children and then the node, starting with the root.
	 * So, starting from the root:
	 * 
	 * Traverse(left child)
	 * Traverse(right child)
	 * Visit node
	 */
	
	Iterator<T> iteratorPostOrder();
	
	/*
	 * Level Order Traversal - accomplished by visiting all the nodes one level at a time, starting with the
	 * root:
	 * 
	 * Create a queue called nodes
	 * Create an unordered list called results
	 * Enqueue the root onto the nodes queue
	 * While(nodes queue != empty){
	 * 		Dequeue the first element from the queue
	 * 		If(that element != null)
	 * 			Add that element to the rear of the results list
	 * 			Enqueue the children of the element on the nodes queue
	 * 		Else
	 * 			Add null on the results list
	 * }
	 * Return an iterator of the result list
	 */
	
	Iterator<T> iteratorLevelOrder();
}

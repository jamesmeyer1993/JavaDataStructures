package struc;

public class BinaryTreeLinked<T> implements BinaryTreeADT<T> 
// TODO : this class is supposed to implement IterableADT... but that's giving me problems
{

	protected BinaryTreeNode<T> root;
	protected int modCount;
	
	public BinaryTreeLinked(){root = null;}
	public BinaryTreeLinked(T element){
		root = new BinaryTreeNode<T>(element);
	}
	public BinaryTreeLinked(T element, BinaryTreeLinked<T> left, BinaryTreeLinked<T> right){
		root = new BinaryTreeNode<T>(element);
		root.setLeft(left.root);
		root.setRight(right.root);
	}

	public T getRoot() {return (T) root;}
	
	public BinaryTreeNode<T> getRootNode(){return root;}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains() {
		// TODO Auto-generated method stub
		return false;
	}

	public T find(T target) {
		BinaryTreeNode<T> current = findNode(target, root);
		
		if(current == null)
			throw new ElementNotFoundException("Binary Tree Lined");
		
		return current.getElement();
	}
	
	private BinaryTreeNode<T> findNode(T targ, BinaryTreeNode<T> next){
		if(next == null)
			return null;
		if(next.getElement().equals(targ))
			return next;
		
		BinaryTreeNode<T> temp = findNode(targ, next.getLeft());
		
		if(temp == null)
			temp = findNode(targ, next.getRight());
		
		return temp;
	}

	public Iterator<T> iteratorInOrder() {
		ListUnorderedArray<T> tempList = new ListUnorderedArray<T>();
		inOrder(root, tempList);	
		return new TreeIterator(tempList.iterator());
	}

	protected void inOrder(BinaryTreeNode<T> node, ListUnorderedArray<T> list){
		if(node != null){
			inOrder(node.getLeft(), list);
			list.addToRear(node.getElement());
			inOrder(node.getRight(), list);
		}
	}
	@Override
	public struc.Iterator<T> iteratorPreOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public struc.Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public struc.Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>();
	}

	
	// We'll keep tree iterator here as an embedded class
	private class TreeIterator extends Iterator<T>{
		
		private TreeIterator(){
			
		}
	}
}

package struc;

public class BinaryTreeNode <T>{

	protected T element;
	protected BinaryTreeNode<T> left, right;
	
	public BinaryTreeNode(T elem){
		element = elem;
		left = right = null;
	}
	public BinaryTreeNode(T elem, BinaryTreeLinked<T> left, BinaryTreeLinked<T> right){
		element = elem;
		if(left == null)
			this.left = null;
		else
			this.left = left.getRootNode();
		
		if(right == null)
			this.right = null;
		else
			this.right = right.getRootNode();
	}
	
	// getters
	
	public BinaryTreeNode<T>getLeft(){return left;}
	
	public BinaryTreeNode<T>getRight(){return right;}
	
	public int numChildren(){
		int children = 0;
		
		if(left != null)
			children = 1 + left.numChildren();
		if(right != null)
			children = children + 1 + right.numChildren();
		return children;
	}
	
	public T getElement(){return element;}
	
	// setters
	public void setLeft(BinaryTreeNode<T> l){
		left = l;
	}
	public void setRight(BinaryTreeNode<T> r){
		right = r;
	}
	public void setElement(T e){
		element = e;
	}
	// toString
}

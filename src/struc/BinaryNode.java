package struc;

public class BinaryNode <T> extends LinearNode<T>{

	private BinaryNode<T> last;
	
	public BinaryNode(){super();}
	public BinaryNode(T elem){super(elem);}
	
	@SuppressWarnings("unused")
	private void setLast(BinaryNode<T> node){
		last = node;
	}
	
	@SuppressWarnings("unused")
	private BinaryNode<T> getLast(){
		return last;
	}
}

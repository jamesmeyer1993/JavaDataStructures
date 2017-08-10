package struc;

public class QueueLinked<T> implements QueueADT<T>, DebugADT{

	private int count;
	private LinearNode<T> head, tail;
	
	public QueueLinked(){
		count = 0;
		head = tail = null;
	}
	
	public void enqueue(T element) {
		LinearNode<T> node = new LinearNode<T>(element);
		
		if(isEmpty())
			head = node;
		else
			tail.setNext(node);
		
		tail = node;
		count++;
	}

	public T dequeue() {
		
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		
		T result = head.getElement();
		head = head.getNext();
		count--;
		
		if (isEmpty())
			tail = null;
		
		return result;
	}

	public T first() {
		if(isEmpty())
			throw new EmptyCollectionException("queue");
		else
			return head.getElement();
	}

	public T last(){
		if(isEmpty())
			throw new EmptyCollectionException("queue");
		else
			return tail.getElement();
	}
	
	public boolean isEmpty() {
		if(count == 0 && head == null)
			return true;
		else
			return false;
	}

	public int size() {
		return count;
	}
	
	public String toString(){
		print("toString():");
		if(isEmpty())
			throw new EmptyCollectionException("queue");
		String result = "";
		LinearNode<T> node = head;
		while(node != null){
			result = result + node.getElement().toString() + "\n";
			node = node.getNext();
		}
		return result;
	}

	// --------------------------------
	// ---------- Debug ---------------
	// --------------------------------
	
	public void print(String str) {
		String msg = this.getClass().toString() + " " + str;
		System.out.println(msg);
	}

}

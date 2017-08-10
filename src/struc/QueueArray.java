package struc;

public class QueueArray<T> implements QueueADT<T>{

	private final static int SIZE = 100;
	private int front, rear, count;
	private T[]queue;
	boolean resizeable;
	
	public QueueArray(){
		this(SIZE);
	}
	
	public QueueArray(int size){
		queue = (T[])(new Object[size]);
		front = rear = count = 0;
		resizeable = false;
	}
	
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return null;
	}

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

}

package struc;

public class QueueCircular<T> implements QueueADT<T>{

	private final static int DEFAULT_CAPACITY = 100;
	private int front, rear, count;
	private T[] queue;
	
	public QueueCircular(int inicapacity){
		front = rear = count = 0;
		queue = (T[]) (new Object[inicapacity]);
	}
	
	public QueueCircular(){
		this(DEFAULT_CAPACITY);
	}
	
	public void enqueue(T element) {
		if(size() == queue.length)
			expandCapacity();
		
		queue[rear] = element;
		rear = (rear+1) % queue.length;
		
		count++;
	}

	public T dequeue() {
		if (isEmpty())
			throw new EmptyCollectionException("queue");
		
		T result = queue[front];
		queue[front] = null;
		front = (front+1) % queue.length;
		
		count--;
		
		return result;
	}

	public T first() {
		if (isEmpty())
			throw new EmptyCollectionException("queue");		
		return queue[front];
	}

	public boolean isEmpty() {
		boolean result = false;
		if(count == 0)
			result = true;
		return result;
	}

	public int size() {
		int i = 0;
		while(queue[i] != null){
			i++;
		}
		return i;
	}
	
	private void expandCapacity(){
		T[] larger = (T[])(new Object[queue.length * 2]);
		
		for(int scan = 0; scan < count; scan++){
			larger[scan] = queue[front];
			front = (front + 1) % queue.length;
		}
		
		front = 0;
		rear = count;
		queue = larger;
	}
	
	public String toString(){
		System.out.println("toString(): running toString...");
		String result = "";
		int i = 0;
		while(queue[i] != null){
			System.out.println("toString(): running while loop...");
			result = result + queue[i].toString() + "\n";
			i++;
		}
		return result;
	}
}

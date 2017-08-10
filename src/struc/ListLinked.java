package struc;

public abstract class ListLinked<T> implements ListADT<T> {
	
	protected int count;
	protected LinearNode<T>head, tail;
	protected int modCount;
	
	public ListLinked(){
		count = 0;
		head = tail = null;
		modCount = 0;
	}

	public T removeFirst() {
		
		if(isEmpty())
			throw new EmptyCollectionException("ListLinked");
		
		LinearNode<T> result = head;
		if(size() == 1)
			head = tail = null;
		else
			head = head.getNext();
		
		return result.getElement();
	}

	public T removeLast() {
		
		if(isEmpty())
			throw new EmptyCollectionException("ListLinked");
		
		LinearNode<T> result = tail;
		if(size() == 1)
			tail = head = null;
		else{
			LinearNode<T> node = null;
			while(node.getNext() != tail){
				node = node.getNext();
			}
			tail = node.getNext();
		}
		
		return result.getElement();
	}

	public T remove(T element) throws EmptyCollectionException, ElementNotFoundException{
		
		if(isEmpty())
			throw new EmptyCollectionException("ListLinked");
		
		boolean found = false;
		LinearNode<T> previous = null;
		LinearNode<T> current = head;
		
		while(current != null && !found)
			if(element.equals(current.getElement()))
				found = true;
			else{
				previous = current;
				current = current.getNext();
			}
		
		if(!found)
			throw new ElementNotFoundException("ListLinked");
		
		if(size() == 1) // only one element in the list
			head = tail = null;
		else if(current.equals(head)) // target is at the head
			head = current.getNext();
		else if(current.equals(tail)){
			tail = previous;
			tail.setNext(null);
		}
		else // target is in the middle
			previous.setNext(current.getNext());
		
		count--;
		modCount++;
		
		return current.getElement();
	}

	public T first() {return head.getElement();}

	public T last() {return tail.getElement();}

	public boolean contains(T target) {
		
		if(isEmpty())
			throw new EmptyCollectionException("ListLinked");
		
		boolean found = false;
		
		LinearNode<T>current = head;
		while(current.getNext() != null && found == false){
			if(current.getElement().equals(target))
				found = true;
			current = current.getNext();
		}
		
		return found;
	}

	public boolean isEmpty() {
		if(count == 0)
			return true;
		else
			return false;
	}

	public int size() {
		if(isEmpty())
			throw new EmptyCollectionException("ListLinked");
		
		int result = 0;
		LinearNode<T>temp = head;
		while(temp.getNext() != null){
			result++;
			temp = temp.getNext();
		}
		return result;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}

package struc;

public class ListOrderedArray<T> extends ListArray<T> implements ListOrderedADT<T> {

	public void add(T element) {
		if(!(element instanceof Comparable))
			throw new NonComparableElementException("ListOrderedArray");
		
		Comparable<T> comparableElement = (Comparable<T>) element;
		
		if(size() == list.length)
			expandCapacity();
		
		int scan = 0;
		
		// find the insertion location
		
		while (scan < rear && comparableElement.compareTo(list[scan]) > 0)
			scan++;
		
		// shift existing elements up one
		
		for(int shift = rear; shift < scan; shift--)
			list[shift] = list[shift-1];
		
		// insert element
		
		list[scan] = element;
		rear++;
		modCount++;
	}
	
/*	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T last() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(T target) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}*/

	


}

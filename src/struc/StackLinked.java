package struc;

import java.util.EmptyStackException;

public class StackLinked<T> implements StackADT<T>, DebugADT{

	private LinearNode<T> top;
	private int count;
	
	public StackLinked(){
		print("StackLinked(): instantiating...");
		count = 0;
		top = null;
	}
	
	public void push(T element) {
		print("push():");
		LinearNode<T> temp = new LinearNode<T>(element);
		
		temp.setNext(top);
		top = temp;
		count++;
	}

	public T pop() throws EmptyStackException{
		print("pop():");
		if(isEmpty())
			throw new EmptyStackException();
		
		T result = top.getElement();
		top = top.getNext();
		count--;
		
		return result;
	}

	public T peek() {
		print("pop():");
		if(isEmpty())
			throw new EmptyStackException();
		
		return top.getElement();
	}

	public boolean isEmpty() {
		print("isEmpty()");
		
		if(top == null)
			return true;
		else
			return false;
	}

	public int size() {			
		print("size()");
		if(isEmpty())
			throw new EmptyStackException();
		
		int result = 0;
		LinearNode<T>temp = top;
		while(temp.getNext() != null){
			result++;
			temp = temp.getNext();
		}
		//if(result != count)
			//result = resolveSize(); TODO: maybe resolve the size of the stack...
		return result;
	}
	
	// ---------------------------------------
	// ---------- toString -------------------
	// ---------------------------------------
	
	public String toString(){
		print("toString():");
		if(isEmpty())
			throw new EmptyStackException();
		
		String result = "";
		LinearNode<T>temp = top;
		while(temp != null){
			//debugMsg("toString(): temp.getNext = " + temp.getElement().toString());
			result = result + temp.getElement().toString() + "\n";
			temp = temp.getNext();
		}
		return result;
	}

	// ---------------------------------------
	// ---------- Debug ----------------------
	// ---------------------------------------
	
	public void print(String str){
		String msg = this.getClass().toString() + " " + str;
		System.out.println(msg);
	}

}

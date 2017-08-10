package struc;

@SuppressWarnings("serial")
public class ElementNotFoundException extends RuntimeException {

	ElementNotFoundException(String collection){
		super("The " + collection + "is empty");
	}
}

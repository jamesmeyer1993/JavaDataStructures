package struc;

@SuppressWarnings("serial")
public class NonComparableElementException extends RuntimeException {

	public NonComparableElementException(String collection){
		super("Non comparable element exception: " + collection);
	}
}

import java.util.Iterator;

public class MyFlexibleArrayIterator <E> implements Iterator<E> {
	private int currentIndex;
	private int maxSize;
	private E[] internalArray;
	
	public MyFlexibleArrayIterator(E[] collection, int maxSize) {
		internalArray = collection;
		currentIndex = 0;
		this.maxSize = maxSize;
	}

	@Override
	public boolean hasNext() {
		return currentIndex < maxSize;
	}

	@Override
	public E next() {
		return internalArray[currentIndex++];
	}
}

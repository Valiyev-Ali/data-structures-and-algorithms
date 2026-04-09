public class MyFlexibleIntArray implements MyFlexibleIntADT {
	
	private int[] internalArray;
	// The current number of useful elements in the internal array.
	private int actualSize;
	private static final int INITIAL_SIZE = 4;
	
	public MyFlexibleIntArray() {
		this(INITIAL_SIZE);
	}
	
	public MyFlexibleIntArray(int initialSize) {
		internalArray = new int[initialSize];
		actualSize = 0;
	}

	@Override
	public int get(int index) throws ArrayIndexOutOfBoundsException {
		if (index >= actualSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return internalArray[index];
	}

	@Override
	public void set(int newElement, int index) throws ArrayIndexOutOfBoundsException {
		if (index >= actualSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		internalArray[index] = newElement;
	}

	@Override
	public int getSize() {
		return actualSize;
	}

	@Override
	public boolean isEmpty() {
		return actualSize == 0;
	}

	@Override
	public void add(int newElement) {
		resize();
		internalArray[actualSize++] = newElement;
	}

	@Override
	public void add(int newElement, int index) {
		//valid index?
		if ((index >= actualSize) || (index < 0)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		// resize?
		resize();
		// shift & insert
		for (int shiftIndex = actualSize; shiftIndex > index; shiftIndex--) {
			internalArray[shiftIndex] = internalArray[shiftIndex - 1];
		}
		internalArray[index] = newElement;
		actualSize++;
	}

	@Override
	public int remove(int index) {
		//valid index?
		if ((index >= actualSize) || (index < 0)) {
			throw new ArrayIndexOutOfBoundsException();
		}
		// shift & remove
		int removedElement = internalArray[index];
		for (int shiftIndex = index + 1; shiftIndex < actualSize; shiftIndex++) {
			internalArray[shiftIndex - 1] = internalArray[shiftIndex];
		}
		actualSize--;
		return removedElement;
	}
	
	@Override
	public String toString() {
		//return Arrays.toString(internalArray);
		StringBuffer descriptionBuffer = new StringBuffer("{");
		boolean first = true;
		for (int index = 0; index < actualSize; index++) {
			if (first) {
				descriptionBuffer.append(internalArray[index]);
				first = false;
			}
			else {
				descriptionBuffer.append(", ").append(internalArray[index]);
			}
		}
		descriptionBuffer.append("}");
		return descriptionBuffer.toString();
	}
	
	private void resize() {
		if (actualSize == internalArray.length) { // resize needed
			int[] newArray = new int[internalArray.length * 2];
			for (int index = 0; index < internalArray.length; index++) {
				newArray[index] = internalArray[index];
			}
			internalArray = newArray;
		}
	}
	
	public static void main(String[] args) {
		MyFlexibleIntArray myArray = new MyFlexibleIntArray();
//		System.out.println(myArray.get(0));
		System.out.println(myArray.toString());
		myArray.add(10);
		System.out.println(myArray.get(0));
		System.out.println(myArray.toString());
		myArray.set(11, 0);
		System.out.println(myArray.toString());
		myArray.add(20);
		System.out.println(myArray.toString());
		myArray.add(30);
		System.out.println(myArray.toString());
		myArray.add(40);
		System.out.println(myArray.toString());
		myArray.add(50);
		System.out.println(myArray.toString());
		System.out.println("Size = " + myArray.getSize());
		myArray.add(10, 0);
		System.out.println(myArray.toString());
		myArray.add(22, 3);
		System.out.println(myArray.toString());
		myArray.add(33, 5);
		System.out.println(myArray.toString());
		myArray.add(44, 7);
		System.out.println(myArray.toString());
		System.out.println("Removed element = " + myArray.remove(4));
		System.out.println(myArray.toString());
		myArray.add(60);
		System.out.println(myArray.toString());
	}
}

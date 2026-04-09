import java.util.Iterator;

public class MyFlexibleArray <E> implements MyFlexibleArrayADT<E>, Iterable<E>  {
		
		private E[] internalArray;
		// The current number of useful elements in the internal array.
		private int actualSize;
		private static final int INITIAL_SIZE = 4;
		
		public MyFlexibleArray() {
			this(INITIAL_SIZE);
		}
		
		public MyFlexibleArray(int initialSize) {
			internalArray = createArray(initialSize);
			actualSize = 0;
		}

		@Override
		public E get(int index) throws ArrayIndexOutOfBoundsException {
			if (index >= actualSize) {
				throw new ArrayIndexOutOfBoundsException();
			}
			return internalArray[index];
		}

		@Override
		public void set(E newElement, int index) throws ArrayIndexOutOfBoundsException {
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
		public void add(E newElement) {
			resize();
			internalArray[actualSize++] = newElement;
		}

		@Override
		public void add(E newElement, int index) {
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
		public E remove(int index) {
			//valid index?
			if ((index >= actualSize) || (index < 0)) {
				throw new ArrayIndexOutOfBoundsException();
			}
			// shift & remove
			E removedElement = internalArray[index];
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
				E[] newArray = createArray(internalArray.length * 2);
				for (int index = 0; index < internalArray.length; index++) {
					newArray[index] = internalArray[index];
				}
				internalArray = newArray;
			}
		}

		@Override
		public Iterator<E> iterator() {
			return new MyFlexibleArrayIterator<E>(internalArray, actualSize);
		}

		@SuppressWarnings("unchecked")
		private E[] createArray(int size) {
			return (E[]) new Object[size];
		}
		
		public static void main(String[] args) {
			MyFlexibleArray<Integer> myIntegerArray = new MyFlexibleArray<Integer>();
			myIntegerArray.add(1);
			myIntegerArray.add(2);
			myIntegerArray.add(3);
			myIntegerArray.add(4);
			myIntegerArray.add(5);
			System.out.println(myIntegerArray);
			MyFlexibleArray<String> myStringArray = new MyFlexibleArray<String>();
			myStringArray.add("Monday");
			myStringArray.add("Tuesday");
			myStringArray.add("Wednesday");
			myStringArray.add("Thursday");
			myStringArray.add("Friday");
			myStringArray.add("Saturday");
			System.out.println(myStringArray);
			myStringArray.add("Sunday", 0);
			System.out.println(myStringArray);
			
			for (int index = 0; index < myStringArray.getSize(); index++) {
				System.out.println(myStringArray.get(index));
			}
			
			for (String item : myStringArray) {
				System.out.println(item);
			}
			
			Iterator<Integer> intIterator = myIntegerArray.iterator();
			while (intIterator.hasNext()) {
				System.out.println(intIterator.next());
			}
			
			System.out.println("Sum = " + ArrayUtilities.sum(myIntegerArray));
		}
}

import java.util.Random;

public class SearchAlgorithms {
	
	public static <E> int linearSearch(MyFlexibleArray<E> inputData, E key) {
		if ((inputData == null) || inputData.isEmpty()) {
			return -1;
		}
		for (int index = 0; index < inputData.getSize(); index++) {
			if ((key == inputData.get(index)) ||
					((key != null) && key.equals(inputData.get(index)))) {
				return index;
			}
		}
		return -1;
	}
	
	public static <E extends Comparable<E>> int binarySearch(MyFlexibleArray<E> inputData, E key) {
		if ((inputData == null) || inputData.isEmpty() || (key == null)) {
			return -1;
		}
		return binarySearch(inputData, key, 0, inputData.getSize() - 1);
	}
	private static <E extends Comparable<E>> int binarySearch(MyFlexibleArray<E> inputData, E key, int startIndex, int endIndex) {
		if (startIndex > endIndex) {
			return -1;
		}
		int middleIndex = (startIndex + endIndex) / 2;
		if ((key == inputData.get(middleIndex)) ||
				key.equals(inputData.get(middleIndex))) {
			return middleIndex;
		}
		if (key.compareTo(inputData.get(middleIndex)) < 0) {
			return binarySearch(inputData, key, startIndex, middleIndex - 1);
		}
		else {
			return binarySearch(inputData, key, middleIndex + 1, endIndex);
		}
	}
	
	
	public static void main(String[] arguments) {
		MyFlexibleArray<Integer> myData = new MyFlexibleArray<Integer>();
		Random numberGenerator = new Random();
		for (int counter = 0; counter < 20; counter++) {
			myData.add(numberGenerator.nextInt(0, 40));
		}
		System.out.println(myData);
		Integer myKey = 10;
		System.out.println(myKey);
		System.out.println(linearSearch(myData, myKey));
		
		MyFlexibleArray<Integer> mySortedData = new MyFlexibleArray<Integer>();
		mySortedData.add(0);
		mySortedData.add(1);
		mySortedData.add(3);
		mySortedData.add(7);
		mySortedData.add(8);
		mySortedData.add(11);
		mySortedData.add(13);
		mySortedData.add(20);
		mySortedData.add(22);
		System.out.println(mySortedData);
		System.out.println(binarySearch(mySortedData, 19));
//		binarySearch(new MyFlexibleArray<Object>(), new Object());
	}

}

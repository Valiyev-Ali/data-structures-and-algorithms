import java.util.Arrays;

public class SortingAlgorithms {
	
	public static <T extends Comparable<T>> void bubbleSort(T[] inputData) {
		if ((inputData != null) && (inputData.length > 1)) {
			int swaps;
			for (int endIndex = inputData.length -1; endIndex > 0; endIndex--) {
				swaps = bubbleSort(inputData, endIndex);
				System.out.println(Arrays.toString(inputData));
				if (swaps == 0) {
					break;
				}
			}
		}
	}
	private static <T extends Comparable<T>> int bubbleSort(T[] inputData, int endIndex) {
		T temp;
		int swaps = 0;
		for (int index = 0; index < endIndex; index++) {
			if (inputData[index].compareTo(inputData[index + 1]) > 0) {
				temp = inputData[index + 1];
				inputData[index + 1] = inputData[index];
				inputData[index] = temp;
				swaps++;
			}
		}
		return swaps;
	}
	
	public static <T extends Comparable<T>> void selectionSort(T[] inputData) {
		if ((inputData != null) && (inputData.length > 1)) {
			for (int endIndex = inputData.length -1; endIndex > 0; endIndex--) {
				selectionSort(inputData, endIndex);
				System.out.println(Arrays.toString(inputData));
			}
		}
	}
	private static <T extends Comparable<T>> void selectionSort(T[] inputData, int endIndex) {
		int maxIndex = 0;
		for (int index = 1; index <= endIndex; index++) {
			if (inputData[index].compareTo(inputData[maxIndex]) > 0) {
				maxIndex = index;
			}
		}
		if (maxIndex != endIndex) {
			T swap = inputData[endIndex];
			inputData[endIndex] = inputData[maxIndex];
			inputData[maxIndex] = swap;
		}
	}
	
	public static <T extends Comparable<T>> void insertionSort(T[] inputData) {
		if ((inputData != null) && (inputData.length > 1)) {
			for (int endIndex = inputData.length - 2; endIndex >= 0; endIndex--) {
				insertionSort(inputData, endIndex);
				System.out.println(Arrays.toString(inputData));
			}
		}
	}
	private static <T extends Comparable<T>> void insertionSort(T[] inputData, int endIndex) {
		T swap;
		int swaps = 0;
		for (int index = endIndex; index < inputData.length - 1; index++) {
			if (inputData[index].compareTo(inputData[index + 1]) > 0) {
				swap = inputData[index + 1];
				inputData[index + 1] = inputData[index];
				inputData[index] = swap;
				swaps++;
			}
			else {
				break;
			}
		}
		System.out.println("Swaps: " + swaps);
	}
	
	public static <T extends Comparable<T>> void quickSort(T[] inputData) {
		if ((inputData != null) && (inputData.length > 1)) {
			quickSort(inputData, 0, inputData.length - 1);
			System.out.println(Arrays.toString(inputData));
		}
	}
	
	private static <T extends Comparable<T>> void quickSort(T[] inputData, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int splitIndex = partition(inputData, startIndex, endIndex);
			quickSort(inputData, startIndex, splitIndex);
			quickSort(inputData, splitIndex + 1, endIndex);
		}
	}
	private static <T extends Comparable<T>> int partition(T[] inputData, int startIndex, int endIndex) {
		T pivot = inputData[(startIndex + endIndex) / 2]; // get the pivot value from the middle of the range
		int leftIndex = startIndex;
		int rightIndex = endIndex;
		
		while (true) {
			while (inputData[leftIndex].compareTo(pivot) < 0) {
				leftIndex++;
			}
			while (inputData[rightIndex].compareTo(pivot) > 0) {
				rightIndex--;
			}
			if (leftIndex >= rightIndex) { // partitioning completed
				return rightIndex;
			}
			else {
				// swap
				T swap = inputData[leftIndex];
				inputData[leftIndex++] = inputData[rightIndex];
				inputData[rightIndex--] = swap;
			}
		}
	}
	
	public static <T extends Comparable<T>> void mergeSort(T[] inputData) {
		if ((inputData != null) && (inputData.length > 1)) {
			mergeSort(inputData, 0, inputData.length - 1, new Object[inputData.length]);
			System.out.println(Arrays.toString(inputData));
		}
	}
	
	private static <T extends Comparable<T>> void mergeSort(T[] inputData, int startIndex, int endIndex, Object[] additionalStorage) {
		if (startIndex == endIndex) {
			return;
		}
		int middleIndex = (startIndex + endIndex) / 2;
		mergeSort(inputData, startIndex, middleIndex, additionalStorage);
		mergeSort(inputData, middleIndex + 1, endIndex, additionalStorage);
		merge(inputData, startIndex, middleIndex, endIndex, additionalStorage);
	}
	
	private static <T extends Comparable<T>> void merge(T[] inputData, int startIndex, int middleIndex, int endIndex, Object[] additionalStorage) {
		// the 2 sub-arrays that must be merged are startIndex -> middleIndex and middleIndex + 1 -> endIndex
		int firstCurrentIndex = startIndex;
		int secondCurrentIndex = middleIndex + 1;
		int additionalCurrentIndex = startIndex;
		
		// while we have elements in both sub-arrays
		while ((firstCurrentIndex <= middleIndex) && (secondCurrentIndex <= endIndex)) {
			if (inputData[firstCurrentIndex].compareTo(inputData[secondCurrentIndex]) <= 0) {
				additionalStorage[additionalCurrentIndex++] = inputData[firstCurrentIndex++];
			}
			else {
				additionalStorage[additionalCurrentIndex++] = inputData[secondCurrentIndex++];
			}
		}
		// while any elements are left in the first sub-array only
		while (firstCurrentIndex <= middleIndex) {
			additionalStorage[additionalCurrentIndex++] = inputData[firstCurrentIndex++];
		}
		// while any elements are left in the second sub-array only
		while (secondCurrentIndex <= endIndex) {
			additionalStorage[additionalCurrentIndex++] = inputData[secondCurrentIndex++];
		}
		
		// copy elements back in the input array
		for (int index = startIndex; index <= endIndex; index++) {
			inputData[index] = (T)additionalStorage[index];
		}
	}
	
	public static void main(String[] args) {
		Integer[] data = ArrayUtilities.generateRandomIntegerArray(20, 10, 99);
		System.out.println("Random data:");
		System.out.println(Arrays.toString(data));
		System.out.println("Bubble Sort:");
		bubbleSort(data);
		Integer[] sortedData = {10, 15, 20, 21, 25, 30, 35, 40, 45, 50, 55, 60, 61, 65, 70, 75, 80, 85, 90, 95};
		System.out.println("Sorted data:");
		System.out.println(Arrays.toString(sortedData));
		bubbleSort(sortedData);
		data = ArrayUtilities.generateRandomIntegerArray(20, 10, 99);
		System.out.println("Random data:");
		System.out.println(Arrays.toString(data));
		System.out.println("Selection Sort:");
		selectionSort(data);
		data = ArrayUtilities.generateRandomIntegerArray(20, 10, 99);
		System.out.println("Random data:");
		System.out.println(Arrays.toString(data));
		System.out.println("Insertion Sort:");
		insertionSort(data);
		System.out.println("Sorted data:");
		System.out.println(Arrays.toString(sortedData));
		insertionSort(sortedData);
		data = ArrayUtilities.generateRandomIntegerArray(20, 10, 99);
		System.out.println("Random data:");
		System.out.println(Arrays.toString(data));
		System.out.println("Quick Sort:");
		quickSort(data);
		data = ArrayUtilities.generateRandomIntegerArray(20, 10, 99);
		System.out.println("Random data:");
		System.out.println(Arrays.toString(data));
		System.out.println("Merge Sort:");
		mergeSort(data);
		
	}
}

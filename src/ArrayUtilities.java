import java.util.Arrays;
import java.util.Random;

public class ArrayUtilities {
	
	/**
	 * Generates an array of size {@code size} containing randomly generated integers
	 * in the range [{@code lowerEnd}, {@code upperEnd}].
	 * Returns {@code null} if the first argument is smaller than 1.
	 * @param size the size of the generated array
	 * @param lowerEnd the lower end of the range for the random int generator
	 * @param upperEnd the upper end of the range for the random int generator
	 * @return the generated array or {@code null}
	 */
	public static int[] generateRandomIntArray(int size, int lowerEnd, int upperEnd) {
		if (size < 1) {
			System.out.println("The size should be at least 1!");
			return null;
		}
		int[] array = new int[size];
		Random numberGenerator = new Random();
		for (int index = 0; index < size; index++) {
			array[index] = numberGenerator.nextInt(lowerEnd, upperEnd + 1);
		}
		return array;
	}
	
	public static Integer[] generateRandomIntegerArray(int size, int lowerEnd, int upperEnd) {
		if (size < 1) {
			System.out.println("The size should be at least 1!");
			return null;
		}
		Integer[] array = new Integer[size];
		Random numberGenerator = new Random();
		for (int index = 0; index < size; index++) {
			array[index] = numberGenerator.nextInt(lowerEnd, upperEnd + 1);
		}
		return array;
	}
	
	public static int sum(int[] inputData) {
		int sumSoFar = 0;
		if (inputData != null) {
			for (int item : inputData) {
				sumSoFar += item;
			}
		}
		return sumSoFar;
	}
	
	public static <E extends Integer> int sum(MyFlexibleArray<E> myCollection) {
		int sumSoFar = 0;
		if (myCollection != null) {
			for (E item : myCollection) {
				sumSoFar += item;
			}
		}
		return sumSoFar;
	}
	
	
	public static void main(String[] arguments) {
		int[] generatedArray;
		generatedArray = generateRandomIntArray(0, 0, 10);
		System.out.println(generatedArray);
		System.out.println("Sum = " + sum(generatedArray));
		generatedArray = generateRandomIntArray(10, -10, 10);
		System.out.println(generatedArray);
		System.out.println(Arrays.toString(generatedArray));
		
		int[] knownArray = {-1, 1, -2, 2, -3, 3, -4, 4};
		System.out.println(Arrays.toString(knownArray) + " sum=" + sum(knownArray));
		
		
		System.out.println(Arrays.toString(generateRandomIntegerArray(20, 0, 50)));
		
		int[][] tdArray = new int[10][];
		for (int row = 0; row < 10; row++) {
			tdArray[row] = generateRandomIntArray(10 - row, 10, 99);
		}
		System.out.println(Arrays.deepToString(tdArray));
		int row = 0;
		for (;; row++) {
			if (row >= tdArray.length) {
				break;
			}
			System.out.println(Arrays.toString(tdArray[row]) + " sum=" + sum(tdArray[row]));
		}
	}
}

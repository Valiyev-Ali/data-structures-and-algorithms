
public interface MyFlexibleIntADT {
	
	/**
	 * Retrieve the element at the given index.
	 * @param index
	 * @return
	 */
	public int get(int index);

	/**
	 * Store the first argument at the given index.
	 * @param newElement
	 * @param index
	 */
	public void set(int newElement, int index);
	
	/**
	 * Retrieves the number of elements.
	 * @return
	 */
	public int getSize();
	
	/**
	 * Returns {@code true} if no elements are stored, and {@code false} otherwise.
	 * @return
	 */
	public boolean isEmpty();
	
	/**
	 * Append the argument.
	 * @param newElement
	 */
	public void add(int newElement);
	
	/**
	 * Insert the first argument at the given index.
	 * @param newElement
	 * @param index
	 */
	public void add(int newElement, int index);
	
	/**
	 * Remove the element at the given index ar return it.
	 * @param index
	 * @return
	 */
	public int remove(int index);
}

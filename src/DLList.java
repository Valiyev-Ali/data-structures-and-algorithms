/**
 * Implements a doubly-linked list using doubly-linked nodes.
 * @param <D> the type of data stored in the nodes
 */
public class DLList <D extends Comparable<D>> {
	/**
	 * The first node in the list.
	 */
	private DLNode<D> firstNode;
	/**
	 * The last node in the list.
	 */
	private DLNode<D> lastNode;
	/**
	 * The number of nodes in the list.
	 */
	private int size = 0;
	
	/**
	 * Creates a new empty doubly-linked list.
	 */
	public DLList() {
		firstNode = lastNode = null;
		size = 0;
	}
	
	/**
	 * Retrieves the size of the list.
	 * @return the number of nodes in the list
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Checks if the list is empty.
	 * @return {@code true} if the list is empty, and {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Creates a new node for the data received as argument and adds it at the end of the list.
	 * @param newData the data to be added to the list
	 * @return the newly created node
	 */
	public DLNode<D> append(D newData) {
		DLNode<D> newNode = new DLNode<D>(newData);
		if (lastNode == null) {
			firstNode = lastNode = newNode;
		}
		else {
			newNode.setPrevious(lastNode);
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
		size++;
		return newNode;
	}

	public DLNode<D> insertAfter(DLNode<D> existingNode, D newData) {
		if (existingNode == null) {
			return null;
		}
		DLNode<D> newNode = new DLNode<D>(newData);
		newNode.setNext(existingNode.getNext());
		newNode.setPrevious(existingNode);
		existingNode.setNext(newNode);
		if (newNode.getNext() != null) {
			newNode.getNext().setPrevious(newNode);
		}
		if (lastNode == existingNode) {
			lastNode = newNode;
		}
		size++;
		return newNode;
	}

	public boolean remove(DLNode<D> existingNode) {
		if (existingNode == null) {
			return false;
		}
		if (existingNode.getNext() != null) {
			existingNode.getNext().setPrevious(existingNode.getPrevious());
		}
		if (existingNode.getPrevious() != null) {
			existingNode.getPrevious().setNext(existingNode.getNext());
		}
		if (firstNode == existingNode) {
			firstNode = existingNode.getNext();
		}
		if (lastNode == existingNode) {
			lastNode = existingNode.getPrevious();
		}
		size--;
		return true;
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "the list is empty";
		}
		StringBuffer description = new StringBuffer(firstNode.toString());
		DLNode<D> currentNode = firstNode.getNext();
		while (currentNode != null) {
			description.append(" <-> ").append(currentNode);
			currentNode = currentNode.getNext();
		}
		return description.toString();
	}
	
	public static void main(String[] arguments) {
		DLList<String> days = new DLList<String>();
		System.out.println(days);
		DLNode<String> monday = days.append("Monday");
		System.out.println(days);
		DLNode<String> tuesday = days.append("Tuesday");
		System.out.println(days);
		DLNode<String> wednesday = days.append("Wednesday");
		System.out.println(days);
		DLNode<String> thursday = days.append("Thursday");
		System.out.println(days);
		DLNode<String> saturday = days.append("Saturday");
		System.out.println(days);

		days.insertAfter(thursday, "Friday");
		System.out.println(days);
		DLNode<String> error = days.insertAfter(wednesday, "tues");
		System.out.println(days);
		days.remove(error);
		System.out.println(days);
	}
}

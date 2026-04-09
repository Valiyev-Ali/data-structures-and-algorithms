/**
 * Implements a singly-linked list using singly-linked nodes
 * @param <D> generic type for the data stored in the nodes
 */
public class SLList <D> {
	/**
	 * Reference to the first node in the list.
	 */
	private SLNode<D> firstNode;
	/**
	 * Reference to the last node in the list.
	 */
	private SLNode<D> lastNode;
	/**
	 * The number of nodes in the list.
	 */
	private int size;
	
	/**
	 * Creates an empty singly-linked list.
	 */
	public SLList() {
		firstNode = lastNode = null;
		size = 0;
	}
	
	/**
	 * Retrieves the number of items in the list.
	 * @return the number of items in the list
	 */
	public int getSize() {
		return size;
	}
	/**
	 * Check if the list is empty (has no items).
	 * @return {@code true} if the list is empty and {@code false} otherwise
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Appends the argument to the list.
	 * @param newData the new data to append to the list (may be {@code null})
	 * @return the node that stores the argument in the list
	 */
	public SLNode<D> append(D newData) {
		SLNode<D> newNode = new SLNode<D>(newData);
		if (lastNode == null) {
			firstNode = lastNode = newNode;
		}
		else {
			lastNode.setNext(newNode);
			lastNode = newNode;
		}
		size++;
		return newNode;
	}
	
	/**
	 * Insert the argument as the first node in the list.
	 * @param newData the new data to prepend to the list (may be {@code null})
	 * @return the node that stores the argument in the list
	 */
	public SLNode<D> prepend(D newData) {
		SLNode<D> newNode = new SLNode<D>(newData);
		if (firstNode == null) {
			firstNode = lastNode = newNode;
		}
		else {
			newNode.setNext(firstNode);
			firstNode = newNode;
		}
		size++;
		return newNode;
	}
	
	/**
	 * Insert the second argument after the first argument in the list.
	 * Does nothing and returns {@code null} if the first argument is {@code null}.
	 * @param predecessor an existing node in the list
	 * @param newData the new data to be inserted after the first argument
	 * @return the node that stores the second argument in the list or {@code null}
	 */
	public SLNode<D> insertAfter(SLNode<D> predecessor, D newData) {
		if (predecessor == null) {
			return null;
		}
		SLNode<D> newNode = new SLNode<D>(newData);
		newNode.setNext(predecessor.getNext());
		predecessor.setNext(newNode);
		if (predecessor == lastNode) {
			lastNode = newNode;
		}
		size++;
		return newNode;
	}
	
	/**
	 * Attempts to remove the argument from the list.
	 * Returns {@code false} if the list is empty, the argument is {@code null} or not in the list.
	 * @param node the node to remove from the list
	 * @return {@code true} if the argument was removed from the list and {@code false} otherwise
	 */
	public boolean remove(SLNode<D> node) {
		if ((firstNode == null) || (node == null)) {
			return false;
		}
		if (node == firstNode) {
			firstNode = firstNode.getNext();
			size--;
			if (firstNode == null) { // list empty after removal?
				lastNode = null;
			}
			return true;
		}
		SLNode<D> predecessorNode = firstNode;
		SLNode<D> currentNode = firstNode.getNext();
		while (currentNode != null) {
			if (currentNode == node) {
				predecessorNode.setNext(currentNode.getNext());
				size--;
				if (currentNode == lastNode) {
					lastNode = predecessorNode;
				}
				return true;
			}
			predecessorNode = predecessorNode.getNext();
			currentNode = currentNode.getNext();
		}
		return false;
	}

	@Override
	public String toString() {
		if (size == 0) {
			return "the list is empty";
		}
		StringBuffer description = new StringBuffer();
		SLNode<D> currentNode = firstNode;
		while (currentNode != null) {
			if (currentNode != firstNode) {
				description.append(" -> ");
			}
			description.append(currentNode);
			currentNode = currentNode.getNext();
		}
		return description.toString();
	}
	
	public String toStringInReverse1() {
		if (size == 0) {
			return "empty is the list";
		}
		StringBuffer description = new StringBuffer(firstNode.toString());
		SLNode<D> currentNode = firstNode.getNext();
		while (currentNode != null) {
			description.insert(0, " <- ").insert(0, currentNode);
			currentNode = currentNode.getNext();
		}
		return description.toString();
	}
	
	public String toStringInReverse2() {
		if (size == 0) {
			return "empty is the list";
		}
		return toStringInReverse2(firstNode);
	}
	private String toStringInReverse2(SLNode<D> node) {
		if (node.getNext() == null) { // base case
			return node.toString();
		}
		// general case
		return toStringInReverse2(node.getNext()) + " <- " + node.toString();
	}
	
	public static void main(String[] args) {
		SLList<String> myList = new SLList<String>();
		System.out.println(myList.firstNode);
		System.out.println(myList.lastNode);
		System.out.println(myList.getSize());
		System.out.println(myList);
		System.out.println("Remove \"test\": " + myList.remove(new SLNode<String>("test")));
		myList.append("Monday");
		System.out.println(myList);
		SLNode<String> tempNode = myList.append("Tuesday");
		System.out.println(myList);
		SLNode<String> tempNode2 = myList.append("Thursday");
		System.out.println(myList);
		myList.prepend("Sunday");
		System.out.println(myList);
		myList.insertAfter(tempNode, "Wednesday");
		System.out.println(myList);
		myList.insertAfter(tempNode2, "Friday");
		System.out.println(myList);
		System.out.println(myList.toStringInReverse1());
		System.out.println(myList.toStringInReverse2());
		System.out.println("Remove \"test\": " + myList.remove(new SLNode<String>("test")));
		System.out.println(myList);
		System.out.println("Remove \"null\": " + myList.remove(null));
		System.out.println(myList);
		System.out.println("Remove \"Sunday\": " + myList.remove(myList.firstNode));
		System.out.println(myList);
		System.out.println("Remove \"Friday\": " + myList.remove(myList.lastNode));
		System.out.println(myList);
		System.out.println("Remove \"Tuesday\": " + myList.remove(tempNode));
		System.out.println(myList);
		System.out.println("Remove \"Thursday\": " + myList.remove(tempNode2));
		System.out.println(myList);
		System.out.println("Remove \"Monday\": " + myList.remove(myList.firstNode));
		System.out.println(myList);
		System.out.println("Remove \"Wednesday\": " + myList.remove(myList.lastNode));
		System.out.println(myList);
	}
}

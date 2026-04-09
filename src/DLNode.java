/**
 * Implements a doubly-linked node for a doubly-linked list.
 * @param <D> the type of the data stored in such a node.
 */
public class DLNode <D extends Comparable<D>> {
	/**
	 * Stores the data associated with this node.
	 */
	private final D data;
	/**
	 * Reference to the previous node in the list.
	 */
	private DLNode<D> previous;
	/**
	 * Reference to the next node in the list.
	 */
	private DLNode<D> next;
	
	/**
	 * Creates a new doubly-linked node and stores the argument in it.
	 * The argument can be {@code null}.
	 * @param nodeData the data to be stored in this node
	 */
	public DLNode(D nodeData) {
		data = nodeData;
		previous = null;
		next = null;
	}
	
	/**
	 * Retrieves the previous node in the list (may be {@code null}).
	 * @return the node in front of this one in the list
	 */
	public DLNode<D> getPrevious() {
		return previous;
	}
	/**
	 * Sets the previous node in the list (may be {@code null}).
	 * @param previousNode the node in front of this one in the list
	 */
	public void setPrevious(DLNode<D> previousNode) {
		previous = previousNode;
	}
	
	/**
	 * Retrieves the next node in the list (may be {@code null}).
	 * @return the node following this one in the list
	 */
	public DLNode<D> getNext() {
		return next;
	}
	/**
	 * Sets the next node in the list (may be {@code null}).
	 * @param nextNode the node following this one in the list
	 */
	public void setNext(DLNode<D> nextNode) {
		next = nextNode;
	}
	
	@Override
	public String toString() {
		if (data == null) {
			return "null";
		}
		return data.toString();
	}
	
	public static void main(String[] args) {
		DLNode<String> today = new DLNode<String>("Tuesday");
		System.out.println(today);
		System.out.println(today.getNext());
		DLNode<String> tomorrow = new DLNode<String>("Wednesday");
		//today.next = tomorrow;
		today.setNext(tomorrow);
		//tomorrow.previous = today;
		tomorrow.setPrevious(today);
		System.out.println(today.getNext());
		System.out.println(tomorrow.getPrevious());
	}
}

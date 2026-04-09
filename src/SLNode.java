/**
 * Implements a singly-linked node for a singly-linked list.
 * @param <D> generic type for the data stored in the node
 */
public class SLNode <D> {
	/**
	 * The data associated with this node.
	 */
	private final D data;
	/**
	 * Reference to the next node in the list.
	 */
	private SLNode<D> next;
	
	/**
	 * Creates a new singly-linked node for the data received as argument.
	 * @param nodeData the data to be stored in the node (may be {@code null})
	 */
	public SLNode(D nodeData) {
		data = nodeData;
		next = null;
	}
	
	/**
	 * Retrieves the data associated with this node.
	 * @return the data (may be {@code null})
	 */
	public D getData() {
		return data;
	}
	
	/**
	 * Retrieves the reference to the next node in the list.
	 * Returns {@code null} if this is the last node in the list.
	 * @return the reference to the next node in the list or {@code null}
	 */
	public SLNode<D> getNext() {
		return next;
	}
	/**
	 * Sets the reference to the node following this one in the list.
	 * A {@code null} argument indicates that this is the last node in the list
	 * @param nextNode the reference to the next node in the list or {@code null}
	 */
	public void setNext(SLNode<D> nextNode) {
		next = nextNode;
	}
	
	@Override
	public String toString() {
		return data == null? "null": data.toString();
	}
	
	public static void main(String[] args) {
		SLNode<String> day = new SLNode<String>(null);
		System.out.println(day);
		day = new SLNode<String>("Monday");
		SLNode<String> newDay = new SLNode<String>("Tuesday");
		day.setNext(newDay);
		System.out.println(day);
		System.out.println(day.getNext());
		System.out.println(newDay);
		System.out.println(newDay.getNext());
	}
}

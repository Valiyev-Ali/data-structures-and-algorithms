/**
 * Implements a stack data type.
 */
public class MyStack<D> {

    /**
     * The internal stack representation based on a singly-linked list.
     */
    private final SLList<D> internalStack;

    /**
     *
     */
    private SLNode<D> firstNode;

    /**
     * Creates a new empty stack.
     */
    public MyStack() {
        internalStack = new SLList<>();
    }

    /**
     * Checks if the stack is empty.
     * @return {@code true} if the stack is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return internalStack.isEmpty();
    }

    /**
     * Determines number of elements in the stack.
     * @return the number of elements in the stack
     */
    public int getLength() {
        return internalStack.getSize();
    }

    /**
     * Retrieves the top elements from the stack without removing it.
     * @return the top element of the stack or {@code null} if the stack is empty
     */
    public D peek () {
        return firstNode == null? null : firstNode.getData();
    }

    /**
     * Inserts the argument on top of stack.
     * @param newData - the new data to insert to the stack
     */
    public void push(D newData) {
        firstNode = internalStack.prepend(newData);
    }

    /**
     * Removes and returns the stack's top element.
     * @return the top element of the stack or {@code null} if the stack is empty
     */
    public D pop() {
        if (firstNode == null) {
            return null;
        }
        D element = firstNode.getData();
        internalStack.remove(firstNode);
        firstNode = firstNode.getNext();
        return element;
    }

}

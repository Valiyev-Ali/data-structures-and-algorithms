import java.util.Arrays;
import java.util.Stack;

public class MyQueue<D> {

    private final Object[] internalQ;
    private int startIn = 0;
    private int size = 0;

    public MyQueue() {
        this(10);
    }
    public MyQueue(int capacity) {
        internalQ = new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * Retrieves the front element of the queue without removing it.
     * Returns {@code null} if the queue is empty.
     * Check if the queue is empty using {@link #inEmpty()} first if {@code null} elements can be stored in the queue.
     * @return the front element in the queue of {@code null}
     */
    public D peek() {
        if (size == 0) {
            return null;
        }
        return (D)internalQ[startIn];
    }

    public boolean enqueue(D newElement) {
        if (size == internalQ.length) {
            return false;
        }
        internalQ[(startIn + size++) % internalQ.length] = newElement;
        return true;
    }

    public D dequeue() {
        if (size == 0) {
            return null;
        }
        D front = (D)internalQ[startIn];
        startIn = (startIn + 1) % internalQ.length;
        size--;
        return front;
    }

    public static void main(String[] args) {
        MyQueue<String> days = new MyQueue<>(4);
        System.out.println(Arrays.toString(days.internalQ));
        System.out.println(days.startIn);
        System.out.println(days.getSize());
        days.enqueue("Monday");
        System.out.println(Arrays.toString(days.internalQ));
        System.out.println(days.startIn);
        System.out.println(days.getSize());
        days.enqueue("Tuesday");
        System.out.println(Arrays.toString(days.internalQ));
        System.out.println(days.startIn);
        System.out.println(days.getSize());
        days.enqueue("Wednesday");
        System.out.println(Arrays.toString(days.internalQ));
        System.out.println(days.startIn);
        System.out.println(days.getSize());
        days.enqueue("Thursday");
        System.out.println(Arrays.toString(days.internalQ));
        System.out.println(days.startIn);
        System.out.println(days.getSize());
        System.out.println(days.enqueue("Friday"));
        System.out.println(Arrays.toString(days.internalQ));
        System.out.println(days.startIn);
        System.out.println(days.getSize());
        System.out.println(days.dequeue());
        System.out.println(days.enqueue("Friday"));
        System.out.println(Arrays.toString(days.internalQ));
        System.out.println(days.startIn);
        System.out.println(days.getSize());
    }

}

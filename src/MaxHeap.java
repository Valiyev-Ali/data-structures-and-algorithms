import java.util.ArrayList;
import java.util.List;

/**
 * A generic max-heap data structure backed by an ArrayList.
 * The largest element is always at the root (index 0).
 *
 * @param <D> the type of elements stored, must be Comparable
 */
public class MaxHeap <D extends Comparable<D>>{

    private List<D> heapData;

    /**
     * Constructs an empty MaxHeap.
     */
    public MaxHeap() {
        heapData = new ArrayList<D>();
    }

    /**
     * Returns the index of the parent of the node at the given index.
     *
     * @param nodeIndex the index of the node
     * @return the parent's index, or -1 if the node is the root
     */
    private int getParent(int nodeIndex) {
        if (nodeIndex <= 0) {
            return -1;
        }
        return (nodeIndex - 1) / 2;
    }

    /**
     * Returns the index of the left child of the node at the given index.
     *
     * @param nodeIndex the index of the node
     * @return the left child's index, or -1 if it does not exist
     */
    private int getLeftChild(int nodeIndex) {
        if (nodeIndex < 0) {
            return -1;
        }
        int childIndex = (nodeIndex * 2) + 1;
        if (childIndex < heapData.size()) {
            return childIndex;
        }
        return -1;
    }

    /**
     * Returns the index of the right child of the node at the given index.
     *
     * @param nodeIndex the index of the node
     * @return the right child's index, or -1 if it does not exist
     */
    private int getRightChild(int nodeIndex) {
        if (nodeIndex < 0) {
            return -1;
        }
        int childIndex = (nodeIndex * 2) + 2;
        if (childIndex < heapData.size()) {
            return childIndex;
        }
        return -1;
    }

    /**
     * Adds a new element to the heap and restores the max-heap property.
     *
     * @param newData the element to add; ignored if null
     * @return true if the element was added, false if newData is null
     */
    public boolean add(D newData) {
        if (newData == null) {
            return false;
        }
        heapData.addLast(newData);
        percolateUp(heapData.size() - 1);
        return true;
    }

    /**
     * Removes and returns the maximum element (the root) from the heap.
     * The last element is moved to the root and percolated down to restore
     * the max-heap property.
     *
     * @return the maximum element, or null if the heap is empty
     */
    public D remove() {
        if (heapData.isEmpty()) {
            return null;
        }
        if(heapData.size() == 1) {
            return heapData.removeFirst();
        }
        D maxValue = heapData.getFirst();
        heapData.set(0, heapData.removeLast());
        percolateDown(0);
        return maxValue;
    }

    /**
     * Restores the max-heap property downward from the given index by
     * repeatedly swapping the node with its largest child until the node
     * is greater than or equal to both children.
     *
     * @param currIndex the index to percolate down from
     */
    private void percolateDown(int currIndex) {
        int largest = currIndex;
        int leftIndex = getLeftChild(currIndex);
        int rightIndex = getRightChild(currIndex);

        if (rightIndex != -1 && heapData.get(largest).compareTo(heapData.get(rightIndex)) < 0) {
            largest = rightIndex;
        }

        if (leftIndex != -1 && heapData.get(largest).compareTo(heapData.get(leftIndex)) < 0) {
            largest = leftIndex;
        }

        if(largest != currIndex) {
            D tempVal = heapData.get(currIndex);
            heapData.set(currIndex, heapData.get(largest));
            heapData.set(largest, tempVal);
            percolateDown(largest);
        }
    }

    /**
     * Restores the max-heap property upward from the given index by
     * repeatedly swapping the node with its parent until the node is
     * less than or equal to its parent.
     *
     * @param newIndex the index to percolate up from
     */
    private void percolateUp(int newIndex) {
        int parentIndex = getParent(newIndex);
        if (newIndex <= 0 || heapData.get(parentIndex).compareTo(heapData.get(newIndex)) >= 0) {
            return;
        }

        D tempVal = heapData.get(parentIndex);

        heapData.set(parentIndex, heapData.get(newIndex));
        heapData.set(newIndex, tempVal);

        percolateUp(parentIndex);
    }

    /**
     * Prints all elements in the heap in breadth-first (level) order.
     */
    public void breadthFirst() {
        System.out.println(heapData.toString());
    }

    public static void main(String[] args) {
        MaxHeap<Integer> myHeap = new MaxHeap<Integer>();
        myHeap.add(33);
        myHeap.breadthFirst();
        myHeap.add(55);
        myHeap.breadthFirst();
        myHeap.add(80);
        myHeap.breadthFirst();
        myHeap.add(88);
        myHeap.breadthFirst();
        myHeap.add(85);
        myHeap.breadthFirst();

        myHeap.remove();
        myHeap.breadthFirst();
    }

}

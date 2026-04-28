import java.util.ArrayList;
import java.util.List;

public class MaxHeap <D extends Comparable<D>>{

    private List<D> heapData;

    public MaxHeap() {
        heapData = new ArrayList<D>();
    }

    private int getParent(int nodeIndex) {
        if (nodeIndex <= 0) {
            return -1;
        }
        return (nodeIndex - 1) / 2;
    }
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

    public boolean add(D newData) {
        if (newData == null) {
            return false;
        }
        heapData.addLast(newData);
        percolateUp(heapData.size() - 1);
        return true;
    }

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

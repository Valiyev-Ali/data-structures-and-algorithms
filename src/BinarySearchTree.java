/**
 * Implements a Binary Search Tree (BST) where each node's left subtree contains
 * only values less than the node, and the right subtree contains values greater
 * than or equal to the node.
 *
 * @param <D> the type of data stored in the tree; must implement {@link Comparable}
 */
public class BinarySearchTree <D extends Comparable<D>> {
    /** The underlying binary tree used to store nodes. */
    private BinaryTree<D> internalTree;

    /**
     * Creates an empty binary search tree.
     */
    public BinarySearchTree() {
        internalTree = null;
    }

    /**
     * Inserts a new value into the binary search tree.
     *
     * @param newValue the value to insert; ignored if {@code null}
     * @return {@code true} if the value was inserted, {@code false} if {@code newValue} is {@code null}
     */
    public boolean add(D newValue) {
        if (newValue == null) {
            return false;
        }
        if (internalTree == null) {
            internalTree = new BinaryTree<D>(newValue);
        }
        else {
            add(internalTree.getRootNode(), newValue);
        }
        return true;
    }

    /**
     * Recursively finds the correct position for {@code newValue} starting from {@code currentNode}
     * and inserts it as a leaf.
     *
     * @param currentNode the node to compare against
     * @param newValue    the value to insert
     */
    private void add(BinaryTreeNode<D> currentNode, D newValue) {
        int comparisonResult = currentNode.getData().compareTo(newValue);
        if (comparisonResult <= 0) {
            if (currentNode.getRight() == null) {
                currentNode.setRightChild(newValue);
            }
            else {
                add(currentNode.getRight(), newValue);
            }
        }
        else {
            if (currentNode.getLeft() == null) {
                currentNode.setLeftChild(newValue);
            }
            else {
                add(currentNode.getLeft(), newValue);
            }
        }
    }

    /**
     * Prints all values in the tree using breadth-first (level-order) traversal.
     * Prints a message if the tree is empty.
     */
    public void breadthFirst() {
        if (internalTree == null) {
            System.out.println("The binary search tree is empty");
        }
        else {
            internalTree.breadthFirst();
        }
    }

    /**
     * Prints all values in the tree using depth-first traversal (pre-order, in-order, and post-order).
     * Prints a message if the tree is empty.
     */
    public void depthFirst() {
        if (internalTree == null) {
            System.out.println("The binary search tree is empty");
        } else {
            internalTree.depthFirst();
        }
    }

    public boolean search(D query) {
        if (internalTree == null || query == null) {
            System.out.println(query + " not found");
            return false;
        }
        else {
            return search(query, internalTree.getRootNode());
        }
    }
    private boolean search(D query, BinaryTreeNode<D> currNode) {
        int compResult = query.compareTo(currNode.getData());
        if (compResult == 0) {
            System.out.println(query + " was found in the binary search tree");
            return true;
        }
        else if (compResult > 0 && currNode.getRight() != null) {
            return search(query, currNode.getRight());
        }
        else if (currNode.getLeft() != null) {
            return search(query, currNode.getLeft());
        }
        System.out.println(query + " not found");
        return false;
    }

    public boolean remove(D value) {
        if (internalTree == null || value == null) {
            System.out.println(value + " not found");
            return false;
        }
        BinaryTreeNode<D> valueNode = findNode(value);
        if (valueNode == null) {
            System.out.println(value + " not found");
            return false;
        }
        else {
            remove(valueNode);
            System.out.println(value + " was removed from the binary search tree");
            return true;
        }
    }

    private BinaryTreeNode<D> findNode (D value) {
        return findNode(internalTree.getRootNode(), value);
    }
    private BinaryTreeNode<D> findNode (BinaryTreeNode<D> currentNode, D value) {
        int compResult = value.compareTo(currentNode.getData());
        if (compResult == 0) {
            return currentNode;
        }
        else if (compResult > 0 && currentNode.getRight() != null) {
            return findNode(currentNode.getRight(), value);
        }
        else if (compResult < 0 && currentNode.getLeft() != null) {
            return findNode(currentNode.getLeft(), value);
        }
        return null;
    }

//    private void remove(BinaryTreeNode<D> node) {
//        if((node.getLeft() == null) && (node.getRight() == null)) {
//            if (internalTree.getRootNode() == node) {
//
//            }
//        }
//
//    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> firstBst = new BinarySearchTree<Integer>();
        firstBst.add(3);
        firstBst.add(4);
        firstBst.add(5);
        firstBst.add(6);
        firstBst.add(7);
        firstBst.add(8);
        firstBst.breadthFirst();
        firstBst.depthFirst();

        System.out.println("\nSecond Tree:");
        BinarySearchTree<Integer> secondtBst = new BinarySearchTree<Integer>();
        secondtBst.add(3);
        secondtBst.add(4);
        secondtBst.add(5);
        secondtBst.add(6);
        secondtBst.add(7);
        secondtBst.add(8);
        secondtBst.breadthFirst();
        secondtBst.depthFirst();
    }
}

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

    /**
     * Searches for a value in the binary search tree.
     * Prints a message indicating whether the value was found.
     * @param query the value to search for
     * @return {@code true} if found, {@code false} if the tree is empty, {@code query} is {@code null},
     *         or the value is not present
     */
    public boolean search(D query) {
        if (internalTree == null || query == null) {
            System.out.println(query + " not found");
            return false;
        }
        else {
            return search(query, internalTree.getRootNode());
        }
    }
    /**
     * Recursively searches for {@code query} starting from {@code currNode}.
     * Prints a message when the value is found or confirmed absent.
     * @param query    the value to find
     * @param currNode the current node to compare against
     * @return {@code true} if {@code query} exists in the subtree rooted at {@code currNode}
     */
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

    /**
     * Removes the first occurrence of {@code value} from the binary search tree.
     * Prints a message indicating whether the removal succeeded.
     * @param value the value to remove
     * @return {@code true} if the value was found and removed, {@code false} otherwise
     */
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

    /**
     * Returns the node containing {@code value}, or {@code null} if not found.
     * @param value the value to locate
     * @return the matching node, or {@code null}
     */
    private BinaryTreeNode<D> findNode (D value) {
        return findNode(internalTree.getRootNode(), value);
    }

    /**
     * Recursively searches the subtree rooted at {@code currentNode} for a node containing {@code value}.
     * @param currentNode the root of the subtree to search
     * @param value       the value to locate
     * @return the matching node, or {@code null} if not found
     */
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

    /**
     * Removes {@code node} from the tree, rewiring parent and child pointers to preserve BST structure.
     * Handles four cases: leaf node, only left child, only right child, and two children.
     * When the node has two children it is replaced by its in-order successor.
     * @param node the node to remove
     */
    private void remove(BinaryTreeNode<D> node) {
        // case 1: leaf node — simply detach from parent
        if (node.getLeft() == null && node.getRight() == null) {
            if (internalTree.getRootNode() == node) {
                internalTree = null;
            }
            else {
                node.getParent().removeChild(node);
            }
        }
        // case 2: only left child — promote the left child into node's position
        else if (node.getRight() == null) {
            BinaryTreeNode<D> parentNode = node.getParent();
            BinaryTreeNode<D> childNode = node.getLeft();
            if (parentNode == null) {
                internalTree.setRootNode(childNode);
                childNode.setParent(null);
            }
            else if (node == parentNode.getLeft()) {
                parentNode.removeChild(node);
                parentNode.setLeftChild(childNode);
                childNode.setParent(parentNode);
            }
            else {
                parentNode.removeChild(node);
                parentNode.setRightChild(childNode);
                childNode.setParent(parentNode);
            }
        }
        // case 3: only right child — promote the right child into node's position
        else if (node.getLeft() == null) {
            BinaryTreeNode<D> parentNode = node.getParent();
            BinaryTreeNode<D> childNode = node.getRight();
            if (parentNode == null) {
                internalTree.setRootNode(childNode);
                childNode.setParent(null);
            }
            else if (node == parentNode.getLeft()) {
                parentNode.removeChild(node);
                parentNode.setLeftChild(childNode);
                childNode.setParent(parentNode);
            }
            else {
                parentNode.removeChild(node);
                parentNode.setRightChild(childNode);
                childNode.setParent(parentNode);
            }
        }
        // case 4: two children — overwrite with in-order successor's data, then remove the successor
        else {
            BinaryTreeNode<D> successor = node.getRight();
            while (successor.getLeft() != null) {
                successor = successor.getLeft();
            }
            node.setData(successor.getData());
            remove(successor);
        }
    }

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

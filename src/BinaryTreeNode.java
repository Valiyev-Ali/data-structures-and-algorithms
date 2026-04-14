/**
 * Implements a binary tree node with up to 2 children.
 */
public class BinaryTreeNode <D>{
    /**
     *The data associated with this node.
     */
    private final D data;
    /**
     * Reference to the parent of this node.
     */
    private BinaryTreeNode<D> parent;
    /**
     * Reference to the left child of this node.
     */
    public BinaryTreeNode<D> left;
    /**
     * Reference to the right child of this node.
     */
    public BinaryTreeNode<D> right;

    /**
     * Creates a new binary tree node with the data received from the argument.
     * @param data data to be stored in the node
     */
    public BinaryTreeNode(D data) {
        this.data = data;
    }

    public BinaryTreeNode<D> getLeft() {
        return left;
    }

    /**
     * Attempts to create a new binary tree node with the data received as argument and set it as the left child
     * of this node
     * @param leftData the data to be stored in the left child node
     */
    public BinaryTreeNode<D> setLeftChild(D leftData) {
        if (left != null) {
            left = new BinaryTreeNode<D>(leftData);
            left.parent = this;
            return left;
        }
        return null;
    }

    public BinaryTreeNode<D> getRight() {
        return right;
    }

    /**
     * Attempts to create a new binary tree node with the data received as argument and set it as the right child
     * of this node
     * @param rightData the data to be stored in the right child node
     */
    public BinaryTreeNode<D> setRightChild(D rightData) {
        if (right != null) {
            right = new BinaryTreeNode<D>(rightData);
            right.parent = this;
            return right;
        }
        return null;
    }

    public BinaryTreeNode<D> getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
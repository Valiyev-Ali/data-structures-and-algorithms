/**
 * Implements a binary tree node with up to 2 children.
 */
public class BinaryTreeNode <D>{
    /**
     *The data associated with this node.
     */
    private D data;
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
        if (left == null) {
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
        if (right == null) {
            right = new BinaryTreeNode<D>(rightData);
            right.parent = this;
            return right;
        }
        return null;
    }

    /**
     * Attempts to remove the argument as a child of this node.
     * Does nothing fi the argument is {@code null} or does not point to a child of this node.
     * If the argument is a child of this node, it's parent field will be set to null
     * @param child
     * @return
     */
    public boolean removeChild (BinaryTreeNode<D> child) {
        if (child != null) {
            if (child == left) {
                left.parent = null;
                left = null;
                return true;
            }
            else if (child == right) {
                right.parent = null;
                right = null;
                return true;
            }
        }
        return false;
    }

    public BinaryTreeNode<D> getParent() {
        return parent;
    }

    public void setData(D data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
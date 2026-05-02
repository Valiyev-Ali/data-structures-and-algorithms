import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements a generic binary tree that supports breadth-first and depth-first traversals.
 *
 * @param <D> the type of data stored in the tree
 */
public class BinaryTree <D> {

    /** The root node of this binary tree. */
    private BinaryTreeNode<D> root;

    /**
     * Creates a binary tree with a single root node containing the given data.
     * @param rootData the data to store in the root node
     */
    public BinaryTree(D rootData) {
        root = new BinaryTreeNode<D>(rootData);
    }

    /**
     * Returns the root node of this tree.
     * @return the root {@link BinaryTreeNode}
     */
    public BinaryTreeNode<D> getRootNode() {
        return root;
    }

    public void setRootNode(BinaryTreeNode<D> newRootNode) {
        root = newRootNode;
    }

    /**
     * Prints all values using breadth-first (level-order) traversal.
     * Prints a message if the tree is empty.
     */
    public void breadthFirst() {
        if (root == null) {
            System.out.println("Binary tree is Empty");
            return;
        }
        System.out.println("Breadth First:");
        Queue<BinaryTreeNode<D>> queue = new LinkedList<BinaryTreeNode<D>>();
        queue.add(root);
        BinaryTreeNode<D> currentNode;
        while (!queue.isEmpty()) {
            currentNode =  queue.poll();
            System.out.print(currentNode + " ");
            if (currentNode.getLeft() != null) {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null) {
                queue.add(currentNode.getRight());
            }
        }
        System.out.println();
    }

    /**
     * Prints all values using depth-first traversal in pre-order, in-order, and post-order.
     * Prints a message if the tree is empty.
     */
    public void depthFirst() {
        if (root == null) {
            System.out.println("Binary tree is Empty");
            return;
        }
        System.out.println("Pre order:");
        preOrder(root);

        System.out.println("\nIn order:");
        inOrder(root);

        System.out.println("\nPost order:");
        postOrder(root);
    }

    /**
     * Recursively prints nodes in pre-order: root, left subtree, right subtree.
     * @param currData the current node
     */
    private void preOrder (BinaryTreeNode<D> currData) {
        System.out.print(currData + " ");

        if (currData.getLeft() != null) {
            preOrder(currData.getLeft());
        }
        if (currData.getRight() != null) {
            preOrder(currData.getRight());
        }
    }

    /**
     * Recursively prints nodes in in-order: left subtree, root, right subtree.
     * @param currData the current node
     */
    private void inOrder (BinaryTreeNode<D> currData) {
        if (currData.getLeft() != null) {
            inOrder(currData.getLeft());
        }

        System.out.print(currData + " ");

        if (currData.getRight() != null) {
            inOrder(currData.getRight());
        }
    }

    /**
     * Recursively prints nodes in post-order: left subtree, right subtree, root.
     * @param currData the current node
     */
    private void postOrder (BinaryTreeNode<D> currData) {
        if (currData.getLeft() != null) {
            postOrder(currData.getLeft());
        }
        if (currData.getRight() != null) {
            postOrder(currData.getRight());
        }

        System.out.print(currData + " ");
    }

    public static void main(String[] args) {
        int temp;
        BinaryTree<Integer> bTree = new BinaryTree<Integer>(5);
        BinaryTreeNode<Integer> tempNode = bTree.getRootNode().setLeftChild(3);
        tempNode.setRightChild(4);
        tempNode = bTree.getRootNode().setRightChild(7);
        tempNode.setLeftChild(6);
        tempNode.setRightChild(8);

        bTree.breadthFirst();
        bTree.depthFirst();
    }
}

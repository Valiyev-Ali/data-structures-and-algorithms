import java.util.LinkedList;
import java.util.Queue;

/**
 * Implements a general tree, in which a node can have as many children as needed.
 */
public class Tree <D> {
    /**
     * The root node of the tree.
     */
    private final TreeNode<D> root;

    /**
     * Creates a new tree and its root node. Stores the argument in the root node.
     *
     */
    public Tree(D rootData) {
        root = new TreeNode<D>(rootData, null);
    }

    /**
     * Retrieves root node of this tree.
     * @return the root node of this tree.
     */
    public TreeNode<D> getRootNode() {
        return root;
    }

    public void breadthFirst() {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        System.out.println("Breadth firs:");
        Queue<TreeNode<D>> bfQueue = new LinkedList<TreeNode<D>>();
        bfQueue.offer(root);
        TreeNode<D> currentNode;
        while (!bfQueue.isEmpty()) {
            currentNode = bfQueue.poll();
            System.out.print(" " + currentNode.toString());
            for (TreeNode<D> child : currentNode.getChildren()) {
                bfQueue.offer(child);
            }
        }
        System.out.println();
    }

    public static void main(String[] arg) {
        Tree<Integer> numbersTree = new Tree<Integer>(1);
        TreeNode<Integer> parent = new TreeNode<Integer>(2, numbersTree.getRootNode());
        new TreeNode(5, parent);
        new TreeNode(6, parent);
        new TreeNode(3, parent);
        parent = new TreeNode<Integer>(4, numbersTree.getRootNode());
        new TreeNode(7, parent);
        numbersTree.breadthFirst();
    }
}

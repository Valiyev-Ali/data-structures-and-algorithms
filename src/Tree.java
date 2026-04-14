import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
     * @param rootData the data to store in the root node
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

    /**
     * Traverses the tree in breadth-first order and prints each node to standard output.
     * <p>
     * Starting from the root, this method visits all nodes at the current depth level
     * before moving on to nodes at the next depth level. Traversal is implemented
     * iteratively using a FIFO queue: the root is enqueued first, then on each
     * iteration a node is dequeued, printed, and all of its children are enqueued.
     * <p>
     * If the tree has no root, a message is printed and the method returns without
     * performing any traversal.
     */
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

    public void preOrder() {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        System.out.println("Preorder:");
        Deque<TreeNode<D>> preOrderStack = new LinkedList<TreeNode<D>>();
        preOrderStack.offer(root);
        TreeNode<D> currentNode;
        while (!preOrderStack.isEmpty()) {
            currentNode = preOrderStack.pop();
            System.out.print(" " + currentNode.toString());
            for (int i = currentNode.getChildren().size() - 1; i >= 0; i--) {
                preOrderStack.push(currentNode.getChildren().get(i));
            }
        }
        System.out.println();
    }

    public void postOrder() {
        if (root == null) {
            System.out.println("The tree is empty");
            return;
        }
        System.out.println("Postorder:");
        List<TreeNode<D>> postOrderList = new LinkedList<TreeNode<D>>();
        postOrder(root, postOrderList);
        for (TreeNode<D> child : postOrderList) {
            System.out.print(" " + child.toString());
        }
        System.out.println();
    }

    private void postOrder(TreeNode<D> currentNode, List<TreeNode<D>> visitedList) {
        if (currentNode == null) {
            return;
        }
        for (TreeNode<D> child : currentNode.getChildren()) {
            postOrder(child, visitedList);
        }
        visitedList.add(currentNode);
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
        numbersTree.preOrder();
        numbersTree.postOrder();
    }
}

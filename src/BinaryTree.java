import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree <D> {

    private BinaryTreeNode<D> root;

    public BinaryTree(D rootData) {
        root = new BinaryTreeNode<D>(rootData);
    }

    public BinaryTreeNode<D> getRoot() {
        return root;
    }

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

    private void preOrder (BinaryTreeNode<D> currData) {
        System.out.print(currData + " ");

        if (currData.getLeft() != null) {
            preOrder(currData.getLeft());
        }
        if (currData.getRight() != null) {
            preOrder(currData.getRight());
        }
    }

    private void inOrder (BinaryTreeNode<D> currData) {
        if (currData.getLeft() != null) {
            inOrder(currData.getLeft());
        }

        System.out.print(currData + " ");

        if (currData.getRight() != null) {
            inOrder(currData.getRight());
        }
    }

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
        BinaryTreeNode<Integer> tempNode = bTree.getRoot().setLeftChild(3);
        tempNode.setRightChild(4);
        tempNode = bTree.getRoot().setRightChild(7);
        tempNode.setLeftChild(6);
        tempNode.setRightChild(8);

        bTree.breadthFirst();
        bTree.depthFirst();
    }
}
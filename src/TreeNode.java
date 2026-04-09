import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Implements a general tree node with as many children as needed.
 */
public class TreeNode <D> {
    /**
     * The data associated with this node.
     */
    private D data;
    /**
     * Reference to the parent of this node.
     */
    private final TreeNode<D> parent;
    /**
     * List of references to the children of this node.
     */
    private final List<TreeNode<D>> children;

    /**
     * Unmodifiable ist of references to the children of this node.
     */
    private final List<TreeNode<D>> childrenUR;

    /**
     * Creates a new tree node with the data received from the first argument,
     * and adds it as a child to the parent node received in the second argument.
     * @param nodeData data to be stored in the node
     * @param parentNode the parent of this node
     */
    public TreeNode(D nodeData, TreeNode<D> parentNode) {
        data = nodeData;
        parent = parentNode;
        children = new ArrayList<TreeNode<D>>();
        childrenUR = Collections.unmodifiableList(children);
        if (parent != null) {
            parent.children.add(this);
        }
    }

    /**
     * Retrieves the data stored in this node.
     * @return the data stored in this node
     */
    public D getData() {
        return data;
    }

    /**
     * Retrieves the parent of this node.
     * @return the parent of this node.
     */
    public TreeNode<D> getParent() {
        return parent;
    }

    /**
     * Retrieves the unmodifiable list of children for this node.
     * @return the list of children for this node.
     */
    public List<TreeNode<D>> getChildren() {
        return childrenUR;
    }

    /**
     * Attempts to remove the argument children list.
     * @param existingChild the child node to be removed.
     * @return {@code true} if the argument is successfully removed, {@code false} otherwise.
     */
    public boolean removeChild(TreeNode<D> existingChild) {
        if (existingChild != null) {
            for (int i = 0; i < children.size(); i++) {
                if (children.get(i).equals(existingChild)) {
                    children.remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(data);
    }
}

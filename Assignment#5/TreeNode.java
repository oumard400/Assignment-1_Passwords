package Data;

/**
 * @author Oumar Diallo
 * @param <T> 
 */
public class TreeNode<T> {

	protected TreeNode<T> left;
	protected T data;
	protected TreeNode<T> right;

	/**
	 * @param dataNode
	 */
	public TreeNode(T dataNode) {

		data = dataNode;
		left = right = null;
	}

	//Constructor that makes a deep copy 
	public TreeNode(TreeNode<T> node) {

		left = new TreeNode<>(node.left);
		data = node.data;
		right = new TreeNode<>(node.right);
	}

	public T getData() {
		return data;
	}
}
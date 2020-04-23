package Data;

import java.util.ArrayList;

/**
 * @author Oumar Diallo
 * 
 */
public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	private TreeNode<String> root;

	//Calls the buildTree method
	public MorseCodeTree() {
		buildTree();
	}

	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {

		if (code.length() == 1) {

			if (code.equals(".")) {
				root.left = new TreeNode<>(letter);
			} 
			else if (code.equals("-")) {
				root.right = new TreeNode<>(letter);
			}
		} 
		else {
			if (code.charAt(0) == '.') {
				addNode(root.left, code.substring(1), letter);
			} 
			else if (code.charAt(0) == '-') {
				addNode(root.right, code.substring(1), letter);
			}
		}
	}

	@Override
	public void buildTree() {
		root = new TreeNode<>("");

		insert("." , "e");
		insert("-" , "t");

		insert(".." , "i");
		insert(".-" , "a");
		insert("-." , "n");
		insert("--" , "m");

		insert("..." , "s");
		insert("..-" , "u");
		insert(".-." , "r");
		insert(".--" , "w");
		insert("-.." , "d");
		insert("-.-" , "k");
		insert("--." , "g");
		insert("---" , "o");

		insert("...." , "h");
		insert("...-" , "v");
		insert("..-." , "f");
		insert(".-.." , "l");
		insert(".--." , "p");
		insert(".---" , "j");
		insert("-..." , "b");
		insert("-..-" , "x");
		insert("-.-." , "c");
		insert("-.--" , "y");
		insert("--.." , "z");
		insert("--.-" , "q");
	}

	@Override
	public String fetch(String code) {
		return fetchNode(root, code);
	}

	@Override
	public String fetchNode(TreeNode<String> root, String code) {
		String letter = "";

		if (code.length() == 1) {

			if (code.equals(".")) {
				letter = root.left.data;
			} 
			else if (code.equals("-")) {
				letter = root.right.data;
			}
		} 
		else {
			if (!code.isEmpty()) {

				if (code.charAt(0) == '.') {

					letter = fetchNode(root.left, code.substring(1));
				} 
				else if (!code.isEmpty() && code.charAt(0) == '-') {

					letter = fetchNode(root.right, code.substring(1));
				}
			}
		}
		return letter;
	}

	@Override
	public TreeNode<String> getRoot() {
		return new TreeNode<>(root);
	}

	@Override
	public MorseCodeTree insert(String code, String letter) {
		addNode(root, code, letter);
		return this;
	}

	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		if (root != null) {

			LNRoutputTraversal(root.left, list);
			list.add(root.data);
			LNRoutputTraversal(root.right, list);
		}
	}

	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = new TreeNode<>(newNode);
	}

	@Override
	public ArrayList<String> toArrayList() {

		ArrayList<String> treeList = new ArrayList<>();
		LNRoutputTraversal(root, treeList);
		return treeList;
	}

	@Override
	public MorseCodeTree update() {
		throw new UnsupportedOperationException("Not supported yet");
	}

	@Override
	public MorseCodeTree delete(String data) {
		throw new UnsupportedOperationException("Not supported yet");
	}
}

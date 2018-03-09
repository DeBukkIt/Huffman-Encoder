package com.blogspot.debukkitsblog.huffman;

/**
 * A binary tree implementation to be used for a Huffman encoding tree
 * @author DeBukkIt
 */
public class BinTree {

	private Object content;
	private BinTree leftChild;
	private BinTree rightChild;
	
	private BinTree predecessor = null;
	private PathName predecessorPathName;
	
	/**
	 * Constructs a new binary tree node
	 * @param content The content of the node
	 */
	public BinTree(Object content) {
		this.content = content;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BinTree) {
			BinTree other = (BinTree) obj;
			return other.getContent().equals(this.getContent());
		}
		return false;
	}
	
	/**
	 * Finds the BinTree node containg a given content
	 * @param subject The given content
	 * @return The BinTree node containg the content
	 */
	public BinTree find(Object subject) {
		if(this.getContent().equals(subject)) {
			return this;
		}
		
		if(leftChild != null && leftChild.contains(subject)) {
			return leftChild.find(subject);
		}
		if(rightChild != null && rightChild.contains(subject)) {
			return rightChild.find(subject);
		}
		
		return null;
	}
	
	/**
	 * Checks whether a BinTree or one of its childs contains a given object
	 * @param subject The given object
	 * @return true, if at least one of this tree's children contains <i>subject</i>; false otherwise
	 */
	private boolean contains(Object subject) {
		if(getContent().equals(subject)) {
			return true;
		}
		if(getLeftChild() == null && getRightChild() == null) {
			return false;
		}
		
		if(getLeftChild() != null && getRightChild() == null) {
			return getLeftChild().contains(subject);
		}
		if(getRightChild() != null && getLeftChild() == null) {
			return getRightChild().contains(subject);
		}
		
		return getLeftChild().contains(subject) || getRightChild().contains(subject);
	}
	
	public BinTree getPredecessor() {
		return predecessor;
	}
	
	public PathName getPredecessorPathName() {
		return predecessorPathName;
	}

	public void setPredecessor(BinTree predecessor, PathName pathName) {
		this.predecessor = predecessor;
		this.predecessorPathName = pathName;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public BinTree getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinTree leftChild) {
		this.leftChild = leftChild;
		this.leftChild.setPredecessor(this, PathName.LEFT);
	}

	public BinTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinTree rightChild) {
		this.rightChild = rightChild;
		this.rightChild.setPredecessor(this, PathName.RIGHT);
	}
	
}
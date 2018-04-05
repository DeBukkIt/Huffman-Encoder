package com.blogspot.debukkitsblog.huffman;

/**
 * A binary tree implementation to be used for a Huffman encoding tree
 * @author DeBukkIt
 */
public class BinTree {

	private Object content;
	private BinTree leftChild;
	private BinTree rightChild;
	
	/**
	 * Constructs a new binary tree node
	 * @param content The content of the node
	 */
	public BinTree(Object content) {
		this.content = content;
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
	 * Finds the BinTree node containg a given content, returning the path on the way to that node
	 * @param subject The given content
	 * @return The path to that node as a String, by default consisting of 0 and 1 digits 
	 */
	public String findPath(Object subject) {
		if(this.getContent().equals(subject)) {
			return "";
		}
		
		if(leftChild != null && leftChild.contains(subject)) {
			return PathName.LEFT.getRepresentingDigit() + leftChild.findPath(subject);
		}
		if(rightChild != null && rightChild.contains(subject)) {
			return PathName.RIGHT.getRepresentingDigit() + rightChild.findPath(subject);
		}
		
		return "";
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
	}

	public BinTree getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinTree rightChild) {
		this.rightChild = rightChild;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BinTree) {
			BinTree other = (BinTree) obj;
			return other.getContent().equals(this.getContent());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return "[" + content + "; hasLeft: " + (getLeftChild() != null) + "; hasRight: " + (getRightChild() != null) + "]";
	}
	
}
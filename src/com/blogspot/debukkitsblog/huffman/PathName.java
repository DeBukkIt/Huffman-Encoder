package com.blogspot.debukkitsblog.huffman;
/**
 * The names of the left or right paths in a binary tree containing a representing digit; default is LEFT: 0, RIGHT: 1
 * @author DeBukkIt
 */
public enum PathName {
	
	LEFT("0"), RIGHT("1");

	private String content;
	
	PathName(String content) {
		this.content = content;
	}
	
	public String getRepresentingDigit() {
		return content;
	}
	
}

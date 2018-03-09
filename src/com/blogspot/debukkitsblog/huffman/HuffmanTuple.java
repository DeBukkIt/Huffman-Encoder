package com.blogspot.debukkitsblog.huffman;
/**
 * A Huffman tuple consisting of a character and its frequency
 * @author DeBukkIt
 */
public class HuffmanTuple {
	
	private int frequency;
	private Character character;
	
	/**
	 * Constructs a new HuffmanTuple consisting of a character and its frequency
	 * @param frequency The frequency
	 * @param character The caracter
	 */
	public HuffmanTuple(Character character, int frequency) {
		this.frequency = frequency;
		this.character = character;
	}
	
	public boolean hasCharacter() {
		return character != null;
	}
	
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	public Character getCharacter() {
		return character;
	}
	public void setCharacter(Character character) {
		this.character = character;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof HuffmanTuple) {
			HuffmanTuple other = (HuffmanTuple) obj;
			return other.getCharacter() != null && this.getCharacter() != null && other.getCharacter().equals(this.getCharacter());
		} else {
			return false;
		}
	}
	
	@Override
	public String toString() {
		return "[" + character + " (" + frequency + ")]";
	}
}
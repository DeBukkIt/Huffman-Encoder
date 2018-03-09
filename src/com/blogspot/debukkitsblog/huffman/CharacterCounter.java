package com.blogspot.debukkitsblog.huffman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Counts the frequency of each character in a given String
 * @author DeBukkIt
 */
public class CharacterCounter {

	/**
	 * Counts the frequency of each character in a given String
	 * @param input The given String
	 * @return An array of HuffmanTuple (which contains the character and its absolute frequency)
	 */
	public static HuffmanTuple[] countCharacters(String input) {
		
		HashMap<Character, Integer> tupleMap = new HashMap<>();
		Set<Character> characters = new HashSet<>();
		
		// find unique characters
		for(int i = 0; i < input.length(); i++) {
			characters.add(input.charAt(i));
		}
		
		// for every unique character...
		for (Character c : characters) {
			// find all equivalent characters in the input String
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == c) {
					// and save it to the map
					if(!tupleMap.containsKey(c)) {
						tupleMap.put(c, 1);
					} else {
						// or increment the frequency already stored in the map
						tupleMap.put(c, tupleMap.get(c)+1);
					}
				}
			}
		}
		
		HuffmanTuple[] result = new HuffmanTuple[tupleMap.size()];
		
		// generate HuffmanTuples and return the result array
		for(int i = 0; i < result.length; i++) {
			Character key = (Character) tupleMap.keySet().toArray()[i];
			result[i] = new HuffmanTuple(key, tupleMap.get(key));
		}
		
		return result;
	}

}
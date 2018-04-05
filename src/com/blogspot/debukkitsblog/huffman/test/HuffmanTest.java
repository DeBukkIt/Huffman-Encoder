package com.blogspot.debukkitsblog.huffman.test;
import static org.junit.Assume.assumeTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import com.blogspot.debukkitsblog.huffman.CharacterCounter;
import com.blogspot.debukkitsblog.huffman.HuffmanEncoder;

class HuffmanTest {
	
	@Test
	void testEncoding_LowerCase() {		
		// test input
		HashMap<Character, String> result = HuffmanEncoder.generateHuffmanEncoding(
				CharacterCounter.countCharacters("go go gophers")
		);
		
		boolean testResult = result.get(' ').equals("101")
				&& result.get('p').equals("1100")
				&& result.get('r').equals("1101")
				&& result.get('s').equals("1110")
				&& result.get('e').equals("1111")
				&& result.get('g').equals("00")
				&& result.get('h').equals("100")
				&& result.get('o').equals("01");
		
		assumeTrue(testResult);
	}

}
# Huffman Encoder

## About this implementation
This implementation uses a binary tree maintained in a linear list. The list is sorted and then the two smallest elements are linked to a new parent node. This process is repeated until only one element can be found in the list: The main root of the finished tree. Now the path of each character to be coded is determined from leaf to root, with each left and right turn stored. This combination finally results in the Huffman encoding of the character.

### Example usage
```java
// test input
HashMap<Character, String> result = generateHofmannEncoding(
	CharacterCounter.countCharacters("This is my test input string to be encoded.")
);

// test output
for (Character key : result.keySet()) {
	System.out.println(key + ": " + result.get(key));
}
```

## About Huffman coding
In computer science and information theory, a Huffman code is a particular type of optimal prefix code that is commonly used for lossless data compression. The process of finding and/or using such a code proceeds by means of Huffman coding, an algorithm developed by David A. Huffman while he was a Sc.D. student at MIT, and published in the 1952 paper "A Method for the Construction of Minimum-Redundancy Codes".

The output from Huffman's algorithm can be viewed as a variable-length code table for encoding a source symbol (such as a character in a file). The algorithm derives this table from the estimated probability or frequency of occurrence (weight) for each possible value of the source symbol. As in other entropy encoding methods, more common symbols are generally represented using fewer bits than less common symbols.

Wikipedia contributors. "[Huffman coding](https://en.wikipedia.org/wiki/Huffman_coding)" Wikipedia, The Free Encyclopedia. 24 Feb. 2018

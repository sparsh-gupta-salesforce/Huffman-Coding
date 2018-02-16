package huffmanCoding;

import java.util.Comparator;

public class huffman{

	int data;
	char c;
	huffman left;
	huffman right;
	huffman(char ch,int da){
		c=ch;
		data=da;
		left=right=null;
	}
}

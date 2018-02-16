package huffmanCoding;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

class newComparator implements Comparator<huffman>{

	public int compare(huffman arg0, huffman arg1) {
		
		return arg0.data - arg1.data;
	}
	 
}

public class huffimp {

	static HashMap<Character,String> map1 = new HashMap<>();
	
	public static void print(huffman h,String output) {
		if(h.left==null && h.right==null) {
			
			map1.put(h.c,output);
			return;
		}
		
		print(h.left,output+""+0);
		print(h.right,output+""+1);
		
	}
	public static void main(String[] args) throws IOException {
		
		
		Scanner in = new Scanner(new FileReader("/home/priyanshi/Desktop/abc"));
		StringBuilder sb = new StringBuilder();
		while(in.hasNext()) {
		    sb.append(in.next());
		}
		in.close();
		String str = sb.toString();
		
		HashMap<Character,Integer> map = new HashMap<>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i)))
				map.put(str.charAt(i), map.get(str.charAt(i))+1);
			else
				map.put(str.charAt(i), 1);
		}
		PriorityQueue<huffman> p = new PriorityQueue<>(40,new newComparator());
		huffman k = new huffman('-',98);
		for(char i:map.keySet()) {
			huffman f = new huffman(i,map.get(i));
			p.add(f);
		}
		while(p.size()!=1) {
			
			huffman f = p.poll();
			huffman g = p.poll();
			huffman result = new huffman('-',f.data+g.data);
			result.left = f;
			result.right = g;
			p.add(result);
		}
		
		
		print(p.poll(),"");
		System.out.println(map1);
	}
	
	
	
}

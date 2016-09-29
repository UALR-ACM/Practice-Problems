import java.util.HashMap;
import java.util.Scanner;

public class anewalphabet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, String> hm = new HashMap<Character, String>();
		hm.put('a', "@");
		hm.put('b', "8");
		hm.put('c', "(");
		hm.put('d', "|)");
		hm.put('e', "3");
		hm.put('f', "#");
		hm.put('g', "6");
		hm.put('h', "[-]");
		hm.put('i', "|");
		hm.put('j', "_|");
		hm.put('k', "|<");
		hm.put('l', "1");
		hm.put('m', "[]\\/[]");
		hm.put('n', "[]\\[]");
		hm.put('o', "0");
		hm.put('p', "|D");
		hm.put('q', "(,)");
		hm.put('r', "|Z");
		hm.put('s', "$");
		hm.put('t', "']['");
		hm.put('u', "|_|");
		hm.put('v', "\\/");
		hm.put('w', "\\/\\/");
		hm.put('x', "}{");
		hm.put('y', "`/");
		hm.put('z', "2");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		String out = "";
		for (char c : line.toLowerCase().toCharArray()) {
			if (c >= 'a' && c <= 'z')
				out += hm.get(c);
			else
				out += c;
		}
		System.out.println(out);

	}

}

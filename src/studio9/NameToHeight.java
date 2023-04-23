package studio9;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class NameToHeight {
	/**
	 * Construct and fill a map with your studio group members' names, each
	 * associated with his or her height.
	 * 
	 * Construct an ArgsProcessor and loop asking the args processor for a name to
	 * lookup the height. When the user cancels (that is: when args processor
	 * returns null), break from the loop. Otherwise, loop up the name in the map
	 * and output the results. Be sure to handle the case where the map does not
	 * contain a specified name.
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input a name:");
		String name = in.next();
		Map<String, Integer> height = new HashMap<>();
		height.put("Annie", 62);
		height.put("Andy", 69);
		height.put("Sebastian", 68);
		while (!name.equals("quit")) {
			if (height.get(name) == null) {
				System.out.println("Input a name in the Map!");
				name = in.next();
			} else {
				System.out.println(name + " is " + height.get(name) + " inches tall.");
				System.out.println("Input a name:");
				name = in.next();
			}
		}
	}
}


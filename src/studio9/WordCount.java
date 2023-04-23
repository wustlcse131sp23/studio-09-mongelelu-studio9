package studio9;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import support.cse131.NotYetImplementedException;

public class WordCount {
	/**
	 * Constructs and returns a map of the distinct words in the specified list with
	 * each word associated with its accumulated count (that is: the number of
	 * occurrences of the word in the list).
	 * 
	 * For example, if passed a List<String> containing:
	 * 
	 * [to, be, or, not, to, be]
	 * 
	 * the resulting Map<String, Integer> would contain
	 * 
	 * key="to", value=2; key="be", value=2; key="or", value=1; key="not", value=1;
	 * 
	 * @param words
	 * @return a map which contains all of the distinct words as keys, each
	 *         associated with the number of occurrences of the word
	 */
	public static Map<String, Integer> countWords(List<String> words) {
		Map<String, Integer> wordCount = new HashMap<>();
		for (String word : words) {
			Integer count = wordCount.get(word);
			if (count == null) {//new word
				wordCount.put(word, 1);
			} else {//update the word count
				wordCount.put(word, count + 1);
			}
		}
		return wordCount;
	}
}



/*
 * body of the enhanced for loop
 * if (wordCount.get(word) != null) {
				wordCount.replace(word, wordCount.get(word), wordCount.get(word) + 1);
			} else {
				wordCount.put(word, 1);
			}
		}
		return wordCount;
	}*/

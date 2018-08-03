package L21_July30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Garima Chhikara
 * @email garima.chhikara@codingblocks.com
 * @date 30-Jul-2018
 */

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put -> O(1)
		map.put("India", 10);
		map.put("SL", 20);
		map.put("Aus", 30);

		System.out.println(map);

		map.put("India", 5);
		System.out.println(map);

		// get -> O(1)
		System.out.println(map.get("India"));
		System.out.println(map.get("US"));

		// containskey -> O(1)
		System.out.println(map.containsKey("India"));
		System.out.println(map.containsKey("US"));

		// remove -> O(1)
		System.out.println(map.remove("India"));
		System.out.println(map.remove("US"));

		System.out.println(map);

		// keyset -> O(n)
		ArrayList<String> keys = new ArrayList<>(map.keySet());

		System.out.println(keys);

		for (String key : keys) {
			System.out.println(key);
		}

		Set<String> set = map.keySet();

		System.out.println(maxFrequencyChar("aaaaaaaaaabbbbbbddhjsdghj"));

		int[] a1 = { 10, 10, 10, 20, 20, 20, 30, 40 };
		int[] a2 = { 100, 200, 10, 10, 20, 50, 20 };

		System.out.println(intersection(a1, a2));
		
		int[] arr = {2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6} ;
		
		System.out.println(longestSequence(arr));
	}

	public static char maxFrequencyChar(String str) {

		HashMap<Character, Integer> fmap = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			// char is already present, update the freq and put in hashmap
			if (fmap.containsKey(ch)) {

				int of = fmap.get(ch);
				int nf = of + 1;
				fmap.put(ch, nf);
			} else {
				// char is coming for the first time
				fmap.put(ch, 1);
			}
		}

		int maxfreq = 0;
		char maxfreqchar = ' ';

		for (Character key : fmap.keySet()) {

			int val = fmap.get(key);

			if (val > maxfreq) {
				maxfreq = val;
				maxfreqchar = key;
			}

		}

		return maxfreqchar;

	}

	public static ArrayList<Integer> intersection(int[] a1, int[] a2) {

		ArrayList<Integer> ans = new ArrayList<>();

		HashMap<Integer, Integer> fmap = new HashMap<>();

		// 1. create the fmap for 1st array
		for (int i = 0; i < a1.length; i++) {

			int val = a1[i];

			if (fmap.containsKey(val)) {
				int of = fmap.get(val);
				int nf = of + 1;
				fmap.put(val, nf);
			} else {
				fmap.put(val, 1);
			}
		}

		// 2. 2nd array
		for (int i = 0; i < a2.length; i++) {

			if (fmap.containsKey(a2[i]) && fmap.get(a2[i]) > 0) {

				ans.add(a2[i]);

				int of = fmap.get(a2[i]);
				int nf = of - 1;
				fmap.put(a2[i], nf);

			}

		}

		return ans;
	}

	public static ArrayList<Integer> longestSequence(int[] arr) {

		ArrayList<Integer> ans = new ArrayList<>();

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];

			int nm1 = val - 1;

			if (map.containsKey(nm1)) {
				map.put(val, false);
			} else {
				map.put(val, true);
			}

			int np1 = val + 1;
			if (map.containsKey(np1)) {
				map.put(np1, false);
			}
		}

		int maxlength = 0;
		int sequenceStarting = 0;

		for (Integer key : map.keySet()) {

			if (map.get(key) == true) {

				int count = 0;
				while (map.containsKey(key + count)) {
					count++;
				}

				if (count > maxlength) {
					maxlength = count;
					sequenceStarting = key;
				}

			}

		}

		for (int i = 0; i < maxlength; i++) {
			ans.add(sequenceStarting + i);
		}

		return ans;

	}

}

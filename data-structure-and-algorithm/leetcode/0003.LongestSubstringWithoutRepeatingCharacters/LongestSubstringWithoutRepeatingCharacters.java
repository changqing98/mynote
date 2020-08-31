import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		char[] array = s.toCharArray();
		Set<Character> set = new HashSet<>();
		int length = array.length;
		int max = 0;
		int cur = -1;
		int i;
		for (i = 0; i < length; i++) {
			if (i != 0) {
				set.remove(array[i - 1]);
			}
			while (cur + 1 < length){
				if(!set.add(array[cur + 1])){
					break;
				}
				cur++;
			}
			max = Math.max(max, cur - i + 1);
		}
		return max;
	}

	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
		String case1= "a";
		int result1 = test.lengthOfLongestSubstring(case1);
		System.out.println("1: " + result1);

		String case2= "asdfga";
		int result2 = test.lengthOfLongestSubstring(case2);
		System.out.println("5: " + result2);

		String case3= "aa";
		int result3 = test.lengthOfLongestSubstring(case3);
		System.out.println("1: " + result3);
	}
}

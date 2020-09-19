public class SubsequenceCheck{

	public boolean isSubsequence(String s, String t) {
		int sLen = s.length();
		int tlen = t.length();
		int i = 0;
		int j = 0;
		while(i < sLen && j < tlen){
			if(s.charAt(i) == t.charAt(j)){
				i++;
			}
			j++;
		}
		if(i == sLen){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		SubsequenceCheck test = new SubsequenceCheck();
		boolean result = test.isSubsequence("abc", "ahbgdc");
		System.out.println(result);
		result = test.isSubsequence("axc", "ahbgdc");
		System.out.println(result);
	}
}

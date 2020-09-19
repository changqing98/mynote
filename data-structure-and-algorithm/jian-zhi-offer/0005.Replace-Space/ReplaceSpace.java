public class Main05 {
	static String replaceSpace(StringBuffer str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				str.replace(i, i + 1, "%20");
			}
		}
		return new String(str);
	}

	public static void main(String[] args) {
		System.out.println(replaceSpace(new StringBuffer("Hello World")));
	}
}

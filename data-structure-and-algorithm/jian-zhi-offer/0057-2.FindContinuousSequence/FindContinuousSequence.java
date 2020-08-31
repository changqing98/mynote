import java.util.ArrayList;

public class FindContinuousSequence {

	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		int l = 1;
		int r = 2;
		while (r > l) {
			int cur = (l + r) * (r - l + 1) / 2;
			if (sum == cur) {
				ArrayList<Integer> item = new ArrayList<>();
				for (int i = l; i <= r; i++) {
					item.add(i);
				}
				result.add(item);
				l++;
			} else if (cur < sum) {
				r++;
			} else {
				l++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new FindContinuousSequence().FindContinuousSequence(15));
	}
}

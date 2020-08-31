import java.util.ArrayList;

public class GetLeastNumbers {

	public static void main(String[] args) {
		GetLeastNumbers test = new GetLeastNumbers();
		System.out.println(test.GetLeastNumbers_Solution(new int[]{1, 2, 3, 6, 7, 9, 2, 4, 6}, 4));
	}

	private int partition(int[] array, int start, int end) {
		int p = array[start];
		while (start < end) {
			while (start < end && array[end] > p) {
				end--;
			}
			array[start++] = array[end];
			while (start < end && array[start] < p) {
				start++;
			}
			array[end--] = array[start];
		}
		array[start] = p;
		return start;
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input == null) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList<>();
		if (k >= input.length) {
			for (int i = 0; i < input.length; i++) {
				list.add(i);
			}
			return list;
		}
		int start = 0;
		int end = input.length - 1;
		int index = partition(input, start, end);
		while (index != k - 1) {
			if (index < k) {
				start = index + 1;
			} else {
				end = index - 1;
			}
			index = partition(input, start, end);
		}
		for (int i = 0; i < k; i++) {
			list.add(input[i]);
		}
		return list;
	}
}

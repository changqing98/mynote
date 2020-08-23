import java.util.ArrayList;
import java.util.Arrays;

public class Main0029PriorityQueue {

	public void adjustHeap(int[] array, int i, int len) {
		int tem = array[i];
		for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
			if (k + 1 < len && array[k + 1] > array[k]) {
				k++;
			}
			if (array[k] > tem) {
				array[i] = array[k];
				i = k;
			}
		}
		array[i] = tem;
	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> result = new ArrayList<>();
		if (k == 0 || k>input.length) {
			return new ArrayList<Integer>();
		}
		if (k == input.length) {
			for (int i = 0; i < input.length; i++) {
				result.add(input[i]);
			}
			return result;
		}
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjustHeap(input, i, k);
		}
		for (int i = k; i < input.length; i++) {
			if (input[i] < input[0]) {
				input[0] = input[i];
				adjustHeap(input, 0, k);
			}
		}
		for (int i = 0; i < k; i++) {
			result.add(input[i]);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Main0029PriorityQueue().GetLeastNumbers_Solution(new int[] { 1, 6, 9, 4, 5, 2, 8 }, 111));
	}
}

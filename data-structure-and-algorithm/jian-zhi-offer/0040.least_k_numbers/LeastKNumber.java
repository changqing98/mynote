import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class LeastKNumber {
	/**
	 * 基于Java的优先队列实现
	 * <p>
	 * 小定堆的思想
	 */
	public int[] getLeastNumbers(int[] arr, int k) {
		Queue<Integer> queue = new PriorityQueue<>(k);
		for (int j : arr) {
			queue.offer(j);
		}
		int[] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = queue.poll();
		}
		return result;
	}

	public static void main(String[] args) {
		LeastKNumber test = new LeastKNumber();
		var case1_arr = new int[]{1, 3, 4, 5, 6, 6};
		var case1_k = 3;
		var result1 = test.getLeastNumbers(case1_arr, case1_k);
		System.out.print(Arrays.toString(result1));
	}
}

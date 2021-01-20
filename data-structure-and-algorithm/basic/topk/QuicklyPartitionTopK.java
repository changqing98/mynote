import java.util.Arrays;

public class QuicklyPartitionTopK {
	public int[] listTopK(int[] array, int k) {
		listTopK(array, 0, array.length - 1, k);
		return Arrays.copyOf(array, k);
	}

	public void listTopK(int[] array, int i, int j, int k) {
		if (i < j) {
			int m = partition(array, i, j);
			if (k == m) {
				return;
			}
			if (k < m) {
				listTopK(array, i, m - 1, k);
			} else {
				listTopK(array, m + 1, j, k);
			}
		}
	}

	private int partition(int[] array, int i, int j) {
		int tmp = array[i];
		while (i < j) {
			while (i < j && array[j] > tmp) {
				j--;
			}
			array[i] = array[j];
			while (i < j && array[i] <= tmp) {
				i++;
			}
			array[j] = array[i];
		}
		array[i] = tmp;
		return i;
	}
}

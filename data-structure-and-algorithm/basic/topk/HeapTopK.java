public class HeapTopK {
	public int[] listTopK(int[] array, int k) {
		if (array.length <= k) {
			return array;
		}
		int[] result = new int[k];
		if (k >= 0) System.arraycopy(array, 0, result, 0, k);
		for (int i = k / 2 - 1; i >= 0; i--) {
			adjust(result, i);
		}
		for (int i = k; i < array.length; i++) {
			if (array[i] < result[0]) {
				result[0] = array[i];
				adjust(result, 0);
			}
		}
		return result;
	}

	private void adjust(int[] array, int k) {
		int tmp = array[k];
		for (int i = 2 * k + 1; i < array.length; i = 2 * i + 1) {
			if (i + 1 < array.length && array[i + 1] > array[i]) {
				i = i + 1;
			}
			if (array[i] > tmp) {
				array[k] = array[i];
				k = i;
			} else {
				break;
			}
		}
		array[k] = tmp;
	}
}

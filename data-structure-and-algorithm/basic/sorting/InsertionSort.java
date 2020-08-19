public class InsertionSort {

	public static void swap(int[] array, int x, int y) {
		int tem = array[x];
		array[x] = array[y];
		array[y] = tem;
	}

	public static void insertionSort(int[] array) {
		int n = array.length;
		for (int i = 1; i < n; i++) {
			int j;
			for (j = i; j > 0 && array[i] < array[j - 1]; j--) {
				array[j] = array[j-1];
			}
			array[j] = array[i];
		}
	}

	public static void main(String[] args) {
		int[] array = new int[]{1, 4, 7, 2, 5, 9, 0, 2, 6};
		sort(array);
		for (int i : array) {
			System.out.println(i + " ");
		}
	}
}

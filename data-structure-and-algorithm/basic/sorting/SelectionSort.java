public class SelectionSort {
	public static void swap(int[] array, int x, int y) {
		int tem = array[x];
		array[x] = array[y];
		array[y] = tem;
	}

	public static void sort(int[] array) {
		int n = array.length;
		for (int i = 0; i < array.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j <= array.length - 1; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			swap(array, i, min);
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

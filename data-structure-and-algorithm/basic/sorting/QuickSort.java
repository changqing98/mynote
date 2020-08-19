public class Quick {

	public static void sort(int[] array) {
		sort(array, 0, array.length - 1);
	}

	public static void sort(int[] array, int start, int end) {
		if (start < end) {
			int p = partition(array, start, end);
			sort(array, start, p - 1);
			sort(array, p + 1, end);
		}
	}

	public static int partition(int[] array, int start, int end) {
		int tem = array[start];
		while (start < end) {
			while (start < end && array[end] >= tem) {
				end--;
			}
			array[start] = array[end];
			while (start < end && array[start] < tem) {
				start++;
			}
			array[end] = array[start];
		}
		array[start] = tem;
		return start;
	}
	public static void main(String[] args) {
		int[] array = new int[]{21, 535, 7, 8, 3, 8, 9};
		sort(array);
		for (int i : array) {
			System.out.println(i + " ");
		}
	}
}

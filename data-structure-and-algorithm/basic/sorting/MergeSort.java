public class MergingSort {

	public static void sort(int[] array) {
		int len = array.length;
		int[] tem = new int[len];
		sort(array, 0, len - 1, tem);
	}

	public static void sort(int[] array, int start, int end, int[] tem) {
		if(start < end){
			int mid = (start + end) / 2;
			sort(array, start, mid, tem);
		}
	}

	public static void main(String[] args) {
	}
}

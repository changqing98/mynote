public class QuicklyPartitionTopK {
	public void listTopK(int[] array, int k) {

	}


	public void listTopK(int[] array, int i, int j, int k) {
		int m = partition(array, 0, array.length);
		if(m == k) {
		} else if (k < m){
			listTopK(array, i, m-1, k);
		}else {
			listTopK(array, m + 1, j, k);
		}
	}

	private int partition(int[] array, int i, int j){
		int tmp = array[i];
		while(i < j){
			while(i < j && array[j] > tmp){
				j--;
			}
			array[i] = array[j];
			while(i < j && array[i] < tmp){
				i++;
			}
			array[j] = array[i];
		}
		array[i] = tmp;
		return i;
	}
}

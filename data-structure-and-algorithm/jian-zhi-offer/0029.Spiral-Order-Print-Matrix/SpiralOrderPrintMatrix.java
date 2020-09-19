public class SpiralOrderPrintMatrix {

	public int[] spiralOrder(int[][] matrix) {
		if(matrix.length == 0){
			return new int[0];
		}
		int t = 0;
		int b = matrix.length - 1;
		int l = 0;
		int r = matrix[0].length - 1;
		int x = 0;
		int[] result = new int[matrix.length * matrix[0].length];
		while (true) {
			for (int i = l; i <= r; i++) {
				result[x++] = matrix[t][i];
			}
			if (++t > b) {
				break;
			}
			for (int i = t; i <= b; i++) {
				result[x++] = matrix[i][r];
			}
			if (--r < l) {
				break;
			}
			for (int i = r; i >= l; i--) {
				result[x++] = matrix[b][i];
			}
			if(--b < t){
				break;
			}
			for(int i = b; i >= t; i--){
				result[x++] = matrix[i][l];
			}
			if(++l > r){
				break;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralOrderPrintMatrix test = new SpiralOrderPrintMatrix();
		System.out.println(test.spiralOrder(new int[][]{{1,2,3}, {4,5,6},{7,8,9}}));
	}
}

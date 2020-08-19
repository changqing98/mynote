public class HeapSort {

    public static int[] heapSort(int[] array) {
        int len = array.length;
        // 从最后一个非叶子结点开始调整堆
        // 正序排列（由小到大）构建大顶堆，反之构建小顶堆
        for (int i = len / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, len);
        }
        // 由上面的初始操作构建一个大顶堆
        // 将堆顶的元素(最大的元素)与数据最后一个节点交换，再次调整堆得到得到剩余元素的最大元素，重复执行该操作
        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            adjustHeap(array, 0, i);
        }
        return array;
    }

    public static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    public static void adjustHeap(int[] array, int i, int len) {
        // 保存当前节点
        int tem = array[i];
        // 指针指向左子节点
        // 二叉树的左子节点计算公式
        for (int k = 2 * i + 1; k < len; k = 2 * k + 1) {
            // 比较左子节点与右子节点，将指针指向大的那个
            if (k < len - 1 && array[k + 1] > array[k]) {
                k = k + 1;
            }
            if (array[k] > tem) {
                array[i] = array[k];
                i = k;
            } else {
                break;
            }
        }
        array[i] = tem;
    }

    public static void main(String[] args) {
        int a[] = new int[]{1,5,7,89,4};
        int[] sortedArray = HeapSort.heapSort(a);
        for(int i : sortedArray){
            System.out.println(i);
        }
    }
}

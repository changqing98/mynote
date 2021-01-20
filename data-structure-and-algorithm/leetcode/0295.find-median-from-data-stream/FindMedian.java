import java.util.PriorityQueue;

public class FindMedian{
        int count = 0;
        PriorityQueue<Integer> maxHeap;
        PriorityQueue<Integer> minHeap;
        public MedianFinder() {
            maxHeap = new PriorityQueue<>((x1, x2) -> x2 - x1);
            minHeap = new PriorityQueue<>();
        }
        
        public void addNum(int num) {
            count+=1;
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            if(count % 2 == 1){
                max.add(minHeap.poll());
            }
        }

        public double findMedian() {
            if(count % 2 == 0){
                return  (maxHeap.peek() + minHeap.peek()) / 2.0;
            }else {
                return maxHeap.peek();
            }

        }
}
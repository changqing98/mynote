import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockingQueue {
    private List<Integer> list = new LinkedList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    private int capacity;

    private int size;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public int take() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                notEmpty.await();
            }
            size--;
            var result = list.remove(0);
            notFull.signal();
            return result;
        } finally {
            lock.unlock();
        }
    }

    public void put(int x) throws InterruptedException {
        lock.lock();
        try {
            while (capacity == size) {
                notFull.await();
            }
            size++;
            list.add(x);
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
}
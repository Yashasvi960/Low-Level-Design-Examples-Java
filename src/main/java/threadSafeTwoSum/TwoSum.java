package threadSafeTwoSum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TwoSum {

    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Map<Integer, Integer> map = new ConcurrentHashMap<>();

    public void addSum(int value) {
        lock.writeLock().lock();
        try {
            map.put(value, map.getOrDefault(value, 0)+1);
        } finally {
            lock.writeLock().unlock();
        }
    }

    public boolean find(int target) {
        lock.readLock().lock();
        try{
            for(int num: map.keySet()) {
                int complement = target-num;
                if(complement==num) {
                    if(map.get(num)>=2) return true;
                } else if(map.containsKey(complement)) return true;
            }

            return false;
        } finally {
            lock.readLock().unlock();
        }
    }
}

package threadSafeTwoSum;

public class TestTwoSum {

    public static void main(String[] args) throws InterruptedException {
      TwoSum twoSum = new TwoSum();
      Thread t1 = new Thread(() -> {
          twoSum.addSum(1);
          twoSum.addSum(3);
      });

      Thread t2 = new Thread(() -> {
          System.out.println("Found 4? " + twoSum.find(4));
      });

      t1.start();
      t2.start();
      t1.join();
      t2.join();
    }
}

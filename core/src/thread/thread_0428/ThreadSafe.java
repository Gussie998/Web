package thread.thread_0428;

/**
 * User:DELL
 * Date:2021-05-07
 * Time:11:03
 */


public class ThreadSafe {
    static class Counter {
        // 定义的私有变量
        private int num = 0;
        // 任务执行次数
        private final int maxSize = 100000;

        // num++
        public void incrment() {
            for (int i = 0; i < maxSize; i++) {
                num++;
            }
        }

        // num--
        public void decrment() {
            for (int i = 0; i < maxSize; i++) {
                num--;
            }
        }

        public int getNum() {
            return num;
        }
    }

    /**
     * 线程安全
     */
//    public static void main(String[] args) {
//        Counter counter = new Counter();
//        counter.incrment();
//        counter.decrment();
//        System.out.println("最终的执行结果：" + counter.getNum());//结果为0
//
//    }
    /**
     * 线程不安全
     */
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            counter.incrment();
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            counter.decrment();
        });
        t2.start();

        t1.join();
        t2.join();

        System.out.println("最终的执行结果：" + counter.getNum());//结果不确定

    }

}

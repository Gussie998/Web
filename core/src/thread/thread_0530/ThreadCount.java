package thread.thread_0530;

import java.util.concurrent.CountDownLatch;

/**
 * User:DELL
 * Date:2021-05-30
 * Time:9:44
 */
public class ThreadCount {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch =  new CountDownLatch(5);

        for (int i = 1; i < 10; i++) {
            final int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"选手起跑");
                    try {
                        Thread.sleep(finalI*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+"选手到达终点");
                    countDownLatch.countDown();
                }
            }).start();

        }
        countDownLatch.await();
        System.out.println("所有选手都到达");


    }
}

package thread.thread_0530;

/**
 * User:DELL
 * Date:2021-05-30
 * Time:10:03
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 循环栅栏
 */
public class ThreadCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("got it");
            }
        });

        for (int i = 1; i <11 ; i++) {
            int finalI = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始跑步");
                    try {
                        Thread.sleep(finalI*100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    try {
                        System.out.println(Thread.currentThread().getName()+"等待其他选手-----");
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }


                }
            }).start();
        }
        System.out.println("完毕");

    }
}

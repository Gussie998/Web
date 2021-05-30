package thread.thread_0530;

/**
 * User:DELL
 * Date:2021-05-30
 * Time:9:22
 */

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 信号量演示程序
 */

public class ThreadLock {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);//秒杀系统，停车管理

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));
        for (int i = 0; i < 4; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("[ "+Thread.currentThread().getName()+" ]arrive here");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //试图进入停车场
                    try {
                        semaphore.acquire();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //获取到锁,车辆停留时间构建
                    System.out.println("-----------------------");
                    System.out.println("[ "+Thread.currentThread().getName()+" ]arrive park");
                    int num = 1+new Random().nextInt(5);
                    try {
                        Thread.sleep(num*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                    //离开
                    System.out.println("++++++++++++++++++++++");
                    System.out.println("[ "+Thread.currentThread().getName()+" ]leave park");

                    semaphore.release();

                }
            });
        }
    }
}

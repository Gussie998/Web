package thread.thread_0425;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:20:25
 */
public class ThreadSleep {
    public static void main1(String[] args) throws InterruptedException {
        System.out.println("开始时间："+new Date());
        //实际上是 > 1s
        Thread.sleep(1000);
        //2.方式2
        TimeUnit.SECONDS.sleep(1);
        //方式3
        Thread.sleep(TimeUnit.SECONDS.toMillis(1));

        System.out.println("结束时间："+new Date());
    }

    public static void main2(String[] args) throws InterruptedException {
        String c1="ABCD";

        Thread thread = new Thread(()->{
            for (char item :c1.toCharArray()
                 ) {
                System.out.println(item);
                System.out.println("name:"+ Thread.currentThread().getName());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.start();
        for (char item :c1.toCharArray()
             ) {
            System.out.println(item);
            System.out.println("name:"+ Thread.currentThread().getName());
            Thread.sleep(100);

        }

    }
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i <10 ; i++) {
            Thread t1 = new Thread(()->{
                System.out.print("A");
            });
            Thread t2 = new Thread(()->{
                System.out.print("B");
            });Thread t3 = new Thread(()->{
                System.out.print("C\n");
            });
            t1.start();
            Thread.sleep(100);
            t2.start();
            Thread.sleep(100);
            t3.start();
            Thread.sleep(100);
        }
    }
}

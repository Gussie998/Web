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

    public static void main(String[] args) throws InterruptedException {
        String c1="ABCD";
        //String c2="ABCD";

        Thread thread = new Thread(()->{
            for (char item :c1.toCharArray()
                 ) {
                System.out.print(item);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        for (char item :c1.toCharArray()
             ) {
            System.out.print(item);
            Thread.sleep(1000);

        }

    }
}

package thread.thread_0527;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * User:DELL
 * Date:2021-05-27
 * Time:19:49
 */

/**
 * 增加版本号，每次修改之后更新版本号
 *
 */
public class ThreadABASolution {
    private static AtomicStampedReference money = new AtomicStampedReference(100,1);
//    private static AtomicReference money = new AtomicReference(100);

    public static void main(String[] args) throws InterruptedException {


        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(100,0,1,2);
                System.out.println("-100-->"+res);
            }
        });
        t1.start();
        t1.join();


        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(0,100,2,3);
                System.out.println("+100-->"+res);

            }
        });
        t3.start();
        t3.join();

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(100,0,1,2);
                System.out.println("-100-->"+res);

            }
        });
        t2.start();


        //解决ABA问题
        //-100-->true
        //+100-->true
        //-100-->false

    }
}

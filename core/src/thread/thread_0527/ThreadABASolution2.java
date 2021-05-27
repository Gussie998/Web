package thread.thread_0527;

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
public class ThreadABASolution2 {
    private static AtomicStampedReference money = new AtomicStampedReference(1000,1);
//    private static AtomicReference money = new AtomicReference(10000);

    public static void main(String[] args) throws InterruptedException {


        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(1000,0,1,2);
                System.out.println("-1000-->"+res);
            }
        });
        t1.start();
        t1.join();


        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(0,1000,2,3);
                System.out.println("+1000-->"+res);

            }
        });
        t3.start();
        t3.join();

        Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                Boolean res=money.compareAndSet(1000,0,1,2);
                System.out.println("-1000-->"+res);

            }
        });
        t2.start();


        //-1000-->false
        //+1000-->false
        //-1000-->false
        //Integer高速缓存，-128~127 大于这个范围后会重新new对象


//        设置应用程序的参数，调整高速缓存的边界值：-Djava.lang.Integer.IntegerCache.high=1000
//        而后结果为
//        -1000-->true
//        +1000-->true
//        -1000-->false

    }
}

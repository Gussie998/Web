package thread.thread_0527;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:17:07
 */
//什么情况下会发生OOM？

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 什么是OOM？
 *
 * 当一个线程执行完毕之后 不会释放这个线程所占用的内存 或者是内存释放不及时的情况
 * 1.打开数据库连接但未关闭
 * 2.ThreadLocal
 */


//       设置 VM参数 -Xmx5m
public class ThreadLocalOOM {
    static ThreadLocal<MyBigClass> threadLocal = new ThreadLocal<>();
    static class MyBigClass{
        private byte[] bytes = new byte[1*1024*1024];
    }


    public static void main(String[] args) {
        //ThreadLocal+ThreadPool-->长生命周期，会导致OOM
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(1,1,0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000));
        for (int i = 0; i < 15; i++) {
            int finalI=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("%s"+finalI+"执行");
                    MyBigClass myBigClass = new MyBigClass();
                    threadLocal.set(myBigClass);
                    myBigClass=null;
                }

            });
        }

    }
}

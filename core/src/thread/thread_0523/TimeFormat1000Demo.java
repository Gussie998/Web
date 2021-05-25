package thread.thread_0523;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:15:30
 */
public class TimeFormat1000Demo {
    static ThreadLocal<SimpleDateFormat> threadLocal=
//            ThreadLocal.withInitial(()->
//                    new SimpleDateFormat("mm-ss"));
            ThreadLocal.withInitial(new Supplier<SimpleDateFormat>() {
                @Override
                public SimpleDateFormat get() {
                    System.out.println("------------------执行初始化方法------------------");
                    return new SimpleDateFormat("mm:ss");
                }
            });
    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000)
                );
        for (int i = 1; i <1001 ; i++) {
            int finalI=i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    Date date  = new Date(finalI*1000);
                    myFormat(date);
                }
            });
        }

    }

    private static void myFormat(Date date) {
        String result = threadLocal.get().format(date);
        System.out.println(result);
    }

}

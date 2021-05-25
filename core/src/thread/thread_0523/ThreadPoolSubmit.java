package thread.thread_0523;

import java.util.Random;
import java.util.concurrent.*;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:11:00
 */
public class ThreadPoolSubmit {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(5,5,
                        0, TimeUnit.SECONDS,
                        new LinkedBlockingQueue<>(1000)
                );
        Future<Integer> future=executor.submit(new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                int num=new Random().nextInt(10);
                System.out.println("线程池生成了随机数："+num);
                return num;
            }
        });
        System.out.println("Main得到返回值："+future.get());


    }
}

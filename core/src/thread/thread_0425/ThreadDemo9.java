package thread.thread_0425;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:54
 */
public class ThreadDemo9 {
    //创建并得到线程的执行结果、
    //Callable+Future
    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            //生成随机数
            int  num = new Random().nextInt(10);
            System.out.println("子线程："+Thread.currentThread().getName()+ ",随机数："+num);
            return num;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        //创建一个FutureTask 来接受返回值
        FutureTask<Integer> futureTask = new FutureTask<>(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();

        int res = futureTask.get();
        System.out.println(String.format("线程名：%s,随机数字：%d",Thread.currentThread().getName(),res));

    }
}

package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:49
 */
public class ThreadDemo8 {
    public static void main(String[] args) {
//        5.lamoda表达式+匿名Runnable
        //是主流
        Thread thread = new Thread(()->{
            System.out.println("name:"+ Thread.currentThread().getName());
        });
        thread.start();
    }
}

package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:45
 */
public class ThreadDemo6 {
    //3.接口
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("name:"+ Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();

        Thread thread = new Thread(runnable);

        thread.start();
    }
}

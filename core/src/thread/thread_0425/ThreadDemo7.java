package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:47
 */
public class ThreadDemo7 {
    //4.匿名内部类
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("name:"+ Thread.currentThread().getName());

            }
        });
        thread.start();
    }

}

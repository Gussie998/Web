package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:39
 */
public class ThreadDemo5 {
    //创建线程的方法2：实现Runnable接口的方式
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("name:"+ Thread.currentThread().getName());
            }
        };
        thread.start();
    }
}

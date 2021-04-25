package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:35
 */
public class ThreadDemo4 {
    //继承Thread类的方式的缺点：Java 语言设计当中只能实现单继承，
    //若继承了Thread 那么就不能继承其他类；所以这种方式是不用的，了解就可以了
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("name:"+ Thread.currentThread().getName());

        }
    }

    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
        //默认线程名称
        System.out.println("主线程："+Thread.currentThread().getName());
    }
}

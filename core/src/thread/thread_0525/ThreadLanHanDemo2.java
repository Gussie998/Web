package thread.thread_0525;

/**
 * User:DELL
 * Date:2021-05-25
 * Time:20:30
 */
public class ThreadLanHanDemo2 {
    static class Singleton {
        //1 创建私有的构造函数,为了防止其他类直接创建
        private Singleton() {
        }

        //2 定义一个私有的变量 一定要写volatile
        private static volatile Singleton singleton = null;

        //double check
        public static Singleton getInstance() {
            if (singleton == null) {
                synchronized (Singleton.class) {
                    if (singleton == null) {
                        singleton = new Singleton();
                    }
                }
            }
            return singleton;
        }
    }
    private static Singleton singleton1 = null;
    private static Singleton singleton2 = null;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                singleton1 = Singleton.getInstance();
            }
        });
        t1.start();

        singleton2 = Singleton.getInstance();
        t1.join();

        System.out.println();
    }
}

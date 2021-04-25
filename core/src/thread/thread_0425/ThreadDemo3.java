package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:19:10
 */
public class ThreadDemo3 {
    public static final Long count = 5_0000_0000L;

    public static void main(String[] args) throws InterruptedException {

        //System.out.println(Thread.currentThread().getName());

        concorrency();

        //调用单线程的方法
        serial();
    }

    private static void serial() {
        Long stime = System.currentTimeMillis();
        //System.nanoTime();
        //nano记录当前时间的纳秒数
        int a = 0;
        for (int i = 0; i <3*count ; i++) {
            a++;
        }
        Long etime = System.currentTimeMillis();
        System.out.println("单线程执行了"+ (etime-stime)+"ms");

    }

    public static void concorrency() throws InterruptedException {
        //使用时间戳记录当前时间
        Long stime = System.currentTimeMillis();

        //执行30亿次循环,创建线程任务
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //启动线程要执行的任务
                //具体的业务
                int a = 0;
                for (int i = 0; i <count ; i++) {
                    a++;
                }

            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int b = 0;
                for (int i = 0; i <count ; i++) {
                    b++;
                }

            }
        });
        t2.start();

        //主线程
        int c = 0;
        for (int i = 0; i <count ; i++) {
            c++;
        }

        //等待线程t1和t2执行完成后统计时间
        t1.join();
        t2.join();

        //结束时间
        Long etime = System.currentTimeMillis();
        System.out.println("多线程执行了"+ (etime-stime)+"ms");

    }

}

package thread.thread_0527;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:16:38
 */

/**
 *
 * 不可继承性
 */

public class ThreadLocalExtend {

//    static ThreadLocal<String> threadLocal = new ThreadLocal<>();//不可继承
static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();//可继承
//InheritableThreadLocal 不能实现不同线程之间的数据共享
    //因为ThreadLocal实现的是线程之间的隔离

    public static void main(String[] args) {
        threadLocal.set("java");

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String result = threadLocal.get();
                System.out.println(result);
            }
        });
        t1.start();

    }
}

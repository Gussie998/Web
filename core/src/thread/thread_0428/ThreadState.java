package thread.thread_0428;

/**
 * User:DELL
 * Date:2021-05-07
 * Time:10:47
 */
public class ThreadState {
    public static void main(String[] args) throws InterruptedException {

        // 打印所有线程
//        for (Thread.State item : Thread.State.values()) {
//            System.out.println(item);
//        }
        /**
         * new新建状态 没有start()
         * runnable(running ready)
         * blocked/waiting没哟明确的等待结束时间
         * timed_waiting有明确的等待结束时间
         * terminated 终止状态
         */

        Object obj = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (obj) {
                    try {
                        // 休眠线程
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        });
        System.out.println("start之前的状态：" + t1.getState());
        t1.start();
        System.out.println("start之后的状态：" + t1.getState());
        Thread.sleep(100);
        System.out.println("t1的状态：" + t1.getState());

        // 等待线程程序完成
        t1.join();
//        while (!t1.isAlive()) {
//        }

        System.out.println("线程执行完成之后的状态：" + t1.getState());

    }
}

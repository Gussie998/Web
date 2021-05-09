package thread.thread_0509;

import java.util.concurrent.locks.LockSupport;

/**
 * User:DELL
 * Date:2021-05-09
 * Time:12:15
 */
public class ThreadPark {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Interrupt State before park："+Thread.interrupted());
                LockSupport.park();
                System.out.println("Interrupt State after park："+Thread.interrupted());
//                Interrupt State before park：false
//                Interrupt State after park：true
//                结果说明是可以感知interrupt
            }
        });
        t1.start();
        Thread.sleep(1000);
        //发送终止线程状态
        t1.interrupt();

        LockSupport.unpark(t1);

    }
}

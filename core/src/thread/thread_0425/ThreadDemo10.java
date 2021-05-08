package thread.thread_0425;

import java.util.Random;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:20:59
 */
public class ThreadDemo10 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"已准备好，开始跑步了！");
                int num = 1+ new Random().nextInt(5);
                try {
                    Thread.sleep(num*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("我到终点了!"+Thread.currentThread().getName());
            }
        };

        //定义分组
        ThreadGroup group = new ThreadGroup("100m");


        //创建运动员
        Thread t1 = new Thread(group,runnable,"gxx");
        Thread t2 = new Thread(group,runnable,"fc");
        t1.start();
        t2.start();

        while (group.activeCount()!=0){
        }
        System.out.println("宣布成绩：");

    }
}

package thread.thread_0425;

/**
 * User:DELL
 * Date:2021-04-25
 * Time:21:08
 */
public class ThreadDemo11 {
    public static void main(String[] args) {
        Thread t1= new Thread(()->{

        },"gxx");
        System.out.println("状态："+t1 .getState());
        t1.start();
        System.out.println(t1.getId());
        System.out.println(t1.getName());
        System.out.println(t1.getPriority());//优先级
        //最小优先级1，最大优先级为10；默认是5，优先级取值越大则权重就越高
        System.out.println(t1.isDaemon());
        System.out.println(t1.isAlive());
        System.out.println(t1.isInterrupted());
    }


}

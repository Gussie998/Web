package thread.thread_0525;

/**
 * User:DELL
 * Date:2021-05-25
 * Time:20:20
 */

/**
 * 饿汉方式
 */
public class ThreadDemo {

    static class Singleton {
        //1 创建私有的构造函数,为了防止其他类直接创建
        private Singleton(){


        }

        //2 定义一个私有的变量
        private static Singleton singleton = new Singleton();

        //3 提供公共的获取实例方法
        public static Singleton getInstance() {
            return singleton;
        }
    }

    public static void main(String[] args) {
        Singleton singleton = new Singleton();
        System.out.println(singleton);
    }

}


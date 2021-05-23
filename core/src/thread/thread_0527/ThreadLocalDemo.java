package thread.thread_0527;

import java.util.function.Supplier;

/**
 * User:DELL
 * Date:2021-05-23
 * Time:14:58
 */
public class ThreadLocalDemo {
    static ThreadLocal<String> threadLocal=
            ThreadLocal.withInitial(new Supplier<String>() {
                @Override
                public String get() {
                    System.out.println("initial function");
                    return "java";
                }
            });

    public static void main(String[] args) {
        try {
            String result = threadLocal.get();
            System.out.println(result);
        } finally {
            threadLocal.remove();
        }
    }
}

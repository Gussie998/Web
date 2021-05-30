package thread.thread_0530;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User:DELL
 * Date:2021-05-30
 * Time:10:52
 */

//project 1.7 model 1.7环境下 HashMap导致死循环
public class ThreadHashMap {
    HashMap hashMap = new HashMap();

    ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

    Hashtable<String,String> hashtable = new Hashtable<>();

}

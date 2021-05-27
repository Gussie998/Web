package thread.thread_0527;

/**
 * User:DELL
 * Date:2021-05-27
 * Time:20:46
 */

import java.util.Date;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁ReentrantReaderWriterLock
 */
public class ThreadRWLock {
    public static void main(String[] args) {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

        //读锁
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        //写锁
        ReentrantReadWriteLock.WriteLock writeLock=readWriteLock.writeLock();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0,
                TimeUnit.SECONDS,new LinkedBlockingQueue<>(1000));

        // work1 :R
        executor.execute(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"执行读锁"+new Date());
                    Thread.sleep(3000);
                }catch (InterruptedException e) {
                        e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }
        });

        // work2 :R
        executor.execute(new Runnable() {
            @Override
            public void run() {
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"执行读锁"+new Date());
                    Thread.sleep(3000);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }
        });

        // work3 :W
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"执行写锁"+new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }
        });
        // work1 :W
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"执行写锁"+new Date());
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }
        });
//结果
//pool-1-thread-2执行读锁Thu May 27 20:58:12 CST 2021
//pool-1-thread-1执行读锁Thu May 27 20:58:12 CST 2021
//pool-1-thread-4执行写锁Thu May 27 20:58:15 CST 2021
//pool-1-thread-3执行写锁Thu May 27 20:58:18 CST 2021
    }

}

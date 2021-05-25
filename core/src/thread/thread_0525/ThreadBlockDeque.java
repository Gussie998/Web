package thread.thread_0525;

import java.util.Random;

/**
 * User:DELL
 * Date:2021-05-25
 * Time:21:11
 */
public class ThreadBlockDeque {
    static class MyBlockingQueue{
        private int[] values;//实际存储数据的数组
        //队首，尾，以及大小
        private int first;
        private int last;
        private int size;

        public MyBlockingQueue(int initial){
            values=new int[initial];
            first=0;
            last=0;
            size=0;
        }

        //添加元素到队尾
        public void offer(int val){
           synchronized (this){
               //判断边界值
               if(size==values.length){//队列已满
                   try {
                       this.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               //添加元素到队尾
               values[last++]=val;
               size++;
               if(last==values.length){
                   last=0;
               }
               //尝试唤醒消费者
               this.notify();
           }
        }


        //查询元素
        public int poll(){
            int result = -1;
            synchronized (this){
                if(size==0){
                //队列为空 阻塞等待

                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //队列不为空，开始取元素
                result = values[first++];
                size--;

                if(first==values.length){
                    first=0;
                }
                this.notify();
            }
            return result;
        }

        public static void main(String[] args) {

            MyBlockingQueue myBlockingQueue = new MyBlockingQueue(100);

            Thread t1= new Thread(new Runnable() {
                @Override
                public void run() {
                    //每隔200ms 生产一条数据
                    while (true){
                        int num =new Random().nextInt(10);
                        System.out.println("random Number:"+num);
                        myBlockingQueue.offer(num);

                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            t1.start();

            Thread t2= new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        int res =myBlockingQueue.poll();
                        System.out.println("消费了数据："+res);
                    }
                }
            });
            t2.start();
        }


    }

}

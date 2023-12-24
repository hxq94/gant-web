package cn.lt.gant.dal.mapper.main.balance;

import java.util.concurrent.atomic.AtomicMarkableReference;

public class ABADemo {
    
    private static AtomicMarkableReference<Integer> atomicMarkableReference = new AtomicMarkableReference<Integer>(100,false);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("t1版本号是否被更改:" + atomicMarkableReference.isMarked());
            //睡眠1秒，是为了让t2线程也拿到同样的初始版本号
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicMarkableReference.compareAndSet(100, 101,false,true);
          
        },"t1").start();
        
        new Thread(() -> {
            boolean isMarked = atomicMarkableReference.isMarked();
            System.out.println("t2版本号是否被更改:" + isMarked);
            //睡眠3秒，是为了让t1线程执行
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("是否更改过:" + atomicMarkableReference.isMarked());
            System.out.println(atomicMarkableReference.compareAndSet(100, 2019,true,true) + "\t当前 值:" + atomicMarkableReference.getReference());
        },"t2").start();
    }
}
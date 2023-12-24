package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;

public class BlockQueue {

    public static void main(String[] args) {
        ArrayBlockingQueue blockQueue = new ArrayBlockingQueue(3);


        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        blockQueue.offer("a");
        blockQueue.offer("b");
        blockQueue.offer("c");

        blockQueue.peek();
//        try {
//            blockQueue.take ();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println(blockQueue.size());

    }
}

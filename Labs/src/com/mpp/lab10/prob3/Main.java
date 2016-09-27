package com.mpp.lab10.prob3;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
    private static Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {

        for(int i=0; i<10; i++){
            Queue q1 = new Queue();
            multipleCall(q1);
            System.out.println("Number of node: " + q1.countElement());
        }

        System.out.println("----------Safe---------");

        for(int i=0; i<10; i++){
            QueueSafe q1 = new QueueSafe();
            multipleCallThreadSafe(q1);
            System.out.println("Number of node: " + q1.countElement());
        }
    }

    private static void multipleCall(Queue queue){
        Runnable r = () -> {
            queue.add(1);
        };

        for(int i=0; i<100; i++){
            executor.execute(r);
        }
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){}
    }

    private static void multipleCallThreadSafe(QueueSafe queueSafe){
        Runnable r = () -> {
            queueSafe.add(1);
        };

        for(int i=0; i<100; i++){
            executor.execute(r);
        }
        try{
            Thread.sleep(10);
        } catch (InterruptedException e){}
    }
}
